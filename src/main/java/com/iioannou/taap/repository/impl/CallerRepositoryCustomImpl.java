package com.iioannou.taap.repository.impl;

import com.iioannou.taap.domain.CallerD;
import com.iioannou.taap.entity.Caller;
import com.iioannou.taap.repository.CallerRepositoryCustom;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author ioannou
 */
public class CallerRepositoryCustomImpl implements CallerRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public List<CallerD> findFilteredByFirstnameOrLastnameOrEmail(String attribute) {
       String queryParam = "%".concat(attribute).concat("%");
        return em.createQuery("select new com.iioannou.taap.domain.CallerD(c.id, c.firstName, c.lastName, c.image, c.email) from Caller c " +
                " where c.firstName like ?1 or c.lastName like ?1 " +
                " or c.email like ?1", CallerD.class).setParameter(1, queryParam).getResultList();
    }
}
