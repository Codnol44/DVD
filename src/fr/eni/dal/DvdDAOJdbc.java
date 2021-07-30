package fr.eni.dal;

import fr.eni.bo.Categorie;
import fr.eni.bo.DVD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DvdDAOJdbc implements DVDDAO {

    //1-Ajout d'un DVD
    @Override
    public void insertDvd(DVD dvd) throws SQLException {

        String INSER_BOUT = "INSERT into DVDs(title, year, actor, price, id_cat) VALUES(?,?,?,?,?)";

        try (
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement pstt = connection.prepareStatement(INSER_BOUT, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {

            //On remplace les ? dans la requete
            pstt.setString(1, dvd.getTitle());
            pstt.setInt(2, dvd.getYear());
            pstt.setString(3, dvd.getActor());
            pstt.setInt(4, dvd.getPrice());
            pstt.setInt(5, dvd.getId_cat());

            //J'exécute la requête
            pstt.executeUpdate();

            //On récupère l'id généré
            ResultSet rs = pstt.getGeneratedKeys();
            if (rs.next()) {
                dvd.setId(rs.getInt(1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //2-Affichage du catalogue
    @Override
    public List<DVD> selectDvd() throws DALException, SQLException {

        String DISPLAY_DVD = "SELECT * FROM DVDs";

        List<DVD> listDvd = new ArrayList<>();
        try (
                //On lance la connexion
                Connection connection = ConnectionProvider.getConnection();
                Statement stt = connection.createStatement();
        ) {
            //J'exécute la requête
            ResultSet rs = stt.executeQuery(DISPLAY_DVD);

            //On ajoute les paramètres de son objet avec le get
            while (rs.next()) {
                listDvd.add(new DVD(rs.getString("title"), rs.getInt("year"), rs.getString("actor"), rs.getInt("price"), rs.getInt("id_cat")));
            }
        }
        return listDvd;
    }

    //3-Affichage du catalogue par categorie
    @Override
    public List<DVD> selectDvdByCat(int id_cat) throws DALException, SQLException {

        String DISPLAY_DVD_BY_CAT = "SELECT d.title, d.year, d.actor, d.price, c.libelle FROM DVDs d INNER JOIN CATEGORIES c ON d.id_cat = c.id_cat AND c.id_cat = ?";

        List<DVD> listDvd = new ArrayList<>();
        try (
                //On remplace la connexion initiale
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement pstt = connection.prepareStatement(DISPLAY_DVD_BY_CAT);
        ) {

            //Remplacer le ? dans la requete
            pstt.setInt(1, id_cat);

            //J'exécute la requête
            ResultSet rs = pstt.executeQuery();

            //On recupere les paramètres de son objet avec le get (mais pas le id_cat !)
            while (rs.next()) {
                listDvd.add(new DVD(rs.getString("title"), rs.getInt("year"), rs.getString("actor"), rs.getInt("price")));
            }
        }
        return listDvd;
    }

    //4-Suppression d'un DVD
    @Override
    public DVD removeDvd(String title) throws DALException, SQLException {

        String DELETE_DVD = "DELETE FROM DVDs WHERE title = ?";

        try (
                //On remplace la connexion initiale
                Connection connection = ConnectionProvider.getConnection();
                PreparedStatement pstt = connection.prepareStatement(DELETE_DVD);
        ) {
            pstt.setString(1, title);
            pstt.executeUpdate();

        } catch (SQLException throwables) {
            System.out.println("Pb lors de la suppression DVD !");
        }
        return null;
    }

}