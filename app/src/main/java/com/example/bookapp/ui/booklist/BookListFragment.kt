package com.example.bookapp.ui.booklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookapp.R
import com.example.bookapp.domain.Book
import com.example.bookapp.ui.bookdetails.BookDetailsViewModel
import kotlinx.android.synthetic.main.fragment_book_list.*
import kotlinx.android.synthetic.main.fragment_book_list.view.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookListFragment : Fragment() {

    private val viewModel: BookListViewModel by viewModel()

    private val sharedViewModel: BookDetailsViewModel by sharedViewModel()

    private val adapter = BookListRecyclerViewAdapter(object : OnListFragmentInteractionListener {
        override fun onListFragmentInteraction(book: Book) {
            sharedViewModel.book = book
            findNavController().navigate(R.id.bookDetailsFragment)
        }

        override fun onLongListFragmentInteraction(book: Book) {
            viewModel.saveBook(book).observe(viewLifecycleOwner, Observer {
                if (it.isSuccess) {
                    Toast.makeText(context, R.string.save_successful, Toast.LENGTH_SHORT).show()
                    viewModel.getFavorites()
                } else {
                    Toast.makeText(context, R.string.save_unsuccessful, Toast.LENGTH_SHORT).show()
                }
            })
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)
        with(view.booklist_recyclerview) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@BookListFragment.adapter
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.books.observe(viewLifecycleOwner, Observer {
            if (it.isSuccess) {
                adapter.books = it.getOrDefault(emptyList())
                adapter.notifyDataSetChanged()
                booklist_recyclerview.visibility = View.VISIBLE
            } else {
                booklist_error_textview.visibility = View.VISIBLE
                booklist_recyclerview.visibility = View.GONE
            }
            booklist_progressbar.visibility = View.GONE
        })

        viewModel.favorites.observe(viewLifecycleOwner, Observer {
            if (it.isSuccess) {
                adapter.favorites = it.getOrDefault(emptyList())
                adapter.notifyDataSetChanged()
            }
        })

        booklist_search_button.setOnClickListener {
            booklist_progressbar.visibility = View.VISIBLE
            booklist_error_textview.visibility = View.GONE
            viewModel.searchBooks(booklist_search_edittext.text.toString())
        }

        viewModel.searchBooks("Metro 2033")
        viewModel.getFavorites()
    }

    interface OnListFragmentInteractionListener {

        fun onListFragmentInteraction(book: Book)

        fun onLongListFragmentInteraction(book: Book)

    }

}