package fr.eni.servlets;

import fr.eni.bll.DVDManager;
import fr.eni.dal.DALException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SelectionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //On récupére les choix
        String title = req.getParameter("title");
        int year = Integer.parseInt(req.getParameter("year"));
        String actor = req.getParameter("actor");
        int price = Integer.parseInt(req.getParameter("price"));
        int id_cat = Integer.parseInt(req.getParameter("categorie"));

        //A partir des paramètres, créer une instance de DVD via DVDManager
        DVDManager dm = null;
        try {
            dm = new DVDManager();
            dm.addDvd(title, year, actor, price, id_cat);

            // Affichage d'un message a l'utilisateur
            req.setAttribute("ajout", "DVD ajouté !");

        } catch (DALException | SQLException e) {
            System.out.println("Pb lors de l'ajout !");
        }

        //Je déclare le RequestDispatcher
        RequestDispatcher rd;
        //Pour aller à la JSP choix
        rd = req.getRequestDispatcher("WEB-INF/selection.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Je déclare le RequestDispatcher
        RequestDispatcher rd;
        //Pour aller à la JSP choix !
        rd = req.getRequestDispatcher("WEB-INF/selection.jsp");
        rd.forward(req, resp);
    }

}
