package pt.rafaelr22.cinemabookingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pt.rafaelr22.cinemabookingapp.ui.screens.HomeScreen
import pt.rafaelr22.cinemabookingapp.ui.screens.MovieDetailsScreen
import pt.rafaelr22.cinemabookingapp.ui.screens.SeatSelectionScreen
import pt.rafaelr22.cinemabookingapp.ui.screens.BookingConfirmationScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(
                onMovieClick = {
                    navController.navigate(Screen.MovieDetails.route)
                }
            )
        }

        composable(Screen.MovieDetails.route) {
            MovieDetailsScreen(
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
    }
}