package com.city.smartcity.Etudiant;

import com.city.smartcity.Touriste.Tourisme;
import com.city.smartcity.Touriste.TourismeCat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CampusService {
    Page<Campus> search(CampusCat campusCat, String search, Pageable pageable) throws Exception;
    Page<Campus> findCampusByCategorie(CampusCat campusCat, Pageable pageable) throws Exception;
    Campus findCampusByIdT(Long idCmp) throws Exception;
    Page<Campus> findAll(Pageable pageable) throws Exception;
    List<Campus> findAll() throws Exception;
    Campus save(Campus campus) throws Exception;

}
