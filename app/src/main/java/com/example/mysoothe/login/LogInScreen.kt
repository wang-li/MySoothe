package com.example.mysoothe.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysoothe.R
import com.example.mysoothe.composable.SootheButton
import com.example.mysoothe.composable.SootheTextField
import com.example.mysoothe.ui.theme.MySootheTheme
import java.util.*

@Composable
fun LogInScreen(onLogInClicked: () -> Unit = {}) {
    Surface(
        Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold {
            val isDarkTheme = isSystemInDarkTheme()

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(
                    if (isDarkTheme) R.drawable.dark_login else R.drawable.light_login
                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Column(Modifier.fillMaxSize()) {
                LogInTitle()
                SootheTextField(label = "Email address")
                SootheTextField(
                    label = "Password",
                    modifier = Modifier.padding(top = 8.dp)
                )
                SootheButton(
                    label = "Log in",
                    isPrimary = true,
                    modifier = Modifier.padding(top = 8.dp),
                    onClick = onLogInClicked
                )
                LogInBottomText()
            }
        }
    }
}

@Composable
fun LogInTitle() {
    Text(
        "Log in".toUpperCase(Locale.getDefault()),
        Modifier
            .paddingFromBaseline(top = 200.dp, bottom = 32.dp)
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally),
        style = MaterialTheme.typography.h1
    )
}

@Composable
fun LogInBottomText() {
    Text(
        buildAnnotatedString {
            append("Don't have an account? ")

            withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                append("Sign up")
            }
        },
        Modifier
            .paddingFromBaseline(top = 32.dp)
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Preview(showBackground = true)
@Composable
fun LogInLightPreview() {
    MySootheTheme { LogInScreen() }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LogInDarkPreview() {
    MySootheTheme { LogInScreen() }
}
