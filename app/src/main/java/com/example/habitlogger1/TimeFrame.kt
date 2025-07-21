package com.example.habitlogger1
import androidx.compose.runtime.Composable

interface TimeFrame {
    fun getCurrentProgress(): Float
    fun getCurrentTally(): String
    fun getCurrentTarget(): String

    fun getStreak(): Int

    @Composable
    fun TimeFrameOptions()
    @Composable
    fun StreakDashboard()
}