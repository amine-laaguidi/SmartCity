package com.city.smartcity.Touriste;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TourismeService {
    Page<Tourisme> search(TourismeCat tourismeCat,String search, Pageable pageable) throws Exception;
    Page<Tourisme> findTourismesByCategorie(TourismeCat tourismeCat, Pageable pageable) throws Exception;
    Tourisme findTourismeByIdT(Long idT) throws Exception;
    Page<Tourisme> findAll(Pageable pageable) throws Exception;
    List<Tourisme> findAll() throws Exception;
    Tourisme save(Tourisme tourisme) throws Exception;

}
