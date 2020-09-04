package cl.desafiolatam.herodataapp.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.herodataapp.R
import cl.desafiolatam.herodataapp.model.pojo.HeroMini
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroAdapter (private var heroDataset : MutableList<HeroMini>, val notifier : NotifyClick)  : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroDataset.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.textName.text =  heroDataset.get(position).name
        Picasso.get().load(heroDataset.get(position).images_sm).into(holder.imageMiniHero)

        holder.itemView.setOnClickListener{
            Log.d("viewholder", "${heroDataset.get(position)}")
            notifier.notifyClick(heroDataset.get(position))
        }
    }

    fun updateItems (it: List<HeroMini>) {
        heroDataset.clear()
        heroDataset.addAll(it)
        notifyDataSetChanged()
    }

    class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textName = itemView.textHeroName
        var imageMiniHero = itemView.imgMiniHero
    }
}