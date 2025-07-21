package com.example.habitlogger1
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface Task {
    @Composable
    fun TaskOptions()
    @Composable
    fun TaskPage(modifier: Modifier = Modifier)
}