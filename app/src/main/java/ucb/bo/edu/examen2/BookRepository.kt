package ucb.bo.edu.examen2

class BookRepository (private val bookDao: IBookDao){
    suspend fun insert(book: Book) {
        bookDao.insert(book)
    }

    fun getListBook(): List<Book>{
        return bookDao.getList()

    }


}