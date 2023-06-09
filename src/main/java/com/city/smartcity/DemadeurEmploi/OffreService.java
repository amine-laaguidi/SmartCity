package com.city.smartcity.DemadeurEmploi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OffreService {
    Page<Offre> search(String titreDom, String titreE, String titreOrg, String titreOff, Pageable pageable) throws Exception;
    Page<Offre> search(String titreDom, String titreE, String titreOff, Pageable pageable) throws Exception;
    Page<Offre> searchOrg(String titreDom, String titreOrg, String titreOff, Pageable pageable) throws Exception;
    Page<Offre> search(String titreDom, String titreOff, Pageable pageable) throws Exception;
    Optional<Offre> getOffreById(Long idOff) throws Exception;
    Offre save(Offre offre);
}
