package com.example.mysoothe.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun SootheButton(
    label: String,
    isPrimary: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val backgroundColor =
        if (isPrimary) MaterialTheme.colors.primary else MaterialTheme.colors.secondary
    val contentColor =
        if (isPrimary) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSecondary

    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(horizontal = 16.dp),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = MaterialTheme.shapes.medium,
        onClick = onClick
    ) {
        Text(label.toUpperCase(Locale.getDefault()))
    }
}

@Composable
fun SootheTextField(
    label: String,
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int? = null
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        value = "",
        onValueChange = {},
        label = {
            Text(
                label,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.wrapContentHeight(Alignment.CenterVertically)
            )
        },
        colors = with(MaterialTheme.colors) {
            TextFieldDefaults.textFieldColors(textColor = primary, backgroundColor = surface)
        },
        leadingIcon = { iconRes?.let { Icon(it) } }
    )
}

@Composable
private fun Icon(@DrawableRes iconRes: Int) {
    Icon(
        painter = painterResource(iconRes),
        contentDescription = null,
        modifier = Modifier.size(18.dp)
    )
}