package com.example.bookapp.ui.bookdetails

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.bookapp.R
import com.example.bookapp.databinding.BookDetailsFragmentBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class BookDetailsFragment : Fragment() {

    private val viewModel: BookDetailsViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.book_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val binding = DataBindingUtil.setContentView<BookDetailsFragmentBinding>(
            activity as Activity,
            R.layout.book_details_fragment
        )

        binding.vm = viewModel
    }

}
