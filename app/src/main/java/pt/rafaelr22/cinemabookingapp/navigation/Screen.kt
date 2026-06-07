package pt.rafaelr22.cinemabookingapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object MovieDetails : Screen("movie_details")
    object SeatSelection : Screen("seat_selection")

    object BookingConfirmation : Screen("booking_confirmation")

    object BookingHistory : Screen("booking_history")
}