package it.justonetouch.kotlinexample.dummy

object HeroDummyContent {
    private val MALE = "Male"
    private val FEMALE = "Female"

    val ITEMS = listOf(
            HeroItem("Hulk", MALE, 9),
            HeroItem("Iron Man", MALE, 8),
            HeroItem("Thor", MALE, 8),
            HeroItem("Jessica Jones", FEMALE, 2),
            HeroItem("Spiderman", MALE, 4)
    )
}
