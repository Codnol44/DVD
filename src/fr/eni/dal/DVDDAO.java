package fr.eni.dal;

import fr.eni.bo.Categorie;
import fr.eni.bo.DVD;

import java.sql.SQLException;
import java.util.List;

public interface DVDDAO {

    void insertDvd(DVD dvd) throws DALException, SQLException;

    List<DVD> selectDvd() throws DALException, SQLException;

    List<DVD> selectDvdByCat(int id_cat) throws DALException, SQLException;

    DVD removeDvd(String title) throws DALException, SQLException;

}
