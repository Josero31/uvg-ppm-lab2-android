package com.example.lab2 // Define el paquete donde se encuentra este archivo

// Importaciones necesarias para la actividad y componentes de Jetpack Compose
import android.os.Bundle // Proporciona la clase Bundle para pasar datos entre actividades
import androidx.activity.ComponentActivity // Clase base para actividades que usan Compose
import androidx.activity.compose.setContent // Permite definir el contenido de la actividad usando Compose
import androidx.activity.enableEdgeToEdge // Habilita el modo edge-to-edge en la actividad
import androidx.compose.foundation.background // Permite establecer un color de fondo
import androidx.compose.foundation.layout.* // Proporciona modificadores de layout como Box, Column, Spacer, etc.
import androidx.compose.material3.* // Proporciona componentes de Material3 como Button, Text, Scaffold, etc.
import androidx.compose.runtime.* // Proporciona funciones y clases para manejar estados en Compose
import androidx.compose.ui.Alignment // Permite alinear elementos dentro de layouts
import androidx.compose.ui.Modifier // Permite modificar el comportamiento y apariencia de los componentes
import androidx.compose.ui.graphics.Color // Permite trabajar con colores
import androidx.compose.ui.tooling.preview.Preview // Permite previsualizar composables en el editor
import androidx.compose.ui.unit.dp // Permite usar la unidad dp para medidas como padding
import com.example.lab2.ui.theme.Lab2Theme // Importa el tema personalizado de la aplicación
import kotlinx.coroutines.launch // Permite lanzar corutinas para tareas asíncronas

/**
 * Actividad principal de la aplicación.
 * Hereda de ComponentActivity para usar Jetpack Compose.
 */
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
 *
 * No recibe parámetros.
 */
@Composable
fun AppContent() {
    val snackbarHostState = remember { SnackbarHostState() } // Estado para mostrar mensajes snackbar
    val scope = rememberCoroutineScope() // Permite lanzar corutinas desde Compose
    var showText by remember { mutableStateOf(false) } // Estado para mostrar el saludo

    // Box que cubre toda la pantalla y aplica el fondo celeste
    Box(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el espacio disponible
            .background(Color.Cyan) // Aplica color de fondo celeste
    ) {
        // Scaffold organiza la estructura visual y permite mostrar snackbars
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) }, // Host para mostrar mensajes snackbar
        ) { innerPadding ->
            // Box centrado en la parte superior para mostrar el botón o el saludo
            Box(
                modifier = Modifier
                    .padding(innerPadding) // Aplica el padding interno del Scaffold
                    .fillMaxSize(), // Ocupa todo el espacio disponible
                contentAlignment = Alignment.TopCenter // Centra el contenido en la parte superior
            ) {
                if (showText) {
                    // Si showText es true, muestra el saludo
                    Greeting(
                        name = "Jose", // Nombre que se mostrará en el saludo
                        modifier = Modifier
                            .padding(top = 64.dp) // Separa el saludo de la parte superior
                    )
                } else {
                    // Si showText es false, muestra el botón
                    Button(
                        onClick = {
                            showText = true // Cambia el estado para mostrar el saludo
                            scope.launch {
                                snackbarHostState.showSnackbar("¡Hola desde el botón!") // Muestra un mensaje snackbar
                            }
                        },
                        modifier = Modifier
                            .padding(top = 64.dp) // Separa el botón de la parte superior
                    ) {
                        Text("Aprime el botón ") // Texto del botón que se muestra en pantalla
                    }
                }
            }
        }
    }
}

/**
 * Composable que muestra un mensaje de saludo en pantalla.
 * @param name Nombre de la persona a saludar.
 * @param modifier Modificador para aplicar estilos o comportamientos al componente.
 */
@Composable
fun Greeting(
    name: String, // Nombre que se mostrará en el saludo
    modifier: Modifier = Modifier // Modificador opcional para el componente
) {
    Text( // Componente que muestra texto en pantalla
        text = "Hello $name!", // Texto que se mostrará, incluyendo el nombre recibido
        modifier = modifier // Aplica el modificador recibido como parámetro
    )
}

/**
 * Composable para previsualizar la interfaz en el editor de Android Studio.
 * Permite ver cómo se verá la pantalla sin ejecutar la app.
 */
@Preview(showBackground = true) // Indica que se debe mostrar el fondo en la previsualización
@Composable
fun GreetingPreview() {
    Lab2Theme { // Aplica el tema personalizado en la previsualización
        AppContent() // Muestra el contenido principal de la app
    }
}