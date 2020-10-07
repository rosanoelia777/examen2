package ucb.bo.edu.examen2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.book_row.view.*

class BookListAdapter(var list: ArrayList<Book>,var applicationContext: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val book = list[position]
        holder.itemView.textViewId.text= book.id.toString()
        holder.itemView.textViewTitle.text=book.title
        holder.itemView.textViewPages.text= book.pages
        holder.itemView.textViewEditorial.text=book.editorial
        holder.itemView.textViewAuthor.text=book.author
        holder.itemView.textViewDescription.text=book.description
        holder.itemView.textViewURL.text=book.photoUrl
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_row,parent,false)
        return BookListViewHolder(view)
    }

    class BookListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}
