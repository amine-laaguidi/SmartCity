package com.city.smartcity.Entrepreneur;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EntrepriseService {
    Page<Entreprise> search(String search, Pageable pageable) throws Exception;
    Optional<Entreprise> findEtrepriseByIdE(Long idE) throws Exception;
    Page<Entreprise> findAll(Pageable pageable) throws Exception;
    List<Entreprise> findAll() throws Exception;
    Entreprise save(Entreprise entreprise) throws Exception;
}
