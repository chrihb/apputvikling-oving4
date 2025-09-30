package ntnu.idi.oving4

// Movie enum class representing different movies with their details
enum class Movie(
    val title: String,
    val imageRes: Int,
    val description: String
) {
    INTERSTELLAR(
        "Interstellar",
        ntnu.idi.oving4.R.drawable.interstellar,
        "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans."
    ),
    DJANGO_UNCHAINED(
        "Django Unchained",
        R.drawable.django,
        "With the help of a German bounty-hunter, a freed slave sets out to rescue his wife from a brutal plantation owner in Mississippi."
    ),
    STAR_WARS_RETURN_OF_THE_SITH(
        "Star Wars - Return for the Sith",
        R.drawable.starwars,
        "As the Clone Wars nears its end, Obi-Wan Kenobi pursues a new threat, while Anakin Skywalker is lured by Chancellor Palpatine into a sinister plot for galactic domination."
    ),
    A_MINECRAFT_MOVIE(
        "A Minecraft Movie",
        R.drawable.minecraft,
        "Four misfits are suddenly pulled through a mysterious portal into a bizarre cubic wonderland that thrives on imagination. To get back home they'll have to master this world while embarking on a quest with an unexpected expert crafter."
    );
}