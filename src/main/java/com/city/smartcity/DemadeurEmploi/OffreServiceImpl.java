package com.city.smartcity.DemadeurEmploi;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class OffreServiceImpl implements OffreService {
    private final OffreRepository offreRepository;
    @Override
    public Page<Offre> search(String titreDom, String titreE, String titreOrg, String titreOff, Pageable pageable) throws Exception {
        return offreRepository.findByDomaineAndSearch(titreDom,titreE,titreOrg,titreOff,pageable);
    }

    @Override
    public Page<Offre> search(String titreDom, String titreE, String titreOff, Pageable pageable) throws Exception {
        return offreRepository.findByDomaineAndSearch(titreDom,titreE,titreOff,pageable);
    }

    @Override
    public Page<Offre> searchOrg(String titreDom, String titreOrg, String titreOff, Pageable pageable) throws Exception {
        return offreRepository.findByDomaineAndSearchOrg(titreDom,titreOrg,titreOff,pageable);
    }

    @Override
    public Page<Offre> search(String titreDom, String titreOff, Pageable pageable) throws Exception {
        return offreRepository.findByDomaineAndSearch(titreDom,titreOff,pageable);
    }

    @Override
    public Optional<Offre> getOffreById(Long idOff) throws Exception {
        return offreRepository.findById(idOff);
    }
    @Override
    public Offre save(Offre offre) {
        return offreRepository.save(offre);
    }
}
