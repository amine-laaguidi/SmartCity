package com.city.smartcity.Entrepreneur;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntrepriseServiceImpl implements EntrepriseService {
    private final EntrepriseRepository entrepriseRepository;
    @Override
    public Page<Entreprise> search(String search, Pageable pageable) throws Exception {
        return entrepriseRepository.findEntreprisesByTitreEContaining(search,pageable);
    }
    @Override
    public Optional<Entreprise> findEtrepriseByIdE(Long idE) throws Exception {
        return entrepriseRepository.findById(idE);
    }

    @Override
    public Page<Entreprise> findAll(Pageable pageable) throws Exception {
        return entrepriseRepository.findAll(pageable);
    }

    @Override
    public List<Entreprise> findAll() throws Exception {
        return entrepriseRepository.findAll();
    }

    @Override
    public Entreprise save(Entreprise entreprise) throws Exception {
        return entrepriseRepository.save(entreprise);
    }
}
