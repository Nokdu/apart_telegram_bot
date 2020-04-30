package tk.npars.apartment.site;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tk.npars.apartment.h2.DaoPublicOlx;
import tk.npars.apartment.helper.OlxAnnounce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OlxSite {

    public void execute(String url){
        try {
            DaoPublicOlx daoPublicOlx = new DaoPublicOlx();
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("tr.wrap");
            List<OlxAnnounce> announceList = new ArrayList<>();
            for (Element element : elements) {
                announceList.add(new OlxAnnounceBuilder(element).getOlxAnnounce());
            }
            announceList.forEach(announce ->{
                if (daoPublicOlx.sravnenieKey(announce)){
                    daoPublicOlx.insertOlxDB(announce);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
