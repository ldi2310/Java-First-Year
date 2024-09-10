package GiaoDien;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    private String menuID;
    private String mennuNAME;

    public Menu(String menuID, String mennuNAME) {
        this.menuID = menuID;
        this.mennuNAME = mennuNAME;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getMennuNAME() {
        return mennuNAME;
    }

    public void setMennuNAME(String mennuNAME) {
        this.mennuNAME = mennuNAME;
    }

    public static class Conection {
        public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLCH;encrypt=true;trustServerCertificate=true";
        public static String USER = "sa";
        public static String PASSWORD = "123456";

        public static Vector<Clothes> ClothesAll() {
            Vector<Clothes> clothesList = new Vector<>();
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);

                String sql = "SELECT * FROM Clothes ORDER BY clothesNUMBER";
                preparedStatement =connection.prepareStatement(sql);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Clothes clo = new Clothes(
                                resultSet.getString("clothesID"),
                                resultSet.getString("clothesNAME"),
                                resultSet.getInt("clothesPRICE"),
                                resultSet.getInt("menuID"),
                                resultSet.getInt("brandID")
                        );
                    }
                }

            } catch (SQLException e) {
                Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            return clothesList;
        }

    }
}
