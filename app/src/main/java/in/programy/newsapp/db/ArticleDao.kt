package `in`.programy.newsapp.db

import `in`.programy.newsapp.model.Article
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM ARTICLES")
    fun readArticles(): LiveData<List<Article>>

    @Delete
    suspend fun delete(article: Article)
}