package tk.npars.apartment.notify;


import tk.npars.apartment.helper.OlxAnnounce;

import java.util.ArrayList;
import java.util.List;

public class NotifyHolderSingl {

    List<OlxAnnounce> olxAnnounceList = new ArrayList<>();

    private static NotifyHolderSingl instance;

    public static synchronized NotifyHolderSingl getInstance() {
        if (instance == null) {
            instance = new NotifyHolderSingl();
        }
        return instance;
    }

    public List<OlxAnnounce> getOlxAnnounceList() {
        return olxAnnounceList;
    }

    public void addOlxAnnounceList(OlxAnnounce olxAnnounce) {
        this.olxAnnounceList.add(olxAnnounce);
    }

}
