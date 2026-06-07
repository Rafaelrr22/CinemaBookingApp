package pt.rafaelr22.cinemabookingapp.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pt.rafaelr22.cinemabookingapp.data.model.Movie
import pt.rafaelr22.cinemabookingapp.ui.components.MovieCard

@Composable
fun HomeScreen(
    onMovieClick: (Movie) -> Unit,
    onHistoryClick: () -> Unit
)
{

    val movies = listOf(
        Movie(
            id = 1,
            title = "Dune: Part Two",
            genre = "Sci-Fi",
            duration = "166 min",
            description = "Paul Atreides unites with the Fremen..."
        ),
        Movie(
            id = 2,
            title = "Deadpool & Wolverine",
            genre = "Action",
            duration = "127 min",
            description = "Deadpool joins forces with Wolverine..."
        ),
        Movie(
            id = 3,
            title = "Oppenheimer",
            genre = "Drama",
            duration = "180 min",
            description = "The story of J. Robert Oppenheimer..."
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 48.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {

        Text(
            text = "Cinema Booking",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        movies.forEach { movie ->
            MovieCard(
                movie = movie,
                onClick = {
                    onMovieClick(movie)
                }
            )

        }

        Button(
            onClick = onHistoryClick
        ) {
            Text("Booking History")
        }



    }


}