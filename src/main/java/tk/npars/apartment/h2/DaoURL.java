package tk.npars.apartment.h2;

import tk.npars.apartment.helper.UrlEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoURL {

    private static Connection db;

    private static final String CREATE_QUERY =
            "CREATE TABLE IF NOT EXISTS PUBLIC.URL (id_url INT NOT NULL AUTO_INCREMENT, url VARCHAR, type VARCHAR, name VARCHAR, PRIMARY KEY (id_url))";
    private static final String DROP_QUERY =
            "DROP TABLE IF EXISTS PUBLIC.URL";
    public DaoURL() {
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

    private void dropDB(){
        try (Statement dataQuery = db.createStatement()) {
            dataQuery.execute(DROP_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createDB(){
        try (Statement dataQuery = db.createStatement()) {
            dataQuery.execute(CREATE_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UrlEntity> selectDB(){
        List<UrlEntity> result = new ArrayList<>();
        try (PreparedStatement query =
                     db.prepareStatement("SELECT * FROM URL")) {
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                result.add(new UrlEntity(
                        rs.getString("URL"),
                        rs.getString("TYPE"),
                        rs.getString("NAME")
                        ));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void insertOlxDB(String url, String type, String name){
        String query = "INSERT INTO PUBLIC.URL (URL, TYPE, NAME) VALUES(?,?,?)";
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, url );
            statement.setString(2, type );
            statement.setString(3, name );
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
