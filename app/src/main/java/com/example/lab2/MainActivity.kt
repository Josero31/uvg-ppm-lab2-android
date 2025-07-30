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
    /**
     * Método que se llama cuando la actividad es creada.
     * @param savedInstanceState Estado guardado de la actividad (si existe).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al método de la clase padre
        enableEdgeToEdge() // Habilita el modo edge-to-edge para la interfaz
        setContent { // Define el contenido de la actividad usando Compose
            Lab2Theme { // Aplica el tema personalizado a la interfaz
                AppContent() // Llama al composable principal que contiene la UI
            }
        }
    }
}

@Composable
fun AppContent() {
    Scaffold( // Proporciona una estructura básica para la pantalla
        modifier = Modifier.fillMaxSize() // Hace que el Scaffold ocupe todo el espacio disponible
    ) { innerPadding -> // innerPadding es el espacio interno que Scaffold proporciona a su contenido
        Greeting( // Llama al composable Greeting para mostrar el saludo
            name = "Jose", // Parámetro que indica el nombre a mostrar en el saludo
            modifier = Modifier.padding(innerPadding) // Aplica el padding proporcionado por Scaffold
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