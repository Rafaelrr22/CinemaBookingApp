package pt.rafaelr22.cinemabookingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieDetailsScreen(
    movieTitle: String,
    onBookTicketClick: () -> Unit
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

        Text(movieTitle)
        Text("Genre: Sci-Fi")
        Text("Duration: 166 min")

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Paul Atreides unites with the Fremen to seek revenge against those who destroyed his family."
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onBookTicketClick
        ) {
            Text("Book Ticket")
        }
    }
}