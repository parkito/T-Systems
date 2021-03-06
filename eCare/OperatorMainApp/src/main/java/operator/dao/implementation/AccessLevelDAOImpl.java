package operator.dao.implementation;

import operator.dao.api.AccessLevelDAO;
import operator.entities.AccessLevel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Artyom Karnov on 8/26/16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Class for access level operations
 */
@Repository("AccessLevel")
public class AccessLevelDAOImpl extends GenericDAOImpl<AccessLevel, Integer> implements AccessLevelDAO {
    @PersistenceContext
    private EntityManager entityManager;
}

