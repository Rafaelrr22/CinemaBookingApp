package pt.rafaelr22.cinemabookingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pt.rafaelr22.cinemabookingapp.ui.screens.HomeScreen
import pt.rafaelr22.cinemabookingapp.ui.screens.MovieDetailsScreen
import pt.rafaelr22.cinemabookingapp.ui.screens.SeatSelectionScreen
import pt.rafaelr22.cinemabookingapp.ui.screens.BookingConfirmationScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import pt.rafaelr22.cinemabookingapp.ui.screens.BookingHistoryScreen
import pt.rafaelr22.cinemabookingapp.viewmodel.BookingViewModel


@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val bookingViewModel: BookingViewModel = viewModel()


    if (bookingViewModel.reservations.isEmpty()) {
        bookingViewModel.addReservation(
            "Dune: Part Two",
            "A1"
        )

        bookingViewModel.addReservation(
            "Oppenheimer",
            "B3"
        )
    }


    // CODIGO QUE DEFINE ONE A APP VAI ABRIR
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(
                onMovieClick = { movie ->
                    navController.navigate(
                        Screen.MovieDetails.createRoute(movie.title)
                    )
                }
            )
        }

        composable(
            route = Screen.MovieDetails.route
        ) { backStackEntry ->

            val movieTitle =
                backStackEntry.arguments?.getString("movieTitle")
                    ?: "Unknown Movie"

            MovieDetailsScreen(
                movieTitle = movieTitle,
                onBookTicketClick = {
                    navController.navigate(Screen.SeatSelection.route)
                }
            )
        }

        composable(Screen.SeatSelection.route) {
            SeatSelectionScreen(
                onConfirmBooking = {
                    navController.navigate(Screen.BookingConfirmation.route)
                }
            )
        }

        composable(Screen.BookingConfirmation.route) {
            BookingConfirmationScreen(
                onBackHome = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }

        composable(Screen.BookingHistory.route) {

            BookingHistoryScreen(
                reservations = bookingViewModel.reservations
            )
        }
    }
}