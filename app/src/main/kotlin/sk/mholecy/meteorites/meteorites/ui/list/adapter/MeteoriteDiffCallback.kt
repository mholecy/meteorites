package sk.mholecy.meteorites.meteorites.ui.list.adapter

import androidx.recyclerview.widget.DiffUtil
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel

object MeteoriteDiffCallback : DiffUtil.ItemCallback<DbMeteoriteModel>() {
    override fun areItemsTheSame(oldItem: DbMeteoriteModel, newItem: DbMeteoriteModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DbMeteoriteModel, newItem: DbMeteoriteModel): Boolean {
        return oldItem == newItem
    }
}
