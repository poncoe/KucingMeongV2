package id.poncoe.kucingmeong

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions



class KucingAdapter(private val listKucing: ArrayList<Kucing>, private val context: Context) : RecyclerView.Adapter<KucingAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_recyclerview, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val (name, from, photo) = listKucing[position]

        /** Glide digunakan untuk memuat sebuah gambar, baik yang sudah Anda siapkan di drawable maupun berada di server */
        Glide.with(holder.itemView.context)
                .load(photo)
                .apply(RequestOptions().override(350, 550))
                .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvFrom.text = from

        holder.itemView.setOnClickListener {
            openDetailActivity(photo,name,from)
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listKucing[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listKucing.size
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.image)
        var tvName: TextView = itemView.findViewById(R.id.title)
        var tvFrom: TextView = itemView.findViewById(R.id.isi)
    }

    private fun openDetailActivity(vararg details: String) {
        val i = Intent(context, DetailActivity::class.java)
        i.putExtra("IMAGES_KEY", details[0])
        i.putExtra("TITLE_KEY", details[1])
        i.putExtra("ISI_KEY", details[2])

        context.startActivity(i)

    }

}