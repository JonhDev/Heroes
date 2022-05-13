package com.jonhbravo.heroes.utils

data class FakeHero(
    val name: String,
    val author: String,
    val description: String
)

val heroes = listOf(
    FakeHero(
        "Capitan America",
        "Jonathan Bravo",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    ),
    FakeHero(
        "Spider-man",
        "Jonathan Bravo",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    ),
    FakeHero(
        "Iron-man",
        "Jonathan Bravo",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    ),
    FakeHero(
        "Thor",
        "Jonathan Bravo",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    ),
    FakeHero(
        "Hulk",
        "Jonathan Bravo",
        "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
    )
)