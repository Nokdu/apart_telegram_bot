package tk.npars.apartment.manager;

import tk.npars.apartment.h2.DaoURL;
import tk.npars.apartment.helper.OlxAnnounce;
import tk.npars.apartment.helper.UrlEntity;
import tk.npars.apartment.notify.NotifyHolderSingl;
import tk.npars.apartment.site.OlxSite;
import tk.npars.apartment.telegram.BotInit;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OlxManager {

    public static void main(String[] args) {
        new OlxManager().checkManager();
    }

    public void checkManager(){
        List<UrlEntity> urlEntities = new DaoURL().selectDB();
        if (urlEntities.isEmpty()) throw new IllegalArgumentException("Empty UrlEntity table");
        urlEntities.forEach(urlEntity -> {
            OlxSite olxSite = new OlxSite();
            olxSite.execute(urlEntity.getUrl());
            List<OlxAnnounce> olxAnnounceList = NotifyHolderSingl.getInstance().getOlxAnnounceList();
            BotInit bot = BotInit.getInstance();
            olxAnnounceList.forEach(olxAnnounce -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bot.SendMessage(olxAnnounce.toString());
            });
            olxAnnounceList.clear();
        });
    }
}
