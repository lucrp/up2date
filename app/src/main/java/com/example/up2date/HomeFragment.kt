package com.example.up2date

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dfl.newsapi.NewsApiRepository

class HomeFragment : Fragment() {
    val newsApiRepository = NewsApiRepository("efd3cc55a5ea44de8b006d7848ef67b7")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
        newsApiRepository.getTopHeadlines()
    }

}
