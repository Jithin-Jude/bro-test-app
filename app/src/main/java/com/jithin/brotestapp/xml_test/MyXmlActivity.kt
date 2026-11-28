package com.jithin.brotestapp.xml_test

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import com.jithin.brotestapp.R
import com.jithin.brotestapp.databinding.ActivityMyXmlBinding

class MyXmlActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyXmlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMyXmlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "My Activity Title"

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
    }
}