package tk.npars.apartment.manager;

import tk.npars.apartment.h2.DaoURL;

public class OlxManager {

    public static void main(String[] args) {
        new DaoURL().insertOlxDB("https://www.olx.ua/nedvizhimost/kvartiry-komnaty/prodazha-kvartir-komnat/kharkov/q-%D1%81%D0%B0%D0%BB%D1%82%D0%BE%D0%B2%D0%BA%D0%B0/?search%5Bfilter_float_price%3Ato%5D=32000&search%5Bfilter_float_floor%3Afrom%5D=2&search%5Bfilter_float_total_floors%3Afrom%5D=6&search%5Bfilter_float_number_of_rooms%3Afrom%5D=2&currency=USD","olx","салтовка");
    }

    private void checkManager(){

    }

}
