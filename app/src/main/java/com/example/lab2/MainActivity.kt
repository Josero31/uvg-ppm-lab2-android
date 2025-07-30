package com.example.lab2

// Importaciones necesarias para la actividad y componentes de Jetpack Compose
import android.annotation.SuppressLint // Permite suprimir advertencias específicas del compilador
import android.os.Bundle // Proporciona la clase Bundle para pasar datos entre actividades
import androidx.activity.ComponentActivity // Clase base para actividades que usan Compose
import androidx.activity.compose.setContent // Permite definir el contenido de la actividad usando Compose
import androidx.activity.enableEdgeToEdge // Habilita el modo edge-to-edge en la actividad
import androidx.compose.foundation.layout.fillMaxSize // Modificador para que el componente ocupe todo el espacio disponible
import androidx.compose.foundation.layout.padding // Modificador para agregar espacio alrededor de un componente
import androidx.compose.material3.Scaffold // Componente de estructura básica para pantallas (barra superior, contenido, etc.)
import androidx.compose.material3.Text // Componente para mostrar texto en pantalla
import androidx.compose.runtime.Composable // Indica que una función es composable (puede usarse en Compose)
import androidx.compose.ui.Modifier // Permite modificar el comportamiento y apariencia de los componentes
import androidx.compose.ui.tooling.preview.Preview // Permite previsualizar composables en el editor
import com.example.lab2.ui.theme.Lab2Theme // Importa el tema personalizado de la aplicación
import androidx.compose.ui.graphics.Color // Importa el manejo de colores
import androidx.compose.foundation.background // Importa el modificador de fondo
import androidx.compose.ui.Alignment // Importa alineación para centrar el texto
import androidx.compose.foundation.layout.fillMaxWidth // Importa modificador para ocupar todo el ancho
import androidx.compose.foundation.layout.wrapContentWidth // Importa modificador para centrar contenido
import androidx.compose.ui.unit.dp // Importa la unidad dp para el padding
import androidx.compose.foundation.layout.Box // Importa Box para envolver el contenido

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
 * Composable principal que define la estructura de la interfaz de usuario.
 * Utiliza Scaffold para organizar la pantalla y llama al composable Greeting.
 */
@Composable
fun AppContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan) // Fondo celeste para toda la pantalla
    ) {
        Scaffold(
            containerColor = Color.Transparent, // Hace el fondo del Scaffold transparente
        ) { innerPadding -> // innerPadding es el espacio interno que Scaffold proporciona a su contenido
            Greeting( // Llama al composable Greeting para mostrar el saludo
                name = "Jose", // Parámetro que indica el nombre a mostrar en el saludo
                modifier = Modifier
                    .padding(innerPadding) // Aplica el padding proporcionado por Scaffold
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally) // Centra el texto horizontalmente
                    .padding(top = 64.dp) // Baja el texto desde la parte superior
            )
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
    name: String, // Nombre que se mostrará en el saludo
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier // Modificador opcional para el componente
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