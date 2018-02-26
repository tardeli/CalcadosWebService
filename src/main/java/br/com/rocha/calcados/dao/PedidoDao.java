package br.com.rocha.calcados.dao;

import br.com.rocha.calcados.modelo.Pedido;
import br.com.rocha.calcados.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DaRocha
 */
public class PedidoDao extends Generic_Dao<Pedido> implements Serializable{
    private Session sessao;
    private Transaction transacao;

    public List<Pedido> listaPedido_semRepetir(){
        try {
            sessao = (Session) HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = sessao.createCriteria(Pedido.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            sessao.close();
        } 
    }
}
