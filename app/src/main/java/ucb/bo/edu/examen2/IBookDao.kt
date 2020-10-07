package ucb.bo.edu.examen2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface IBookDao {
@Query (value = "SELECT * FROM book_table")
fun getList(): List<Book>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book:Book)

    @Query("DELETE FROM book_table")
    suspend fun deleteAll()

}