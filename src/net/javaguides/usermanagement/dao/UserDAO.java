// package net.javaguides.usermanagement.dao;
//
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;
//
// import net.javaguides.usermanagement.model.User;
//
// /**
//  * AbstractDAO.java This DAO class provides CRUD database operations for the
//  * table users in the database.
//  *
//  * @author Ramesh Fadatare
//  *
//  */
// public class UserDAO {
// 	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
// 	private String jdbcUsername = "root";
// 	private String jdbcPassword = "root";
//
// 	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES "
// 			+ " (?, ?, ?);";
//
// 	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
// 	private static final String SELECT_ALL_USERS = "select * from users";
// 	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
// 	private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
//
// 	public UserDAO() {
// 	}
//
// 	protected Connection getConnection() {
// 		Connection connection = null;
// 		try {
// 			Class.forName("com.mysql.jdbc.Driver");
// 			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
// 		} catch (SQLException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		} catch (ClassNotFoundException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
// 		return connection;
// 	}
//
// 	public void insertUser(User user) throws SQLException {
// 		System.out.println(INSERT_USERS_SQL);
// 		// try-with-resource statement will auto close the connection.
// 		try (Connection connection = getConnection();
// 				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
// 			preparedStatement.setString(1, user.getName());
// 			preparedStatement.setString(2, user.getEmail());
// 			preparedStatement.setString(3, user.getCountry());
// 			System.out.println(preparedStatement);
// 			preparedStatement.executeUpdate();
// 		} catch (SQLException e) {
// 			printSQLException(e);
// 		}
// 	}
//
// 	public User selectUser(int id) {
// 		User user = null;
// 		// Step 1: Establishing a Connection
// 		try (Connection connection = getConnection();
// 				// Step 2:Create a statement using connection object
// 				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
// 			preparedStatement.setInt(1, id);
// 			System.out.println(preparedStatement);
// 			// Step 3: Execute the query or update query
// 			ResultSet rs = preparedStatement.executeQuery();
//
// 			// Step 4: Process the ResultSet object.
// 			while (rs.next()) {
// 				String name = rs.getString("name");
// 				String email = rs.getString("email");
// 				String country = rs.getString("country");
// 				user = new User(id, name, email, country);
// 			}
// 		} catch (SQLException e) {
// 			printSQLException(e);
// 		}
// 		return user;
// 	}
//
// 	public List<User> selectAllUsers() {
//
// 		// using try-with-resources to avoid closing resources (boiler plate code)
// 		List<User> users = new ArrayList<>();
// 		// Step 1: Establishing a Connection
// 		try (Connection connection = getConnection();
//
// 				// Step 2:Create a statement using connection object
// 			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
// 			System.out.println(preparedStatement);
// 			// Step 3: Execute the query or update query
// 			ResultSet rs = preparedStatement.executeQuery();
//
// 			// Step 4: Process the ResultSet object.
// 			while (rs.next()) {
// 				int id = rs.getInt("id");
// 				String name = rs.getString("name");
// 				String email = rs.getString("email");
// 				String country = rs.getString("country");
// 				users.add(new User(id, name, email, country));
// 			}
// 		} catch (SQLException e) {
// 			printSQLException(e);
// 		}
// 		return users;
// 	}
//
// 	public boolean deleteUser(int id) throws SQLException {
// 		boolean rowDeleted;
// 		try (Connection connection = getConnection();
// 				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
// 			statement.setInt(1, id);
// 			rowDeleted = statement.executeUpdate() > 0;
// 		}
// 		return rowDeleted;
// 	}
//
// 	public boolean updateUser(User user) throws SQLException {
// 		boolean rowUpdated;
// 		try (Connection connection = getConnection();
// 				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
// 			statement.setString(1, user.getName());
// 			statement.setString(2, user.getEmail());
// 			statement.setString(3, user.getCountry());
// 			statement.setInt(4, user.getId());
//
// 			rowUpdated = statement.executeUpdate() > 0;
// 		}
// 		return rowUpdated;
// 	}
//
// 	private void printSQLException(SQLException ex) {
// 		for (Throwable e : ex) {
// 			if (e instanceof SQLException) {
// 				e.printStackTrace(System.err);
// 				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
// 				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
// 				System.err.println("Message: " + e.getMessage());
// 				Throwable t = ex.getCause();
// 				while (t != null) {
// 					System.out.println("Cause: " + t);
// 					t = t.getCause();
// 				}
// 			}
// 		}
// 	}
//
// }


package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Facture;

public class FactureDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/gestiondr2?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_FACTURE_SQL = "INSERT INTO facture" +
            "  (Reference, Designation, Prix_Unitaire, Quantite, Prix_HT, Remise, Prix_TTC) VALUES "
            + " (?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_FACTURE_BY_ID = "SELECT * FROM facture WHERE ID = ?";
    private static final String SELECT_ALL_FACTURES = "SELECT * FROM facture";
    private static final String DELETE_FACTURE_SQL = "DELETE FROM facture WHERE ID = ?;";
    private static final String UPDATE_FACTURE_SQL = "UPDATE facture SET Reference = ?, Designation = ?, " +
            "Prix_Unitaire = ?, Quantite = ?, Prix_HT = ?, Remise = ?, Prix_TTC = ? WHERE ID = ?;";

    public FactureDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertFacture(Facture facture) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FACTURE_SQL)) {
            preparedStatement.setString(1, facture.getReference());
            preparedStatement.setString(2, facture.getDesignation());
            preparedStatement.setDouble(3, facture.getPrixUnitaire());
            preparedStatement.setInt(4, facture.getQuantite());
            preparedStatement.setDouble(5, facture.getPrixHT());
            preparedStatement.setDouble(6, facture.getRemise());
            preparedStatement.setDouble(7, facture.getPrixTTC());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Facture selectFacture(int id) {
        Facture facture = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACTURE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String reference = rs.getString("Reference");
                String designation = rs.getString("Designation");
                double prixUnitaire = rs.getDouble("Prix_Unitaire");
                int quantite = rs.getInt("Quantite");
                double prixHT = rs.getDouble("Prix_HT");
                double remise = rs.getDouble("Remise");
                double prixTTC = rs.getDouble("Prix_TTC");

                facture = new Facture(id, reference, designation, prixUnitaire, quantite, prixHT, remise, prixTTC);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return facture;
    }

    public List<Facture> selectAllFactures() {
        List<Facture> factures = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FACTURES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String reference = rs.getString("Reference");
                String designation = rs.getString("Designation");
                double prixUnitaire = rs.getDouble("Prix_Unitaire");
                int quantite = rs.getInt("Quantite");
                double prixHT = rs.getDouble("Prix_HT");
                double remise = rs.getDouble("Remise");
                double prixTTC = rs.getDouble("Prix_TTC");

                factures.add(new Facture(id, reference, designation, prixUnitaire, quantite, prixHT, remise, prixTTC));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return factures;
    }

    public boolean deleteFacture(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_FACTURE_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateFacture(Facture facture) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_FACTURE_SQL)) {
            statement.setString(1, facture.getReference());
            statement.setString(2, facture.getDesignation());
            statement.setDouble(3, facture.getPrixUnitaire());
            statement.setInt(4, facture.getQuantite());
            statement.setDouble(5, facture.getPrixHT());
            statement.setDouble(6, facture.getRemise());
            statement.setDouble(7, facture.getPrixTTC());
            statement.setInt(8, facture.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

