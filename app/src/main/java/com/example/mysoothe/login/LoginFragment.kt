package com.example.mysoothe.login

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

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            MySootheTheme {
                LogInScreen(::navigateToHome)
            }
        }
    }

    private fun navigateToHome() {
        val direction = LoginFragmentDirections.actionLoginFragmentToHomeFragment()

        findNavController().navigate(direction)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LightPreview() {
    MySootheTheme { LogInScreen() }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DarkPreview() {
    MySootheTheme { LogInScreen() }
}