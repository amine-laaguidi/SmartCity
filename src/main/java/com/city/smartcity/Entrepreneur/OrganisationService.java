package com.city.smartcity.Entrepreneur;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrganisationService {
    Page<Organisation> search(String search, Pageable pageable) throws Exception;
    Optional<Organisation> findOrganisationByIdOrg(Long idOrg) throws Exception;
    Page<Organisation> findAll(Pageable pageable) throws Exception;
    List<Organisation> findAll() throws Exception;
    Organisation save(Organisation organisation) throws Exception;
}
