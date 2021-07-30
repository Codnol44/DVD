package fr.eni.servlets;

import fr.eni.bll.DVDManager;
import fr.eni.bo.Categorie;
import fr.eni.bo.DVD;
import fr.eni.dal.DALException;
import fr.eni.dal.DAOFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectionServlet  extends HttpServlet {
    private Object List;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Créer une liste de DVD via DVDManager
        java.util.List<DVD> listDvd = new ArrayList<>();
        DVDManager dm;
        try {
            dm = new DVDManager();
            listDvd = dm.displayDvd();

        } catch (DALException | SQLException e) {
            System.out.println("Pb lors de la sélection liste !");
        }

        //La servlet envoie l'info à la JSP !
        req.setAttribute("listDvd", listDvd);

        //Je déclare le RequestDispatcher
        RequestDispatcher rd;
        //Pour aller à la JSP choix !
        rd = req.getRequestDispatcher("WEB-INF/collection.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //On récupère la catégorie si saisie
        Integer id_cat = 0;
        if (req.getParameter("categorie") != null) {
            id_cat = Integer.valueOf(req.getParameter("categorie"));


            //On fait appel au Manager pour Afficher par catégorie
            DVDManager dm;
            java.util.List<DVD> listDvd = new ArrayList<>();
            try {
                dm = new DVDManager();
                listDvd = dm.displayDvdByCat(id_cat);

            } catch (DALException | SQLException e) {
                System.out.println("Pb lors de la sélection liste par catégorie !");
            }
            //La servlet envoie l'info à la JSP !
            req.setAttribute("listDvd", listDvd);

            //Je déclare le RequestDispatcher
            RequestDispatcher rd;
            rd = req.getRequestDispatcher("WEB-INF/collection.jsp");
            rd.forward(req, resp);
        } //On referme volontairement la parenthèse du if ici ! !

        //On récupére le titre du film à virer si saisi
        String title = req.getParameter("title");

        //A partir du paramètre, créer une instance via le Manager
        DVD dvd = new DVD();
        DVDManager dm2;
        try {
            dm2 = new DVDManager();
            dvd = dm2.deleteDvd(title);

        } catch (DALException | SQLException e) {
            System.out.println("Pb lors de la demande de suppression !");
        }

        // Je rappelle la méthode doGet pour l'affichage global
        this.doGet(req, resp);
        }
    }
