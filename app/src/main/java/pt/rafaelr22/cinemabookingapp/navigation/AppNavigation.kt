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
import pt.rafaelr22.cinemabookingapp.data.model.Movie
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import pt.rafaelr22.cinemabookingapp.data.database.DatabaseProvider
import pt.rafaelr22.cinemabookingapp.data.repository.ReservationRepository
import pt.rafaelr22.cinemabookingapp.viewmodel.BookingViewModelFactory
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val context = LocalContext.current

    val database =
        DatabaseProvider.getDatabase(context)

    val repository =
        ReservationRepository(
            database.reservationDao()
        )

    val bookingViewModel: BookingViewModel =
        viewModel(
            factory = BookingViewModelFactory(
                repository
            )
        )

    var selectedMovieTitle by remember {
        mutableStateOf("")
    }
    var selectedSeat by remember {
        mutableStateOf("")
    }





    // CODIGO QUE DEFINE ONDE A APP VAI ABRIR
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route

    ) {

        composable(Screen.Home.route) {
            HomeScreen(
                onMovieClick = { movie ->

                    selectedMovieTitle = movie.title

                    navController.navigate(
                        Screen.MovieDetails.createRoute(movie.id)
                    )
                },
                onHistoryClick = {
                    navController.navigate(
                        Screen.BookingHistory.route
                    )
                }
            )
        }

        composable(
            route = Screen.MovieDetails.route
        ) { backStackEntry ->

            val movieId =
                backStackEntry.arguments?.getString("movieId")
                    ?.toIntOrNull() ?: 1

            val movie = when (movieId) {
                1 -> Movie(
                    1,
                    "Dune: Part Two",
                    "Sci-Fi",
                    "166 min",
                    "Paul Atreides unites with the Fremen..."
                )

                2 -> Movie(
                    2,
                    "Deadpool & Wolverine",
                    "Action",
                    "127 min",
                    "Deadpool joins forces with Wolverine..."
                )

                else -> Movie(
                    3,
                    "Oppenheimer",
                    "Drama",
                    "180 min",
                    "The story of J. Robert Oppenheimer..."
                )
            }

            MovieDetailsScreen(
                movie = movie,
                onBookTicketClick = {
                    navController.navigate(Screen.SeatSelection.route)
                },
                        onBackHome = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }

        composable(Screen.SeatSelection.route) {

            val reservedSeats by bookingViewModel
                .reservedSeats
                .collectAsState()

            SeatSelectionScreen(
                reservedSeats = reservedSeats,
                onConfirmBooking = { seat ->

                    selectedSeat = seat

                    bookingViewModel.addReservation(
                        selectedMovieTitle,
                        seat
                    )

                    navController.navigate(
                        Screen.BookingConfirmation.route
                    )
                },
                onBackHome = {
                    navController.navigate(
                        Screen.Home.route
                    )
                }
            )
        }

        composable(Screen.BookingConfirmation.route) {
            BookingConfirmationScreen(
                movieTitle = selectedMovieTitle,
                seat = selectedSeat,
                onBackHome = {
                    navController.navigate(Screen.Home.route)
                },
                onViewHistory = {
                    navController.navigate(Screen.BookingHistory.route)
                }
            )
        }

        composable(Screen.BookingHistory.route) {

            val reservations by bookingViewModel
                .reservations
                .collectAsState()

            BookingHistoryScreen(
                reservations = reservations,
                onClearHistory = {
                    bookingViewModel.clearHistory()
                },
                onBackHome = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }
    }
}