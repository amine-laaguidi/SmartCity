package com.city.smartcity.Etudiant;

import java.util.List;
import java.util.Optional;

public interface CampusCatService {
    List<CampusCat> findAll() throws Exception;
    Optional<CampusCat> findById(Long idCmpCat) throws Exception;
    Optional<CampusCat> findByTitle(String titleCmpCat) throws Exception;
    CampusCat save(CampusCat campusCat) throws  Exception;
}
