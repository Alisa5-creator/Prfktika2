package com.example.firstapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapplication.ui.theme.FirstApplicationTheme

// 6.1 — круг исходного размера в правом верхнем углу, чёрный фон 240×120
@Composable
fun CircleTopEnd(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(240.dp, 120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Оранжевый круг"
        )
    }
}

// 6.2 — синий фон, круг по центру, растянут по размерам, фиолетовый
@Composable
fun CircleStretched(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(240.dp, 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Фиолетовый круг",
            modifier = Modifier.fillMaxSize(),            // занять весь Box
            contentScale = ContentScale.FillBounds,      // растянуть без сохранения пропорций → эллипс
            colorFilter = ColorFilter.tint(Color(0xFF800080))  // перекрасить в фиолетовый
        )
    }
}

@Preview(name = "6.1", showSystemUi = true)
@Composable
fun CircleTopEndPreview() {
    FirstApplicationTheme { CircleTopEnd() }
}

@Preview(name = "6.2", showSystemUi = true)
@Composable
fun CircleStretchedPreview() {
    FirstApplicationTheme { CircleStretched() }
}