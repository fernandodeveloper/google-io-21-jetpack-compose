package br.com.fernandodeveloper.jetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }) {
        Text(text = "I've been clicked $count times.")
    }
}

@Composable
fun MyScreenContent(listOfNames: List<String> = listOf("Android", "Fernando", "You")) {
    var counter = 0
    /*var counter by remember {
        mutableStateOf(0)
    }*/
    Column {
        for (name in listOfNames) {
            Greeting(name = name)
            Divider()
        }
        Counter(count = counter,
            updateCount = { newCount ->
                counter = newCount
            })

        Divider()



        if (counter > 5) {
            Text(text = "I love count!")
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