package pt.rafaelr22.cinemabookingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pt.rafaelr22.cinemabookingapp.navigation.AppNavigation
import pt.rafaelr22.cinemabookingapp.ui.theme.CinemaBookingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CinemaBookingAppTheme {
                AppNavigation()
            }
        }
    }
}