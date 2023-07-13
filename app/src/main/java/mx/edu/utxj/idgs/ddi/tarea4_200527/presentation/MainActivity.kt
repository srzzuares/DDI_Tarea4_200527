

package mx.edu.utxj.idgs.ddi.tarea4_200527.presentation

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import mx.edu.utxj.idgs.ddi.tarea4_200527.R
import mx.edu.utxj.idgs.ddi.tarea4_200527.presentation.theme.Tarea4_200527Theme

class MainActivity : ComponentActivity() {

    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)setContentView(R.layout.activity_main)

        gestureDetector = GestureDetector(this, MyGestureListener())
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    inner class MyGestureListener : GestureDetector.SimpleOnGestureListener() {
        private val SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY_THRESHOLD = 100

        override fun onFling(
            event1: MotionEvent,
            event2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val diffX = event2.x - event1.x
            val diffY = event2.y - event1.y

            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        // Deslizamiento de izquierda a derecha, navegar a la actividad izquierda
                        val intent = Intent(this@MainActivity, LeftActivity::class.java)
                        startActivity(intent)
                    } else {
                        // Deslizamiento de derecha a izquierda, volver a la actividad principal
                        finish()
                    }
                    return true
                }
            }
            return super.onFling(event1, event2, velocityX, velocityY)
        }
    }
}

private infix fun Unit.setContentView(activityMain: Int) {

}
