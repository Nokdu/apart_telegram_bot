package tk.npars.apartment.h2;


import java.sql.*;

/**
 * Simple example of JDBC usage.
 */
public final class App {
    /**
     * Query that create table.
     */
    //            "CREATE TABLE IF NOT EXISTS PUBLIC.EXAMPLE (GREETING VARCHAR(6), TARGET VARCHAR(6))";
    private static final String CREATE_QUERY =
            "CREATE TABLE IF NOT EXISTS PUBLIC.olx (id INT NOT NULL, url VARCHAR, type VARCHAR(10), name VARCHAR, price VARCHAR, desc TEXT, time VARCHAR, photo VARCHAR, PRIMARY KEY (id))";

//    PRIMARY KEY (id))";
    /**
     * Quaery that populates table with data.
     */
    private static final String DATA_QUERY =
            "INSERT INTO PUBLIC.EXAMPLE VALUES('Hello','World')";
    private static final String DATA_QUERY_MAIN =
            "INSERT INTO MAIN VALUES(1, 'World')";

    private static final String DROP_QUERY =
            "DROP TABLE IF EXISTS PUBLIC.EXAMPLE";

    /**
     * Do not construct me.
     */
    private App() {
    }

    /**
     * Entry point.
     *
     * @param args Commans line args. Not used.
     */
    public static void main(final String[] args) {
        try (
             Connection db = DriverManager.getConnection(
                     "jdbc:h2:./telegramdb",
                     "user_telegram",
                     "user_telegram_password")
        ) {
            try (Statement dataQuery = db.createStatement()) {
//                dataQuery.execute(DROP_QUERY);
                dataQuery.execute(CREATE_QUERY);
//                dataQuery.execute(DATA_QUERY);
//                dataQuery.execute(DATA_QUERY_MAIN);
            }

//            try (PreparedStatement query =
//                         db.prepareStatement("SELECT * FROM EXAMPLE")) {
//                ResultSet rs = query.executeQuery();
//                while (rs.next()) {
//                    System.out.println(String.format("%s, %s!",
//                            rs.getString("GREETING"),
//                            rs.getString("TARGET")));
//                }
//                rs.close();
//            }
        } catch (SQLException ex) {
            System.out.println("Database connection failure: "
                    + ex.getMessage());

        }
    }
}
