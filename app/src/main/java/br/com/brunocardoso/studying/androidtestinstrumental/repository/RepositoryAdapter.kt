package br.com.brunocardoso.studying.androidtestinstrumental.repository

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.brunocardoso.studying.androidtestinstrumental.R
import br.com.brunocardoso.studying.androidtestinstrumental.data.model.Repository
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        )


    override fun getItemCount() = repositories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repositories[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(repository: Repository) {
            itemView.name.text = repository.name

            Glide.with(itemView.context)
                .load(repository.owner.avatar)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(itemView.icon)
        }

    }

}