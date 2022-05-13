package com.jonhbravo.heroes.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jonhbravo.heroes.ui.theme.HeroesTheme
import com.jonhbravo.heroes.utils.cut

@Composable
fun HeroCard(
    name: String,
    author: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .wrapContentHeight()
            .height(200.dp)
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp
    ) {
        Row {
            Box(
                modifier = Modifier
                    .weight(1.3f)
                    .fillMaxSize()
                    .background(Color.Blue)
            )
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = name,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = author,
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(vertical = 4.dp),
                    text = description.cut(80),
                    style = MaterialTheme.typography.body1
                )
                TextWithIcon(
                    text = "Mas info",
                    icon = Icons.Default.ArrowForward
                )
            }
        }
    }
}

@Composable
fun TextWithIcon(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = text,
            style = MaterialTheme.typography.button
        )
        Icon(icon, contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHeroCard() {
    HeroesTheme {
        HeroCard(
            name = "Capitan America",
            author = "Jonathan Bravo",
            description = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500"
        )
    }
}