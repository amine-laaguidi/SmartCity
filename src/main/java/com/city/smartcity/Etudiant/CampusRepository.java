package com.city.smartcity.Etudiant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampusRepository extends JpaRepository<Campus, Long> {
    Page<Campus> findAll(Pageable pageable);
    Page<Campus> findCampusByCampusCat(CampusCat campusCat, Pageable pageable);
    Page<Campus> findCampusByCampusCatAndTitreCmpContainingIgnoreCase(CampusCat campusCat,String titleCmp,Pageable pageable);

}
