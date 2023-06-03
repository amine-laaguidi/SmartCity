package com.city.smartcity.Entrepreneur;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    Page<Organisation> findOrganisationsByTitreOrgContaining(String titleE, Pageable pageable);
}
