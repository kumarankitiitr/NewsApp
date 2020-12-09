package `in`.programy.newsapp.db

import `in`.programy.newsapp.model.Article
import android.content.Context
import androidx.room.*
import java.util.concurrent.locks.Lock

@Database(
    entities = [Article::class],
    version = 3
)
@TypeConverters(Convertors::class)
abstract class ArticleDatabse : RoomDatabase(){
    abstract fun getArticleDao(): ArticleDao

    companion object{
        @Volatile
        private var instance: ArticleDatabse? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabse(context).also {
                instance = it }
        }

        private fun createDatabse(context: Context): ArticleDatabse{
            return Room.databaseBuilder(context,ArticleDatabse::class.java,"article_db.db")
                .fallbackToDestructiveMigration()
                .build()
        }

    }
}