package com.city.smartcity.Touriste;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TourismeCatRepository extends JpaRepository<TourismeCat,Long> {
    Optional<TourismeCat> findTourismeCatByTitleTC(String titleTC);
}
