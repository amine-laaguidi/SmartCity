package com.city.smartcity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CampusCatRepository extends JpaRepository<CampusCat,Long> {
    Optional<CampusCat> findCampusCatByTitleCmpCat(String TitleCmpCat);
}
