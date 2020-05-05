package tk.npars.apartment.notify;


import tk.npars.apartment.helper.OlxEntity;

import java.util.ArrayList;
import java.util.List;

public class NotifyHolderSingl {

    List<OlxEntity> olxEntityList = new ArrayList<>();

    private static NotifyHolderSingl instance;

    public static synchronized NotifyHolderSingl getInstance() {
        if (instance == null) {
            instance = new NotifyHolderSingl();
        }
        return instance;
    }

    public List<OlxEntity> getOlxEntityList() {
        return olxEntityList;
    }

    public void addOlxAnnounceList(OlxEntity olxEntity) {
        this.olxEntityList.add(olxEntity);
    }

}
