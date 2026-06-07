package pt.rafaelr22.cinemabookingapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pt.rafaelr22.cinemabookingapp.data.model.Seat

@Composable
fun SeatSelectionScreen(
    reservedSeats: List<String>,
    onConfirmBooking: (String) -> Unit,
    onBackHome: () -> Unit
) {

    var selectedSeat by remember {
        mutableStateOf<Seat?>(null)
    }

    val seats = listOf(
        Seat('A',1), Seat('A',2), Seat('A',3), Seat('A',4),
        Seat('B',1), Seat('B',2), Seat('B',3), Seat('B',4),
        Seat('C',1), Seat('C',2), Seat('C',3), Seat('C',4)
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
            text = "Select Your Seat",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.height(250.dp)
        ) {

            items(seats) { seat ->

                val seatCode =
                    "${seat.row}${seat.number}"

                val isOccupied =
                    seatCode in reservedSeats

                Button(
                    onClick = {
                        selectedSeat = seat
                    },
                    enabled = !isOccupied,
                    modifier = Modifier.padding(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                            when {
                                isOccupied -> Color.Red

                                selectedSeat == seat ->
                                    MaterialTheme.colorScheme.secondary

                                else ->
                                    MaterialTheme.colorScheme.primary
                            },

                        disabledContainerColor = Color(0xFFD32F2F),
                        disabledContentColor = Color.White
                    )
                ){
                    Text(seatCode)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = selectedSeat?.let {
                "Selected Seat: ${it.row}${it.number}"
            } ?: "No seat selected",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                selectedSeat?.let {
                    onConfirmBooking(
                        "${it.row}${it.number}"
                    )
                }
            },
            enabled = selectedSeat != null
        ) {
            Text("Confirm Booking")
        }

        Button(
            onClick = onBackHome
        ) {
            Text("Return Home")
        }
    }
}