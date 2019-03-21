package sk.mholecy.meteorites.meteorites.learn;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import sk.mholecy.meteorites.meteorites.database.dao.MeteoritesDao;
import sk.mholecy.meteorites.meteorites.database.model.DbMeteoriteModel;

public class MeteoriteListViewModel extends ViewModel {
    LiveData<PagedList<DbMeteoriteModel>> liveMeteoritesList;

    public void init(MeteoritesDao meteoritesDao) {
        liveMeteoritesList = new LivePagedListBuilder(meteoritesDao.getMeteoritesPaged(), 50).build();
    }
}
