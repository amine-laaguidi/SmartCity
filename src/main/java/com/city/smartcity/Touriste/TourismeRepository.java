package com.city.smartcity.Touriste;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TourismeRepository extends JpaRepository<Tourisme, Long> {
    Tourisme findTourismeByTourismeCatTitleTC(String titleTC);
    Page<Tourisme> findAll(Pageable pageable);
    Page<Tourisme> findTourismesByTourismeCat(TourismeCat tourismeCat,Pageable pageable);
    Page<Tourisme> findTourismesByTitreTContainingIgnoreCaseAndTourismeCat(String titleT,TourismeCat tourismeCat,Pageable pageable);
}
