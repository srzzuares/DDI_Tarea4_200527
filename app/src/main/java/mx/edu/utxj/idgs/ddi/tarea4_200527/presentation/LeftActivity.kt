package mx.edu.utxj.idgs.ddi.tarea4_200527.presentation

import android.os.Bundle
import mx.edu.utxj.idgs.ddi.tarea4_200527.R

class LeftActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // ...
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_left)
    }

    private fun setContentView(activityLeft: Int) {
        TODO("Not yet implemented")
    }
}

open class AppCompatActivity {
    open fun onCreate(savedInstanceState: Bundle?) {

    }

}