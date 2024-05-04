package com.example.tugas_infinitelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tugas_infinitelearning.navigation.Navigations
import com.example.tugas_infinitelearning.ui.theme.TugasInfiniteLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasInfiniteLearningTheme {
                Navigations()
            }
        }
    }
}