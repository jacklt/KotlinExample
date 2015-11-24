package it.justonetouch.kotlinexample.dummy

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import it.justonetouch.kotlinexample.R

/**
 * [RecyclerView.Adapter] that can display a [HeroItem] and makes a call to the
 * specified [HeroOnClickListener].
 */
class HeroAdapter(private val mValues: List<HeroItem>, private val mListener: Function1<HeroItem, Unit>?) : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero = mValues[position]
        holder.item = hero
        holder.idView.text = hero.id
        holder.contentView.text = hero.content

        holder.itemView.setOnClickListener {
            mListener?.invoke(hero)
        }
    }

    override fun getItemCount() = mValues.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView        // Property READ-ONLY (val)
        val contentView: TextView   // Property READ-ONLY (val)
        var item: HeroItem? = null  // Property READ-WRITE (var) and nullable (?)

        init {
            idView = view.findViewById(R.id.id) as TextView
            contentView = view.findViewById(R.id.content) as TextView
        }
    }
}
