package com.city.smartcity.Entrepreneur;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AffaireCatServiceImpl implements AffaireCatService {
    private final AffaireCatRepository affaireCatRepository;
    @Override
    public List<AffaireCat> findAll() throws Exception {
        return affaireCatRepository.findAll();
    }

    @Override
    public Optional<AffaireCat> findById(Long idAffCat) throws Exception {
        return affaireCatRepository.findById(idAffCat);
    }

    @Override
    public Optional<AffaireCat> findByTitle(String titleAffCat) throws Exception {
        return affaireCatRepository.findAffaireCatByTitleAffCat(titleAffCat);
    }

    @Override
    public AffaireCat save(AffaireCat affaireCat) throws Exception {
        return affaireCatRepository.save(affaireCat);
    }
}
