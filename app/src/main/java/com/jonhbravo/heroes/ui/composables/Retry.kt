package com.jonhbravo.heroes.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jonhbravo.heroes.R

@Composable
fun Retry(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_angry_hulk),
            contentDescription = null
        )
        Text(
            text = "Algo paso, intenta de nuevo",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Reintentar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RetryPreview() {
    Retry({})
}