package fr.eni.bll;

import fr.eni.bo.DVD;
import fr.eni.dal.DVDDAO;
import fr.eni.dal.DALException;
import fr.eni.dal.DAOFactory;
import java.sql.SQLException;
import java.util.List;

public class DVDManager {

    public static void addDvd(String title, int year, String actor, int price, int id_cat) throws DALException, SQLException {
        DVD dvd = new DVD(title, year, actor, price, id_cat);
        DVDDAO dvddao = DAOFactory.getDVDDAO();
        dvddao.insertDvd(dvd);
    }

    public List<DVD> displayDvd() throws DALException, SQLException {
        DVDDAO dvddao = DAOFactory.getDVDDAO();
        List<DVD> list = dvddao.selectDvd();
        return list;
    }

    public List<DVD> displayDvdByCat(int id_cat) throws DALException, SQLException {
        DVDDAO dvddao = DAOFactory.getDVDDAO();
        List<DVD> list = dvddao.selectDvdByCat(id_cat);
        return list;
    }

    public DVD deleteDvd(String title) throws DALException, SQLException {
        DVDDAO dvddao = DAOFactory.getDVDDAO();
        DVD dvd = dvddao.removeDvd(title);
        return dvd;
    }

}
