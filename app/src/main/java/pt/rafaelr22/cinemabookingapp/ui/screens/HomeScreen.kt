package pt.rafaelr22.cinemabookingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pt.rafaelr22.cinemabookingapp.data.model.Movie

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "Cinema Booking",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        val movies = listOf(
            Movie(
                1,
                "Dune: Part Two",
                "Sci-Fi",
                "166 min",
                "Paul Atreides unites with the Fremen..."
            ),
            Movie(
                2,
                "Deadpool & Wolverine",
                "Action",
                "127 min",
                "Deadpool joins forces with Wolverine..."
            )
        )
        movies.forEach { movie ->
            Text(text = movie.title)
        }
    }
}