package com.city.smartcity.Entrepreneur;

import com.city.smartcity.Touriste.TourismeCat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AffaireCatRepository extends JpaRepository<AffaireCat,Long> {
    Optional<AffaireCat> findAffaireCatByTitleAffCat(String  titleAffCat);
}
