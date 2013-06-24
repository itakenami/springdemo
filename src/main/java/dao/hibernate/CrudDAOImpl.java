package dao.hibernate;

import dao.CrudDao;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS)
public class CrudDAOImpl<T> implements CrudDao<T> {

    private Class<T> type;

    @SuppressWarnings("unchecked")
    private Class<T> getType() {
        if (type == null) {
            Type t = getClass().getGenericSuperclass();
            ParameterizedType pt = (ParameterizedType) t;
            type = (Class) pt.getActualTypeArguments()[0];
        }
        return type;
    }
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sf) {
        sessionFactory = sf;
    }

    protected Session getSession() {
        return getSessionFactory().getCurrentSession();
    }

    @Override
    public void delete(T objeto) {
        getSession().delete(objeto);
    }

    @Override
    public void save(T objeto) {
        getSession().saveOrUpdate(objeto);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        return getSession().createCriteria(getType()).list();
    }

    @Override
    public T findById(Long id) {
        return (T) getSession().get(type, id);
    }
}
