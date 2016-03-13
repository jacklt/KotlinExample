package it.justonetouch.kotlinexample.dummy

object HeroDummyContent {
    private val MALE = "Male"
    private val FEMALE = "Female"

    val ITEMS = listOf(
            HeroItem("Hulk", MALE, 9, eyes = "green"),
            HeroItem("Iron Man", MALE, 8, hair = "black"),
            HeroItem("Thor", MALE, 8, hair = "blonde", eyes = "blue"),
            HeroItem("Jessica Jones", FEMALE, 2, hair = "brown"),
            HeroItem("Spiderman", MALE, 4)
    )
}
