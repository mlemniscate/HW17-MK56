package ir.maktab.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory mainEntityManagerFactory;

    static {
        mainEntityManagerFactory = Persistence.createEntityManagerFactory("MK56HW17");
    }

    public static EntityManagerFactory getMainEntityManagerFactory() {
        return mainEntityManagerFactory;
    }

}
