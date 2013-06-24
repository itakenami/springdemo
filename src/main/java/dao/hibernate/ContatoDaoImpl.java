package dao.hibernate;

import dao.ContatoDao;
import model.Contato;
import org.springframework.stereotype.Repository;


@Repository
public class ContatoDaoImpl extends CrudDAOImpl<Contato> implements ContatoDao{

}
