package pt.rafaelr22.cinemabookingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pt.rafaelr22.cinemabookingapp.data.model.Movie

@Composable
fun MovieDetailsScreen(
    movie: Movie,
    onBookTicketClick: () -> Unit,
    onBackHome: () -> Unit
)
{

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
            text = "Movie Details",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(movie.title)
        Text("Genre: ${movie.genre}")
        Text("Duration: ${movie.duration}")

        Spacer(modifier = Modifier.height(16.dp))

        Text(movie.description)

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBookTicketClick
        ) {
            Text("Book Ticket")
        }

        Button(
            onClick = onBackHome
        ) {
            Text("Return Home")
        }
    }
}