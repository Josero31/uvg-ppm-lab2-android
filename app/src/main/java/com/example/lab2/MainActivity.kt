package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AppContent() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Jose",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

/**
 * Composable que muestra un mensaje de saludo en pantalla.
 *
 * @param name Nombre de la persona a saludar.
 * @param modifier Modificador para aplicar estilos o comportamientos al componente.
 */
@Composable
fun Greeting(
    name: String, // Nombre que se mostrará en el saludo
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier // Modificador opcional para el componente
) {
    Text( // Componente que muestra texto en pantalla
        text = "Hello $name!", // Texto que se mostrará, incluyendo el nombre recibido
        modifier = modifier // Aplica el modificador recibido como parámetro
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab2Theme {
        AppContent()
    }
}