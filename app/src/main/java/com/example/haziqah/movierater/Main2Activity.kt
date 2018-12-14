package com.example.haziqah.movierater

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_rate_movie.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        var movieNamefromMain = intent.getStringExtra("movieTitle")
        var movieDescfromMain = intent.getStringExtra("description")
        var movieDatefromMain = intent.getStringExtra("date")
        var movieLangfromMain = intent.getStringExtra("Language")
        var movieUnsuitablefromMain = intent.getStringExtra("unsuitable")
        movieTitle.text = "$movieNamefromMain"
        Overview.text = "$movieDescfromMain"
        date.text = "$movieDatefromMain"
        lang.text = "$movieLangfromMain"
        suitable_forbelow_13.text = "$movieUnsuitablefromMain"


        registerForContextMenu(Reviews)

        }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.Reviews){

            menu?.add(1,1002,1,"Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == 1002){
            var myIntent = Intent(this,RateMovie::class.java)
            startActivityForResult(myIntent,1)
        }
        return super.onContextItemSelected(item)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home)
        {
            var myIntent = Intent(this,LandingPage::class.java)
            startActivity(myIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                Reviews.visibility = View.GONE
                shareView.visibility = View.VISIBLE
                ratingBar.visibility = View.VISIBLE
                var getViewFromMain = data!!.getStringExtra("review")
                var getRatingFromMain = data!!.getFloatExtra("rating",0.0f)
                shareView.text = getViewFromMain
                ratingBar.rating = getRatingFromMain

            }
        }
    }
}

