package com.example.mysoothe.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.example.mysoothe.ui.theme.MySootheTheme

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (view as ComposeView).setContent { MySootheTheme { HomeScreen() } }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LightPreview() {
    MySootheTheme { HomeScreen() }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    MySootheTheme { HomeScreen() }
}