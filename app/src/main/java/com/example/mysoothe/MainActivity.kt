package com.example.mysoothe

import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_main)
    }
}
