package tk.npars.apartment.manager;

import tk.npars.apartment.h2.DaoURL;
import tk.npars.apartment.helper.UrlEntity;
import tk.npars.apartment.site.OlxSite;

import java.util.List;

public class OlxManager {

    public static void main(String[] args) {
        new OlxManager().checkManager();
    }

    private void checkManager(){
        List<UrlEntity> urlEntities = new DaoURL().selectDB();
        if (urlEntities.isEmpty()) throw new IllegalArgumentException("Empty UrlEntity table");
        urlEntities.forEach(urlEntity -> {
            OlxSite olxSite = new OlxSite();
            olxSite.execute(urlEntity.getUrl());
        });
    }
}
