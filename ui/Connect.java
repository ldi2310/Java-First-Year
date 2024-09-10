package GiaoDien;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLCH;encrypt=true;trustServerCertificate=true";
    public static String USER = "sa";
    public static String PASSWORD = "123456";

    public Connect() {
    }

    public static Vector<Clothes> ClothesAll() {
        Vector<Clothes> clothesList = new Vector();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM Clothes ORDER BY clothesNUMBER";
            preparedStatement = connection.prepareStatement(sql);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Clothes clo = new Clothes(resultSet.getString("clothesID"),
                            resultSet.getString("clothesNAME"),
                            resultSet.getInt("clothesPRICE"),
                            resultSet.getInt("menuID"),
                            resultSet.getInt("brandID"));
                    clothesList.add(clo);
                }
            } catch (SQLException e) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            return clothesList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Vector<Brand> ListBrand() {
        Vector<Brand> brandList = new Vector();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM Brand";
            preparedStatement = connection.prepareStatement(sql);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Brand brd = new Brand(resultSet.getString("brandID"),
                            resultSet.getString("brandNAME"));
                    brandList.add(brd);
                }
            } catch (SQLException e) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            return brandList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Vector<Menu> ListMenu() {
        Vector<Menu> menuList = new Vector();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM Menu";
            preparedStatement = connection.prepareStatement(sql);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Menu menu = new Menu(resultSet.getString("menuID"),
                            resultSet.getString("menuNAME"));
                    menuList.add(menu);
                }
            } catch (SQLException e) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            return menuList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Vector<Size> ListSize() {
        Vector<Size> sizeList = new Vector();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM Size";
            preparedStatement = connection.prepareStatement(sql);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Size size = new Size(resultSet.getString("Size"),
                            resultSet.getString("clothesID"),
                            resultSet.getInt("sizeQUANTITY"));
                    sizeList.add(size);
                }
            } catch (SQLException e) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
                }
            }

            return sizeList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Vector<Size> Size(Clothes clothes) {
        Vector<Size> sizeList = new Vector<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "SELECT * FROM Size WHERE clothesID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, clothes.getClothesID());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Size size = new Size(resultSet.getString("Size"),
                            resultSet.getString("clothesID"),
                            resultSet.getInt("sizeQUANTITY"));
                    sizeList.add(size);
                }
            } catch (SQLException e) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return sizeList;
    }


    public static void Add(Clothes clothes, Size sizeS, Size sizeM, Size sizeL) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "INSERT INTO Clothes (clothesID, menuID, clothesNAME, clothesPRICE, brandID)" +
                    "VALUES (?, ?, ?, ?, ?)" +
                    "INSERT INTO Size (Size, clothesID, sizeQUANTITY)" +
                    "VALUES ('S', ?, ?)," +
                    "       ('M', ?, ?)," +
                    "       ('L', ?, ?)";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, clothes.getClothesID());
            preparedStatement.setInt(2, clothes.getMenuID());
            preparedStatement.setString(3, clothes.getClothesNAME());
            preparedStatement.setInt(4, clothes.getClothesPRICE());
            preparedStatement.setInt(5, clothes.getBrandID());

            preparedStatement.setString(6, sizeS.getClothesID());
            preparedStatement.setInt(7, sizeS.getSizeQUANTITY());
            preparedStatement.setString(8, sizeM.getClothesID());
            preparedStatement.setInt(9, sizeM.getSizeQUANTITY());
            preparedStatement.setString(10, sizeL.getClothesID());
            preparedStatement.setInt(11, sizeL.getSizeQUANTITY());

            preparedStatement.execute();
        } catch (SQLException e) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public static void Buy(Size sizeS, Size sizeM, Size sizeL) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "UPDATE Size SET sizeQUANTITY = CASE Size " +
                    "WHEN 'S' THEN ? " +
                    "WHEN 'M' THEN ? " +
                    "WHEN 'L' THEN ? END " +
                    "WHERE clothesID = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, sizeS.getSizeQUANTITY());
            preparedStatement.setInt(2, sizeM.getSizeQUANTITY());
            preparedStatement.setInt(3, sizeL.getSizeQUANTITY());

            preparedStatement.setString(4, sizeS.getClothesID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public static void Edit(Clothes clothes, String oldID) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "UPDATE Clothes SET menuID = ?, clothesNAME = ?, clothesPRICE = ?, brandID = ? " +
                    "WHERE clothesID = ?" +
                    "UPDATE Size SET clothesID = ?" +
                    "WHERE clothesID = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, clothes.getMenuID());
            preparedStatement.setString(2, clothes.getClothesNAME());
            preparedStatement.setInt(3, clothes.getClothesPRICE());
            preparedStatement.setInt(4, clothes.getBrandID());
            preparedStatement.setString(5, oldID);
            preparedStatement.setString(6, clothes.getClothesID());
            preparedStatement.setString(7, oldID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    public static void EditSize(Size sizeS, Size sizeM, Size sizeL) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "UPDATE Size SET sizeQUANTITY = CASE Size " +
                    "WHEN 'S' THEN ? " +
                    "WHEN 'M' THEN ? " +
                    "WHEN 'L' THEN ? END " +
                    "WHERE clothesID = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, sizeS.getSizeQUANTITY());
            preparedStatement.setInt(2, sizeM.getSizeQUANTITY());
            preparedStatement.setInt(3, sizeL.getSizeQUANTITY());

            preparedStatement.setString(4, sizeS.getClothesID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public static void DELETE(Clothes clothes) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "DELETE FROM Size WHERE clothesID = ?" +
                    "DELETE FROM Clothes WHERE clothesID = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, clothes.getClothesID());
            preparedStatement.setString(2, clothes.getClothesID());

            preparedStatement.execute();
        } catch (SQLException e) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}