package tk.npars.apartment.adapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class IndexOlx {

    private void status(String urlOlx){

        documentJsoup(urlOlx);

    }

    private Document documentJsoup(String urlOlx){
        Document doc = null;
        try {
            doc = Jsoup.connect(urlOlx).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    //Количество страниц
    private void pageCount(){

    }

    private void l(){

    }
}
