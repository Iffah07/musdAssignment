package com.example.haziqah.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var movie = MovieEntity("Venom","When Eddie Brock acquires the powers of a symbiote,he will have to release his alter-ego Venom to save his life","English","03-10-2018","Yes")

        movieTitle.text = movie.movieTitle
        Overview.text = movie.movieDesc
        lang.text = movie.movieLang
        date.text = movie.movieDate
        suitable_forbelow_13.text = movie.movieSuitable

        }
    }

