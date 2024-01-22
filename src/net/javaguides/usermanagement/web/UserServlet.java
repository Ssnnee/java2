// package net.javaguides.usermanagement.web;
//
// import java.io.IOException;
// import java.sql.SQLException;
// import java.util.List;
//
// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// import net.javaguides.usermanagement.dao.UserDAO;
// import net.javaguides.usermanagement.model.User;
//
// /**
//  * ControllerServlet.java
//  * This servlet acts as a page controller for the application, handling all
//  * requests from the user.
//  * @email Ramesh Fadatare
//  */
//
// @WebServlet("/")
// public class UserServlet extends HttpServlet {
// 	private static final long serialVersionUID = 1L;
// 	private UserDAO userDAO;
//
// 	public void init() {
// 		userDAO = new UserDAO();
// 	}
//
// 	protected void doPost(HttpServletRequest request, HttpServletResponse response)
// 			throws ServletException, IOException {
// 		doGet(request, response);
// 	}
//
// 	protected void doGet(HttpServletRequest request, HttpServletResponse response)
// 			throws ServletException, IOException {
// 		String action = request.getServletPath();
//
// 		try {
// 			switch (action) {
// 			case "/new":
// 				showNewForm(request, response);
// 				break;
// 			case "/insert":
// 				insertUser(request, response);
// 				break;
// 			case "/delete":
// 				deleteUser(request, response);
// 				break;
// 			case "/edit":
// 				showEditForm(request, response);
// 				break;
// 			case "/update":
// 				updateUser(request, response);
// 				break;
// 			default:
// 				listUser(request, response);
// 				break;
// 			}
// 		} catch (SQLException ex) {
// 			throw new ServletException(ex);
// 		}
// 	}
//
// 	private void listUser(HttpServletRequest request, HttpServletResponse response)
// 			throws SQLException, IOException, ServletException {
// 		List<User> listUser = userDAO.selectAllUsers();
// 		request.setAttribute("listUser", listUser);
// 		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
// 		dispatcher.forward(request, response);
// 	}
//
// 	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
// 			throws ServletException, IOException {
// 		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
// 		dispatcher.forward(request, response);
// 	}
//
// 	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
// 			throws SQLException, ServletException, IOException {
// 		int id = Integer.parseInt(request.getParameter("id"));
// 		User existingUser = userDAO.selectUser(id);
// 		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
// 		request.setAttribute("user", existingUser);
// 		dispatcher.forward(request, response);
//
// 	}
//
// 	private void insertUser(HttpServletRequest request, HttpServletResponse response)
// 			throws SQLException, IOException {
// 		String name = request.getParameter("name");
// 		String email = request.getParameter("email");
// 		String country = request.getParameter("country");
// 		User newUser = new User(name, email, country);
// 		userDAO.insertUser(newUser);
// 		response.sendRedirect("list");
// 	}
//
// 	private void updateUser(HttpServletRequest request, HttpServletResponse response)
// 			throws SQLException, IOException {
// 		int id = Integer.parseInt(request.getParameter("id"));
// 		String name = request.getParameter("name");
// 		String email = request.getParameter("email");
// 		String country = request.getParameter("country");
//
// 		User book = new User(id, name, email, country);
// 		userDAO.updateUser(book);
// 		response.sendRedirect("list");
// 	}
//
// 	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
// 			throws SQLException, IOException {
// 		int id = Integer.parseInt(request.getParameter("id"));
// 		userDAO.deleteUser(id);
// 		response.sendRedirect("list");
//
// 	}
//
// }

package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.FactureDAO;
import net.javaguides.usermanagement.model.Facture;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Vérifier les informations d'identification
        if ("esgae".equals(username) && "esgae".equals(password)) {
            // Rediriger vers la page de succès ou faire d'autres actions ici
            response.sendRedirect("success.jsp");
        } else {
            // Rediriger vers la page d'échec ou faire d'autres actions ici
            response.sendRedirect("failure.jsp");
        }
    }
}


@WebServlet("/")
public class FactureServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FactureDAO factureDAO;

    public void init() {
        factureDAO = new FactureDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertFacture(request, response);
                    break;
                case "/delete":
                    deleteFacture(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateFacture(request, response);
                    break;
                default:
                    listFacture(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listFacture(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Facture> listFacture = factureDAO.selectAllFactures();
        request.setAttribute("listFacture", listFacture);
        RequestDispatcher dispatcher = request.getRequestDispatcher("facture-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("facture-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Facture existingFacture = factureDAO.selectFacture(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("facture-form.jsp");
        request.setAttribute("facture", existingFacture);
        dispatcher.forward(request, response);
    }

    private void insertFacture(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String reference = request.getParameter("reference");
        String designation = request.getParameter("designation");
        double prixUnitaire = Double.parseDouble(request.getParameter("prixUnitaire"));
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        double prixHT = Double.parseDouble(request.getParameter("prixHT"));
        double remise = Double.parseDouble(request.getParameter("remise"));
        double prixTTC = Double.parseDouble(request.getParameter("prixTTC"));

        Facture newFacture = new Facture(reference, designation, prixUnitaire, quantite, prixHT, remise, prixTTC);
        factureDAO.insertFacture(newFacture);
        response.sendRedirect("list");
    }

    private void updateFacture(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String reference = request.getParameter("reference");
        String designation = request.getParameter("designation");
        double prixUnitaire = Double.parseDouble(request.getParameter("prixUnitaire"));
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        double prixHT = Double.parseDouble(request.getParameter("prixHT"));
        double remise = Double.parseDouble(request.getParameter("remise"));
        double prixTTC = Double.parseDouble(request.getParameter("prixTTC"));

        Facture updatedFacture = new Facture(id, reference, designation, prixUnitaire, quantite, prixHT, remise, prixTTC);
        factureDAO.updateFacture(updatedFacture);
        response.sendRedirect("list");
    }

    private void deleteFacture(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        factureDAO.deleteFacture(id);
        response.sendRedirect("list");
    }
}

