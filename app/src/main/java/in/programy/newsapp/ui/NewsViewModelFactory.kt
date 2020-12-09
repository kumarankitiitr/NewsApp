package `in`.programy.newsapp.ui

import `in`.programy.newsapp.NewsApplication
import `in`.programy.newsapp.repository.NewsRepository
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class NewsViewModelFactory(val newsRepository: NewsRepository, val app: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository,app) as T
    }
}