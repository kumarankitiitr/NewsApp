package `in`.programy.newsapp.ui

import `in`.programy.newsapp.R
import `in`.programy.newsapp.db.ArticleDatabse
import `in`.programy.newsapp.repository.NewsRepository
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabse(this))
        val newsViewModelFactory = NewsViewModelFactory(newsRepository,application)
        newsViewModel = ViewModelProvider(this,newsViewModelFactory).get(NewsViewModel::class.java)

        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}