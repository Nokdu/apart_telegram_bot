package tk.npars.apartment.site;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tk.npars.apartment.h2.App;
import tk.npars.apartment.helper.OlxAnnounce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OlxSite {

    private String url = "https://www.olx.ua/nedvizhimost/kvartiry-komnaty/prodazha-kvartir-komnat/kharkov/q-%D0%B3%D0%B5%D1%80%D0%BE%D0%B5%D0%B2-%D1%82%D1%80%D1%83%D0%B4%D0%B0/?search%5Bfilter_float_price%3Ato%5D=32000&search%5Bfilter_float_floor%3Afrom%5D=2&search%5Bfilter_float_total_floors%3Afrom%5D=6&search%5Bfilter_float_number_of_rooms%3Afrom%5D=2&currency=USD";

    public static void main(String[] args) {
        new OlxSite().start();
    }

    private void start(){
        try {
            App app = new App();
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("tr.wrap");
            List<OlxAnnounce> announceList = new ArrayList<>();
            for (Element element : elements) {
                announceList.add(createOlxAnnonceObject(element));
            }
            announceList.forEach(announce ->{
                app.insertOlxDB(announce);
            });
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private OlxAnnounce createOlxAnnonceObject(Element element){
        OlxAnnounce olxAnnounce = new OlxAnnounce();
        olxAnnounce.setId(setIdOlx(element));
        olxAnnounce.setUrl(setUrlOlx(element));
        olxAnnounce.setName(setNameOlx(element));
        olxAnnounce.setPrice(setPriceOlx(element));
        olxAnnounce.setTime(setTimeOlx(element));
        olxAnnounce.setType(setTypeOlx(element));
        olxAnnounce.setDesc(setDescOlx(element));
        olxAnnounce.setPhoto(setPhotoOlx(element));
        return olxAnnounce;
    }

    private String setIdOlx(Element element){
        return element.select("table.fixed.breakword").attr("data-id");
    }

    private String setUrlOlx(Element element){
        return element.select("a.marginright5.link.linkWithHash.detailsLink").attr("href");
    }
    private String setNameOlx(Element element){
        return element.select("h3.lheight22.margintop5").text();
    }
    private String setPriceOlx(Element element){
        return element.select("p.price").text();
    }
    private String setTimeOlx(Element element){
        return element.select(".breadcrumb.x-normal:last-child > span").text();
    }
    private String setDescOlx(Element element){
        return "";
    }
    private String setTypeOlx(Element element){
        return element.select("td.offer.promoted").hasText() ? "Premium" : "Simple";
    }
    private String setPhotoOlx(Element element){
        return "";
    }


}
