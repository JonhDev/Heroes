package com.jonhbravo.heroes.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jonhbravo.heroes.R
import com.jonhbravo.heroes.ui.theme.HeroesTheme

@Composable
fun HeroToolbar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Image(
            modifier = Modifier.padding(4.dp),
            painter = painterResource(id = R.drawable.ic_marvel_logo),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun HeroeToolbarPreview() {
    HeroesTheme {
        HeroToolbar(modifier = Modifier.fillMaxWidth())
    }
}