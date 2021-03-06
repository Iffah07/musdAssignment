package com.example.haziqah.movierater

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val movie_result=1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        unsuitable_for_audience.setOnClickListener() {
            if (unsuitable_for_audience.isChecked == true) {
                not_suitable_for_audience.setVisibility(View.VISIBLE)
            } else {
                not_suitable_for_audience.setVisibility(View.INVISIBLE)
            }

        }

          }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.addmenu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.miAdd)
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
        startActivityForResult(myintent,movie_result)
        }
        if (item?.itemId == R.id.miDataClear)
        {
            movie_name.text.clear()
            movie_desc.text.clear()
            release_date.text.clear()
            unsuitable_for_audience.isChecked = false
            violence.isChecked = false
            lang_used.isChecked = false
            english.isChecked = true
            chinese.isChecked = false
            malay.isChecked = false
            tamil.isChecked = false
            violence.visibility = View.INVISIBLE
            lang_used.visibility = View.INVISIBLE
        }
        return super.onOptionsItemSelected(item)
    }

    fun raterValidator (v:View){

    }
    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}
