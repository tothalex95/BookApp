package com.example.bookapp.ui.booklist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.R
import com.example.bookapp.domain.Book
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_book.view.*

class BookListRecyclerViewAdapter(
    private val listener: BookListFragment.OnListFragmentInteractionListener
) : RecyclerView.Adapter<BookListRecyclerViewAdapter.ViewHolder>() {

    var books = emptyList<Book>()
    var favorites = emptyList<Book>()

    private val onClickListener = View.OnClickListener {
        listener.onListFragmentInteraction(it.tag as Book)
    }

    private val onLongClickListener = View.OnLongClickListener {
        listener.onLongListFragmentInteraction(it.tag as Book)
        return@OnLongClickListener true
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(books[position])

    override fun getItemCount(): Int = books.size

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(book: Book) {
            with(view) {
                tag = book

                book_title_textview.text = book.title
                book_authors_textview.text = book.authors?.toString()
                book_publisher_textview.text = book.publisher
                Picasso.get()
                    .load(book.thumbnail)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(book_thumbnail_imageview)

                setOnClickListener(onClickListener)

                if (favorites.contains(book)) {
                    setBackgroundColor(Color.CYAN)
                } else {
                    setOnLongClickListener(onLongClickListener)
                }
            }
        }

    }

}