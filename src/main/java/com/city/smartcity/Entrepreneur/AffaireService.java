package com.city.smartcity.Entrepreneur;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AffaireService {
    Page<Affaire> search(AffaireCat affaireCat, String search, Pageable pageable) throws Exception;
    Page<Affaire> findAffairesByCategorie(AffaireCat affaireCat, Pageable pageable) throws Exception;
    Optional<Affaire> findAffaireByIdAff(Long idAff) throws Exception;
    Page<Affaire> findAll(Pageable pageable) throws Exception;
    List<Affaire> findAll() throws Exception;
    Affaire save(Affaire affaire) throws Exception;
}
