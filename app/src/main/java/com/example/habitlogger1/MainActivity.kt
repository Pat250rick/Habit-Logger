package com.example.habitlogger1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.habitlogger1.ui.theme.HabitLogger1Theme
import com.example.habitlogger1.Task

class MainActivity : ComponentActivity() {
    private var tasks = mutableListOf<Task>(
        TickTask()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitLogger1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    tasks[0].TaskPage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskPagePreview(){
    HabitLogger1Theme {
        TickTask().TaskPage(Modifier)
    }
}
