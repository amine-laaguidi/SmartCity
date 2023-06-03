package com.city.smartcity.Entrepreneur;

import com.city.smartcity.Touriste.TourismeCat;

import java.util.List;
import java.util.Optional;

public interface AffaireCatService {
    List<AffaireCat> findAll() throws Exception;
    Optional<AffaireCat> findById(Long idAffCat) throws Exception;
    Optional<AffaireCat> findByTitle(String titleAffCat) throws Exception;
    AffaireCat save(AffaireCat affaireCat) throws Exception;
}
