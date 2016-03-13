package it.justonetouch.kotlinexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import it.justonetouch.kotlinexample.dummy.HeroAdapter
import it.justonetouch.kotlinexample.dummy.HeroDummyContent
import it.justonetouch.kotlinexample.dummy.HeroItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentHero: HeroItem? = null

    private val adapter by lazy {
        HeroAdapter(HeroDummyContent.ITEMS) {
            val previousHero = currentHero
            if (previousHero != null) {
                // fight
                val conclusion = if (previousHero.power == it.power) {
                    "It's a draw"
                } else if (previousHero.power > it.power) {
                    "${previousHero.name} wins!"
                } else {
                    "${it.name} wins!"
                }
                Snackbar.make(fab, "${previousHero.name} vs ${it.name}!\n$conclusion", Snackbar.LENGTH_LONG).show()
                currentHero = null
            } else {
                // assign current hero
                Snackbar.make(fab, "Choose: ${it.name}", Snackbar.LENGTH_SHORT).show()
                currentHero = it
            }
        }
    }

    // ...

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
