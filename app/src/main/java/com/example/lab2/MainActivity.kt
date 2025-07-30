package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab2.ui.theme.Lab2Theme
import kotlinx.coroutines.launch

/**
 * Actividad principal de la aplicación.
 *
 * Esta clase inicializa la interfaz de usuario usando Jetpack Compose y aplica el tema personalizado.
 * El fondo de la pantalla se fuerza a celeste usando un Box raíz.
 */
class MainActivity : ComponentActivity() {
    /**
     * Método que se llama al crear la actividad.
     *
     * @param savedInstanceState Estado guardado de la actividad, si existe.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                /**
                 * Box raíz que fuerza el fondo celeste en toda la pantalla.
                 */
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Cyan) // ¡Fondo celeste garantizado!
                ) {
                    /**
                     * Composable principal que contiene la lógica de la pantalla.
                     */
                    AppContent()
                }
            }
        }
    }
}

/**
 * Composable que muestra la pantalla principal de la aplicación.
 *
 * Presenta un botón centrado en la parte superior. Al presionarlo, el botón es reemplazado por un saludo
 * en la misma posición y se muestra un mensaje tipo snackbar.
 *
 * Variables internas:
 * - snackbarHostState: Estado para mostrar mensajes snackbar.
 * - scope: Corutina para lanzar tareas asíncronas.
 * - showText: Estado booleano que determina si se muestra el saludo o el botón.
 */
@Composable
fun AppContent() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var showText by remember { mutableStateOf(false) }

    /**
     * Scaffold que organiza la estructura visual y permite mostrar snackbars.
     * Se configura con fondo transparente para que el color celeste del Box raíz sea visible.
     */
    Scaffold(
        modifier = Modifier.background(Color.Transparent), // Fondo transparente
        containerColor = Color.Transparent, // Fondo transparente
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        /**
         * Box centrado en la parte superior para mostrar el botón o el saludo.
         */
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            if (showText) {
                /**
                 * Muestra el saludo si showText es true.
                 */
                Greeting(
                    name = "Jose",
                    modifier = Modifier.padding(top = 64.dp)
                )
            } else {
                /**
                 * Muestra el botón si showText es false.
                 * El botón tiene color azul marino y texto blanco.
                 * Al presionarlo, muestra el saludo y un snackbar.
                 */
                Button(
                    onClick = {
                        showText = true
                        scope.launch {
                            snackbarHostState.showSnackbar("¡Hola desde el botón!")
                        }
                    },
                    modifier = Modifier.padding(top = 64.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0D47A1), // Azul marino
                        contentColor = Color.White // Texto blanco
                    )
                ) {
                    Text("Presiona el botón")
                }
            }
        }
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
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = Color.Black // Texto negro sobre cyan
    )
}

/**
 * Composable para previsualizar la interfaz en el editor de Android Studio.
 * Permite ver cómo se verá la pantalla sin ejecutar la app.
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab2Theme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
        ) {
            AppContent()
        }
    }
}