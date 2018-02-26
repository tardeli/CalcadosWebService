package br.com.rocha.calcados.teste;

import br.com.rocha.calcados.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Tardeli
 */
public class HibernateUtilTeste {
    @Test
    //@Ignore
    public void conectar(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
        HibernateUtil.getSessionFactory().openSession();
    }
}
