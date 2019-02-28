package sk.mholecy.meteorites.meteorites.ui.list.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import sk.mholecy.meteorites.R
import sk.mholecy.meteorites.common.extensions.setBackgroundColor
import sk.mholecy.meteorites.databinding.ItemMeteoriteBinding
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel
import sk.mholecy.meteorites.meteorites.ui.list.MeteoritesListFragmentDirections

class MeteoritesAdapter(
    diffCallback: MeteoriteDiffCallback
) : PagedListAdapter<DbMeteoriteModel, MeteoritesAdapter.ViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meteorite = getItem(position)
        holder.apply {
            meteorite ?: return@apply
            bind(createOnClickListener(meteorite), meteorite)
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

    private fun createOnClickListener(meteorite: DbMeteoriteModel): View.OnClickListener {
        return View.OnClickListener {
            if (meteorite.hasLocation) {
                val direction =
                    MeteoritesListFragmentDirections.actionMeteoritesListFragmentToMeteoriteMapFragment(meteorite.id)
                it.findNavController().navigate(direction)
            } else {
                val snackBar = Snackbar.make(
                    it,
                    it.context.getString(R.string.meteorite_location_unknown),
                    Snackbar.LENGTH_SHORT
                )
                snackBar.setBackgroundColor(R.color.primaryLightColor)
                snackBar.show()
            }
        }
    }

    class ViewHolder(
        private val binding: ItemMeteoriteBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, meteorite: DbMeteoriteModel) {
            binding.apply {
                clickListener = listener
                meteoriteModel = meteorite
                meteoriteIcon = getLocationDrawable(meteorite, binding.root.context)
                executePendingBindings()
            }
        }

        private fun getLocationDrawable(meteorite: DbMeteoriteModel, context: Context): Drawable {
            return if (meteorite.hasLocation) {
                context.getDrawable(R.drawable.ic_location_on)!!
            } else {
                context.getDrawable(R.drawable.ic_location_off)!!
            }
        }
    }
}
