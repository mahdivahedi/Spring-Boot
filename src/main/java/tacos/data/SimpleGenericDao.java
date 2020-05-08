package tacos.data;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.Serializable;
import java.util.List;

@Slf4j
@Configuration
@EnableTransactionManagement
public class SimpleGenericDao implements IngredientRepository {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public List findAll(Class entityClass) {
        return null;
    }

    @Override
    public <E> boolean save(E entity) {

        boolean result = false;
        try {
            sessionFactory.openSession().save(entity);
            result = true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public <E, K extends Serializable> E findOne(K id) {
        return null;
    }
}
