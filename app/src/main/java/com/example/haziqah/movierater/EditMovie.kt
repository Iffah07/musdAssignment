package com.example.haziqah.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_movie.*
import kotlinx.android.synthetic.main.activity_main.*

class EditMovie : AppCompatActivity() {

    val Editmovie = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var movieDetails = MovieEntity(
            "Avengers","Movie about a lot of people hitting each other","English","2001","Yes")

        moviename.setText(movieDetails.movieTitle)
        moviedesc.setText(movieDetails.movieDesc)
        releasedate.setText(movieDetails.movieDate)
        if (movieDetails.movieLang == "English")
        {
            eng.isChecked = true
        }
        if (movieDetails.movieSuitable == "Yes")
        {
            unsuitableforaudience.isChecked = false
        }



        unsuitable_for_audience.setOnClickListener() {
            if (unsuitable_for_audience.isChecked == true) {
                not_suitable_for_audience.setVisibility(View.VISIBLE)
            } else {
                not_suitable_for_audience.setVisibility(View.INVISIBLE)
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.editmenu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.misave)
        {
            var movieLang = ""
            var movieUnsuitable = ""
            if (unsuitable_for_audience.isChecked == false)
            {
                movieUnsuitable = "Yes"
            }
            if (violence.isChecked == true)
            {
                movieUnsuitable = "No (Violence)"
            }
            if (lang_used.isChecked == true)
            {
                movieUnsuitable = "No (Language)"
            }
            if (english.isChecked == true)
            {
                movieLang = "English"
            }
            else if (chinese.isChecked == true)
            {
                movieLang = "Chinese"
            }
            else if (malay.isChecked == true)
            {
                movieLang = "Malay"
            }
            else if (tamil.isChecked == true)
            {
                movieLang = "Tamil"
            }


            var  myintent = Intent(this, Main2Activity::class.java)
            myintent.putExtra("movieTitle",movie_name.text.toString())
            myintent.putExtra("description",movie_desc.text.toString())
            myintent.putExtra("date",release_date.text.toString())
            myintent.putExtra("Language",movieLang.toString())
            myintent.putExtra("unsuitable",movieUnsuitable.toString())
            startActivityForResult(myintent,1)
        }
        if (item?.itemId == R.id.micancel)
        {
            var myIntent = Intent(this, LandingPage::class.java)
            startActivity(myIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}
