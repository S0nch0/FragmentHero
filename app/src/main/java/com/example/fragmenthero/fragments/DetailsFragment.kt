package com.example.fragmenthero.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.fragmenthero.R
import com.example.fragmenthero.data.Superhero

class DetailsFragment: Fragment() {
    companion object {
        lateinit var superhero: Superhero

        fun setSuperHero(superheroes: Superhero): DetailsFragment {
            val fragment = DetailsFragment()
            superhero = superheroes
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = view.findViewById<ImageView>(R.id.imageView2)
        Glide.with(imageView)
            .load(superhero?.images?.md)
            .into(imageView)
        val tvCharacterName = view.findViewById<TextView>(R.id.tvCharacterName)
        tvCharacterName.text = "Name: ${superhero?.name}"
        val tvCharacterFullName = view.findViewById<TextView>(R.id.tvCharacterFullName)
        tvCharacterFullName.text = "Full name: ${superhero?.biography?.fullName?:"-"}"
        val tvGender = view.findViewById<TextView>(R.id.tvGender)
        tvGender.text = "Gender: ${superhero?.appearance?.gender?:"-"}"
        val tvRace = view.findViewById<TextView>(R.id.tvRace)
        tvRace.text = "Race: ${superhero?.appearance?.race?:"-"}"
    }

}