package com.city.smartcity.Entrepreneur;

import com.city.smartcity.Touriste.Tourisme;
import com.city.smartcity.Touriste.TourismeCat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AffaireRepository extends JpaRepository<Affaire,Long> {
    Affaire findAffaireByAffaireCatTitleAffCat(String titleAffCat);
    Page<Affaire> findAll(Pageable pageable);
    Page<Affaire> findAffaireByAffaireCat(AffaireCat affaireCat, Pageable pageable);
    Page<Affaire> findAffairesByTitreAffContainingIgnoreCaseAndAffaireCat(String titleAff,AffaireCat affaireCat,Pageable pageable);
}
