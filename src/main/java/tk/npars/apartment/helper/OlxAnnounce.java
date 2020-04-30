package tk.npars.apartment.helper;

public class OlxAnnounce {

    private String id;
    private String url;
    private String type;
    private String name;
    private String price;
    private String desc;
    private String time;
    private String photo;

    public OlxAnnounce() {

    }

    public OlxAnnounce(String id, String url, String type, String name, String price, String desc, String time, String photo) {
        this.id = id;
        this.url = url;
        this.type = type;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.time = time;
        this.photo = photo;
    }

    public int getId() {
        return Integer.parseInt(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return price + "\n" +
                name + "\n" +
                price + "\n" +
                time + "\n" +
                type + "\n" +
                url
                ;

    }
}
