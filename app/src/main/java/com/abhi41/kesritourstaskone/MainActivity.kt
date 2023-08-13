package com.abhi41.kesritourstaskone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.abhi41.kesritourstaskone.presentation.TourPackageScreen
import com.abhi41.kesritourstaskone.ui.theme.KesriToursTaskOneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KesriToursTaskOneTheme {
                // A surface container using the 'background' color from the theme
                TourPackageScreen()
            }
        }
    }
}
