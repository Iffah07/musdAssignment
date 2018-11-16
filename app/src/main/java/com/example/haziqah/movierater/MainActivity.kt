package com.example.haziqah.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        unsuitable_for_audience.setOnClickListener(){
            if(unsuitable_for_audience.isChecked == true){
                not_suitable_for_audience.setVisibility(View.VISIBLE)
            }
            else
            {
                not_suitable_for_audience.setVisibility(View.INVISIBLE)
            }

        }
    }
    fun btnValidate(v:View) {


        if (movie_name.text.toString().isEmpty() == true) {
            movie_name.setError("Field empty")
        }
        if (movie_desc.text.toString().isEmpty() == true) {
            movie_desc.setError("Field empty")
        }
        if (release_date.text.toString().isEmpty() == true) {
            release_date.setError("Field empty")
        }


        var name = findViewById<EditText>(R.id.movie_name);
        var desc = findViewById<EditText>(R.id.movie_desc);
        var date = findViewById<EditText>(R.id.release_date);
        var language = "";
        var checkboxallages = "";
        var checkboxviolence = "";
        var checkbox = "";

        if (english.isChecked == true){
            language = "English"
        }
        if (chinese.isChecked == true){
            language = "Chinese"
        }
        if (malay.isChecked == true){
            language = "Malay"
        }
        if (tamil.isChecked == true){
            language = "Tamil"
        }

        if (unsuitable_for_audience.isChecked == true){
            checkboxallages = "true"
        }
        if (violence.isChecked == true){
            checkboxviolence = "Violence"
        }
        if (lang_used.isChecked == true){
            checkbox = "Language"
        }



        Toast.makeText(this, "Title = " + name.text + "\n" +"Overview = " + desc.text + "\n" + "Release date = " + date.text + "\n" + "Language = " + language +"\n"+ "Suitable for all ages = " + checkboxallages+"\n"+"Reason:"+"\n"+checkbox+"\n"+checkboxviolence,Toast.LENGTH_SHORT).show()

    }

}
