package br.com.rocha.calcados.dao;

import br.com.rocha.calcados.modelo.ItemPedido;
import br.com.rocha.calcados.modelo.Pedido;
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
 * @author DaRocha
 */
public class ItemPedidoDao extends Generic_Dao<ItemPedido> implements Serializable{
    
}
