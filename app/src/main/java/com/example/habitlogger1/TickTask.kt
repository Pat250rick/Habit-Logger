package com.example.habitlogger1
import android.os.Parcel
import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habitlogger1.ui.theme.HabitLogger1Theme
import kotlin.math.max
import kotlin.math.min
import com.example.habitlogger1.Task

class TickTask : Task {
    private var curTally: Int = 0
    private var curTarget: Int = 3
    private lateinit var timeFrame: TimeFrame

    @Composable
    override fun TaskOptions () {
        println(1+1)
    }

    @Composable
    override fun TaskPage(modifier: Modifier) {
        var progressText by remember { mutableStateOf("${getCurrentTally()} / ${getCurrentTarget()}") }
        var progressValue by remember { mutableFloatStateOf(getNowProgress()) }

        Column (
            modifier = modifier.wrapContentSize()
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .clickable()
                    {
                        curTally++

                        progressText = "$curTally / $curTarget"
                        progressValue = getNowProgress()
                    },
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(
                    progress = { -1.0f },
                    modifier = modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .padding(5.dp)
                        .padding(32.5.dp),
                    trackColor = Color.DarkGray,
                    strokeWidth = 10.dp
                )
                CircularProgressIndicator(
                    progress = {
                        progressValue
                               },
                    modifier = modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .padding(5.dp)
                        .padding(15.dp),
                    trackColor = ProgressIndicatorDefaults.circularIndeterminateTrackColor,
                    strokeWidth = 50.dp
                )
                Text(
                    text = progressText,
                    modifier = modifier,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                )
            }
            Row(
                modifier = modifier.fillMaxWidth()
            ){
                Button(
                    modifier = modifier.fillMaxWidth(0.5f).padding(start = 15.dp, end = 7.5.dp, top = 5.dp, bottom = 5.dp),
                    onClick = {
                        curTally = max(0,curTally-1)

                        progressText = "${getCurrentTally()} / ${getCurrentTarget()}"
                        progressValue = getNowProgress()
                    }
                ){
                    Text(
                        text = "-",
                        modifier = modifier,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    modifier = modifier.fillMaxWidth().padding(start = 7.5.dp, end = 15.dp, top = 5.dp, bottom = 5.dp),
                    onClick = {
                        curTally++

                        progressText = "${getCurrentTally()} / ${getCurrentTarget()}"
                        progressValue = getNowProgress()
                    }
                ){
                    Text(
                        text = "+",
                        modifier = modifier,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        }
    }

    private fun getNowProgress (): Float {
        return min(getCurrentTally().toFloat()/getCurrentTarget().toFloat(),1f)
    }

    private fun getCurrentTally(): Int{
        return curTally
    }

    private fun getCurrentTarget(): Int{
        return curTarget
    }

//    @Preview(showBackground = true)
//    @Composable
//    fun TaskPagePreview(){
//        HabitLogger1Theme {
//            val task = TickTask()
//            task.TaskPage(Modifier)
//        }
//    }
}

