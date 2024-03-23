package com.example.samachar.repository

import com.example.samachar.api.RetrofitInstance
import com.example.samachar.db.ArticleDatabase
import com.example.samachar.models.Article

class NewsRepository(
    private val db : ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber : Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getAllArticles() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}