package com.example.mysoothe.welcome

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysoothe.R
import com.example.mysoothe.composable.SootheButton
import com.example.mysoothe.ui.theme.MySootheTheme

@Composable
fun WelcomeScreen(onLogInClicked: () -> Unit = {}) {
    Surface(
        Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold {
            val isDarkTheme = isSystemInDarkTheme()

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(
                    if (isDarkTheme) R.drawable.dark_welcome else R.drawable.light_welcome
                ),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
            Column(
                Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(
                        if (isDarkTheme) R.drawable.dark_logo else R.drawable.light_logo
                    ),
                    contentDescription = "My Soothe logo"
                )
                SootheButton(
                    modifier = Modifier.padding(top = 32.dp, bottom = 8.dp),
                    label = "Sign up",
                    isPrimary = true
                )
                SootheButton(
                    label = "Log in",
                    isPrimary = false,
                    onClick = onLogInClicked
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeLightPreview() {
    MySootheTheme { WelcomeScreen() }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeDarkPreview() {
    MySootheTheme { WelcomeScreen() }
}
