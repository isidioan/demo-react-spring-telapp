package com.iioannou.taap.repository;

import com.iioannou.taap.domain.CallerD;

import java.util.List;

/**
 * @author ioannou
 */
public interface CallerRepositoryCustom {

    List<CallerD> findFilteredByFirstnameOrLastnameOrEmail(String attribute);

}
