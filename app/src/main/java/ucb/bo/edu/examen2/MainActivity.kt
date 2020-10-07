package ucb.bo.edu.examen2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar.let {
            it?.setDisplayHomeAsUpEnabled(true)
        it?.setDisplayShowHomeEnabled(true)
    }
        val list = arrayListOf<Book>()
        list.add(Book("cronicas","345","buenas nuevas","marquez","familia adinerada pasa por un drama al perder su fortuna","https://images.app.goo.gl/qJmCh4kuWcvZ4Zn47"))

        RecyclerViewBooks.adapter = BookListAdapter (list, applicationContext)
        val linearLayoutManager =  LinearLayoutManager (applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        RecyclerViewBooks.layoutManager = linearLayoutManager
GlobalScope.launch {
    val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
    val repository = BookRepository(bookDao)
    repository.insert(Book("cronicas","345","buenas nuevas","marquez","familia adinerada pasa por un drama al perder su fortuna","https://images.app.goo.gl/qJmCh4kuWcvZ4Zn47"))
        val lista = repository.getListBook()
        lista.forEach {
            Log.d("DBTES","Id book = ${it.id}, Title: ${it.title}")

        }

        }

    }
}