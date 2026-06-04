package pt.rafaelr22.cinemabookingapp.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pt.rafaelr22.cinemabookingapp.data.model.Movie

@Composable
fun MovieCard(movie: Movie) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = movie.genre
            )

            Text(
                text = movie.duration
            )
        }
    }
}