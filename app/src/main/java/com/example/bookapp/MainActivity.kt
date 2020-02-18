package com.example.bookapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bookapp.ui.booklist.BookListFragment
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

}
