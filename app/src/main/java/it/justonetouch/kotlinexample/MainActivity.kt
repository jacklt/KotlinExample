package it.justonetouch.kotlinexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import it.justonetouch.kotlinexample.dummy.HeroAdapter
import it.justonetouch.kotlinexample.dummy.HeroDummyContent
import kotlinx.android.synthetic.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter by lazy {
        HeroAdapter(HeroDummyContent.ITEMS) { Snackbar.make(fab, "Tap on: " + it, Snackbar.LENGTH_SHORT).show() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Snackbar.make(fab, "Choose: Menu > Settings", Snackbar.LENGTH_SHORT).show()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}
