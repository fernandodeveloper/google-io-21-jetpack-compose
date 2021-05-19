package br.com.fernandodeveloper.jetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fernandodeveloper.jetcompose.ui.theme.JetComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp() {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
            .padding(16.dp)
    )
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetComposeBasicsTheme {
        content()
    }
}

@Composable
fun MyScreenContent(listOfNames: List<String> = listOf("Android", "Fernando", "You")) {
    Column() {
        for (name in listOfNames) {
            Greeting(name = name)
            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp() {
        MyScreenContent()

    }
}