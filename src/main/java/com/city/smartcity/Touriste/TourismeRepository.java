package com.city.smartcity.Touriste;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;



public interface TourismeRepository extends JpaRepository<Tourisme, Long> {
    Page<Tourisme> findTourismesByTourismeCat(TourismeCat tourismeCat, Pageable pageable);

    Page<Tourisme> findAll(Pageable pageable);
    Page<Tourisme> findTourismesByTourismeCatIdTCAndTitreTContaining(Long idTC,String titleTC,Pageable pageable);
}
