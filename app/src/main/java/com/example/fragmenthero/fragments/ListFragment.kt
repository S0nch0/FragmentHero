package com.example.fragmenthero.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenthero.R
import com.example.fragmenthero.data.RecyclerViewAdapter
import com.example.fragmenthero.api.ApiClient
import com.example.fragmenthero.api.ApiInterface
import com.example.fragmenthero.data.Superhero
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ListFragment: Fragment(), OnItemClickListener {

    private val disposable = CompositeDisposable()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listView = view.findViewById<RecyclerView>(R.id.listView)
        val request = ApiClient.client.create(ApiInterface::class.java)
            .getSuperheroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                listView.adapter  = RecyclerViewAdapter(it, this)

            },{ error ->
                Toast.makeText(view.context, error.message, Toast.LENGTH_LONG).show()
            })

        disposable.add(request)
        listView.layoutManager = LinearLayoutManager(view.context)
        listView.addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.HORIZONTAL))
    }


    override fun onItemClick(superhero: Superhero) {
        val detailsFragmentToAdd = DetailsFragment.setSuperHero(superhero)
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, detailsFragmentToAdd)
            .addToBackStack("DetailsFragment")
            .commit()
    }
}

interface OnItemClickListener {
    fun onItemClick(superhero: Superhero)
}












