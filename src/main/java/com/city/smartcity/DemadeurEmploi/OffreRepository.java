package com.city.smartcity.DemadeurEmploi;

import com.city.smartcity.Entrepreneur.Entreprise;
import com.city.smartcity.Entrepreneur.Organisation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

public interface OffreRepository extends JpaRepository<Offre,Long> {
    @Query("SELECT o FROM Offre o WHERE o.domaine.titreDom LIKE %:titreDom% AND o.entreprise.titreE like %:titreE% AND o.organisation.titreOrg like %:titreOrg% AND o.titreOff LIKE %:titreOff% ")
    Page<Offre> findByDomaineAndSearch(String titreDom,String titreE,String titreOrg,String titreOff, Pageable pageable);
}
