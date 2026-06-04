package pt.rafaelr22.cinemabookingapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object MovieDetails : Screen("movie_details")
}