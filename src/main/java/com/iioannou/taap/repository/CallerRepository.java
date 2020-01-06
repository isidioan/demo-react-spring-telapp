package com.iioannou.taap.repository;

import com.iioannou.taap.domain.CallerD;
import com.iioannou.taap.entity.Caller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ioannou
 */
@Repository
public interface CallerRepository extends JpaRepository<Caller, Long>, CallerRepositoryCustom {

    @Query(" select new com.iioannou.taap.domain.CallerD(c.id, c.firstName, c.lastName, c.image, c.email) from Caller c " +
            " order by c.firstName")
    List<CallerD> findAllCallers();

    @Query(" select new com.iioannou.taap.domain.CallerD(c.id, c.firstName, c.lastName, c.image, c.email) from Caller c " +
            " where c.id = :id ")
    CallerD findCallerById(@Param("id") Long callerId);

    @Query(" select distinct cal.contactedCallerId from Caller c join c.callContacts cal where c.id = :id")
    List<Long> findContactedUsersOfCaller(@Param("id") Long callerId);
}

