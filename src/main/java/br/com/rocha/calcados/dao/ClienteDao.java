package br.com.rocha.calcados.dao;

import br.com.rocha.calcados.modelo.Cliente;
import br.com.rocha.calcados.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Tardeli
 */
public class ClienteDao extends Generic_Dao<Cliente> implements Serializable{
    private Session sessao;   
    
    public List<Cliente> pesquisarCliente(String nome){
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();        
        List<Cliente> clientes = new ArrayList<>();
        try {
            Criteria criteria = sessao.createCriteria(Cliente.class);
            criteria.add(Restrictions.like("nome",  nome, MatchMode.ANYWHERE));
            return clientes = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sessao.close();
        }   
        return clientes;
    }
}
