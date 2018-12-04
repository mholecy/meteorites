package sk.mholecy.meteorites.meteorites.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import sk.mholecy.meteorites.databinding.ItemMeteoriteBinding
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel

class MeteoritesAdapter(
    diffCallback: MeteoriteDiffCallback
) : PagedListAdapter<DbMeteoriteModel, MeteoritesAdapter.ViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meteorite = getItem(position)
        holder.apply {
            meteorite ?: return@apply
            bind(createOnClickListener(meteorite.id), meteorite)
            itemView.tag = meteorite
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMeteoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun createOnClickListener(meteoriteId: Long): View.OnClickListener {
        return View.OnClickListener {

        }
    }

    class ViewHolder(
        private val binding: ItemMeteoriteBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, meteorite: DbMeteoriteModel) {
            binding.apply {
                clickListener = listener
                meteoriteModel = meteorite
                executePendingBindings()
            }
        }
    }
}
