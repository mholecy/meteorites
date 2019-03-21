package sk.mholecy.meteorites.meteorites.learn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import sk.mholecy.meteorites.R;
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel;

public class MeteoriteListAdapter extends PagedListAdapter<DbMeteoriteModel, MeteoriteListAdapter.MeteoritesViewHolder> {

    private static DiffUtil.ItemCallback<DbMeteoriteModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<DbMeteoriteModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull DbMeteoriteModel oldItem, @NonNull DbMeteoriteModel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull DbMeteoriteModel oldItem, @NonNull DbMeteoriteModel newItem) {
            return oldItem.equals(newItem);
        }
    };

    protected MeteoriteListAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public MeteoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_java_meteorite, parent,
                false
        );
        return new MeteoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeteoritesViewHolder holder, int position) {
        final DbMeteoriteModel dbMeteoriteModel = getItem(position);
        if (dbMeteoriteModel != null) {
            holder.name.setText(dbMeteoriteModel.getName());
            holder.mass.setText(dbMeteoriteModel.getMass() / 1000 + " kg");
            holder.itemView.setTag(dbMeteoriteModel);
        }
    }

    class MeteoritesViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView mass;
        MeteoritesViewHolder(View itemMeteoriteView) {
            super(itemMeteoriteView);
            name = itemView.findViewById(R.id.tv_meteorite_item_title_java);
            mass = itemView.findViewById(R.id.tv_meteorite_mass_java);
        }
    }
}
