package com.example.firstapplication

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
import com.example.firstapplication.ui.theme.FirstApplicationTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Hello(
                        name = null,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
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
    FirstApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    Text(
        text = if (name != null) "Привет, $name!" else "Имя не задано",
        modifier = modifier.fillMaxSize()
    )
}

@Preview(name = "portrait", showSystemUi = true)
@Preview(name = "landscape", showSystemUi = true, device = "spec:width=411dp,height=891dp,orientation=landscape")
@Preview(name = "round", showSystemUi = true, showBackground = true, backgroundColor = 0xFFFFFF00, device = "spec:width=200dp,height=200dp,dpi=320,isRound=true")
@Composable
fun HelloPreview() {
    FirstApplicationTheme {
        Hello("Алиса")
    }
}

@Composable
fun ComposeTexts(modifier: Modifier = Modifier) {
    val text = stringResource(R.string.compose_description)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)   // отступ 16dp между вариантами
    ) {
        // 3.1 — зелёный, 16.sp, курсив, по центру
        Text(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
        )

        // 3.2 — одна строка, в конце многоточие
        Text(
            text = text,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        // 3.3 — отступ первой строки 48.sp, 24.sp, чёрный, зелёный фон, подчёркнут
        Text(
            text = text,
            modifier = Modifier.background(Color.Green),
            color = Color.Black,
            fontSize = 24.sp,
            textDecoration = TextDecoration.Underline,
            style = TextStyle(textIndent = TextIndent(firstLine = 48.sp)),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeTextsPreview() {
    FirstApplicationTheme {
        ComposeTexts()
    }
}

@Composable
fun GrayButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        ),
    ) {
        Text(text = "Нажми на меня", fontSize = 18.sp)
    }
}

@Preview(name = "portrait", showSystemUi = true)
@Composable
fun ButtonPreview() {
    FirstApplicationTheme {
        GrayButton()
    }
}