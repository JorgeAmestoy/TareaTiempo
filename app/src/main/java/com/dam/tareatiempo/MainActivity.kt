package com.dam.tareatiempo

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dam.tareatiempo.ui.theme.TareaTiempoTheme

class MainActivity : ComponentActivity() {

    private var tiempoInicio: Long = 0;
    val TAG: String = "situacion"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TareaTiempoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        tiempoInicio = SystemClock.elapsedRealtime()
    }

    override fun onPause(){
        super.onPause()
        val tiempoActual= SystemClock.elapsedRealtime()
        val tiempoActivo = tiempoActual - tiempoInicio
        Log.d(TAG, "Tiempo activo fue de: $tiempoActivo ms" )
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TareaTiempoTheme {
        Greeting("Android")
    }
}