package `in`.programy.newsapp.repository

import `in`.programy.newsapp.api.RetrofitInstance.Companion.api
import `in`.programy.newsapp.db.ArticleDatabse
import `in`.programy.newsapp.model.Article


class NewsRepository(
    val databse: ArticleDatabse
) {
    suspend fun getBreakingNews(country: String,page: Int) = api.getBreakingNews(country,page)

    suspend fun searchNews(query: String,page: Int) = api.searchNews(query,page)

    suspend fun upsertArticle(article: Article){
        databse.getArticleDao().upsert(article)
    }

    suspend fun deleteArticle(article: Article){
        databse.getArticleDao().delete(article)
    }

    fun readArticles() = databse.getArticleDao().readArticles()

}