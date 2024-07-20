package com.example.fragmenthero.data


data class Superhero(val id: Long,
                     val images: Images,
                     val name: String,
                     val biography: Biography,
                     val appearance: Appearance
)

data class Appearance(val gender: String, val race: String)

data class Biography(val fullName: String)

data class Images(val sm: String, val md: String)