package br.com.fernandodeveloper.jetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    var isSelected by remember {
        mutableStateOf(false)
    }

    val targetColour by animateColorAsState(
        targetValue = if (isSelected) Color.Green else Color.Transparent,
        animationSpec = tween(durationMillis = 3000)
    )


    Surface(color = targetColour) {
        Text(
            text = "Hello $name!",
            modifier = modifier
                .padding(16.dp)
                .clickable {
                    isSelected = !isSelected
                },
        )
    }
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
    var counter by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(names = List(1000) { "Hello Android $it" }, modifier = Modifier.weight(1f))
        Counter(count = counter,
            updateCount = { newCount ->
                counter = newCount
            })

        if (counter > 5) {
            Text(text = "I love count!")
        }
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) {
            Greeting(name = it)
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