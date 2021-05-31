package com.example.mysoothe.welcome

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mysoothe.ui.theme.MySootheTheme

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            MySootheTheme {
                WelcomeScreen(onLogInClicked = ::navigateToLogin)
            }
        }
    }

    private fun navigateToLogin() {
        val direction = WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment()

        findNavController().navigate(direction)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LightPreview() {
    MySootheTheme { WelcomeScreen() }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    MySootheTheme { WelcomeScreen() }
}