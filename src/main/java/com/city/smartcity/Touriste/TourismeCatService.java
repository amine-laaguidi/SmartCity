package com.city.smartcity.Touriste;

import java.util.List;
import java.util.Optional;

public interface TourismeCatService {
    List<TourismeCat> findAll() throws Exception;
    Optional<TourismeCat> findById(Long idTC) throws Exception;
    Optional<TourismeCat> findByTitle(String titleTC) throws Exception;

    TourismeCat save(TourismeCat tourismeCat) throws Exception;
}
