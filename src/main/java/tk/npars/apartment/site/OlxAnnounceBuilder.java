package tk.npars.apartment.site;

import org.jsoup.nodes.Element;
import tk.npars.apartment.helper.OlxAnnounce;

public class OlxAnnounceBuilder {

    private OlxAnnounce olxAnnounce;

    public OlxAnnounceBuilder(Element element) {
        setOlxAnnounce(new OlxAnnounce(
                setIdOlx(element),
                setUrlOlx(element),
                setTypeOlx(element),
                setNameOlx(element),
                setPriceOlx(element),
                setDescOlx(element),
                setTimeOlx(element),
                setPhotoOlx(element)
        ));
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
    public OlxAnnounce getOlxAnnounce() {
        return olxAnnounce;
    }
    private void setOlxAnnounce(OlxAnnounce olxAnnounce) {
        this.olxAnnounce = olxAnnounce;
    }
}
