package sk.mholecy.meteorites.meteorites.learn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import sk.mholecy.meteorites.R;
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao;

import static org.koin.java.KoinJavaComponent.inject;

public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private Lazy<MeteoritesDao> daoLazy = inject(MeteoritesDao.class);

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        final View view = inflater.inflate(R.layout.fragment_meteorites_java_list, container, false);
        recyclerView = view.findViewById(R.id.rv_meteorites_java);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MeteoriteListViewModel viewModel = ViewModelProviders.of(this).get(MeteoriteListViewModel.class);
        viewModel.init(daoLazy.getValue());
        final MeteoriteListAdapter meteoriteListAdapter = new MeteoriteListAdapter();
        recyclerView.setAdapter(meteoriteListAdapter);
        viewModel.liveMeteoritesList.observe(this, dbMeteoriteModels ->
                meteoriteListAdapter.submitList(dbMeteoriteModels)
        );
    }
}
