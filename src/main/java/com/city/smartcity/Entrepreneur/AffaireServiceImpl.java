package com.city.smartcity.Entrepreneur;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AffaireServiceImpl implements AffaireService {
    private final AffaireRepository affaireRepository;
    @Override
    public Page<Affaire> search(AffaireCat affaireCat, String search, Pageable pageable) throws Exception {
        return affaireRepository.findAffairesByTitreAffContainingIgnoreCaseAndAffaireCat(search,affaireCat,pageable);
    }

    @Override
    public Page<Affaire> findAffairesByCategorie(AffaireCat affaireCat, Pageable pageable) throws Exception {
        return affaireRepository.findAffaireByAffaireCat(affaireCat,pageable);
    }

    @Override
    public Optional<Affaire> findAffaireByIdAff(Long idAff) throws Exception {
        return affaireRepository.findById(idAff);
    }

    @Override
    public Page<Affaire> findAll(Pageable pageable) throws Exception {
        return affaireRepository.findAll(pageable);
    }

    @Override
    public List<Affaire> findAll() throws Exception {
        return affaireRepository.findAll();
    }

    @Override
    public Affaire save(Affaire affaire) throws Exception {
        return affaireRepository.save(affaire);
    }
}
