package fr.eni.dal;

public class DAOFactory {

    public static DVDDAO getDVDDAO() {
        DVDDAO dvddao = new DvdDAOJdbc();
        return dvddao;
    }

}