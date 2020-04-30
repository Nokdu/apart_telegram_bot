package tk.npars.apartment.h2;


import tk.npars.apartment.helper.OlxAnnounce;

import java.sql.*;

public class DaoPublicOlx {

    private static final String CREATE_QUERY =
            "CREATE TABLE IF NOT EXISTS PUBLIC.olx (id INT NOT NULL, url VARCHAR, type VARCHAR(10), name VARCHAR, price VARCHAR, desc TEXT, time VARCHAR, photo VARCHAR, PRIMARY KEY (id))";

    private static final String DROP_QUERY =
            "DROP TABLE IF EXISTS PUBLIC.OLX";
    private static Connection db;

    public DaoPublicOlx() {
        try {
            db = DriverManager.getConnection(
                    "jdbc:h2:./telegramdb",
                    "user_telegram",
                    "user_telegram_password");
        } catch (SQLException e) {
            System.out.println("Database connection failure: "
                    + e.getMessage());
        }
    }

    public static void main(final String[] args) {
        new DaoPublicOlx().execute();
    }

    private void execute(){
//            dropDB();
            createDB();
            selectDB();

    }

    private void createDB(){
        try (Statement dataQuery = db.createStatement()) {
            dataQuery.execute(CREATE_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dropDB(){
        try (Statement dataQuery = db.createStatement()) {
            dataQuery.execute(DROP_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void selectDB(){
            try (PreparedStatement query =
                         db.prepareStatement("SELECT * FROM OLX")) {
                ResultSet rs = query.executeQuery();
                while (rs.next()) {
                    System.out.println(String.format("%s, %s",
                            rs.getString("ID"),
                            rs.getString("URL")));
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public boolean sravnenieKey(OlxAnnounce olxAnnounce) {
        try (PreparedStatement query =
                     db.prepareStatement("SELECT ID FROM OLX WHERE ID = ?")) {
            query.setInt(1, olxAnnounce.getId());
            ResultSet rs = query.executeQuery();
            if (!rs.next()){
                System.out.println(olxAnnounce.getId());
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }

    public void insertOlxDB(OlxAnnounce olxAnnounce){
        String query = "INSERT INTO PUBLIC.OLX (ID, URL, TYPE, NAME, PRICE, DESC, TIME, PHOTO) VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setInt(1, olxAnnounce.getId());
            statement.setString(2, olxAnnounce.getUrl() );
            statement.setString(3, olxAnnounce.getType() );
            statement.setString(4, olxAnnounce.getName()  );
            statement.setString(5, olxAnnounce.getPrice() );
            statement.setString(6, olxAnnounce.getDesc() );
            statement.setString(7, olxAnnounce.getTime() );
            statement.setString(8, olxAnnounce.getPhoto() );
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
