package pt.rafaelr22.cinemabookingapp.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import pt.rafaelr22.cinemabookingapp.data.model.Seat

@Composable
fun SeatItem(
    seat: Seat,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick
    ) {
        Text("${seat.row}${seat.number}")
    }
}