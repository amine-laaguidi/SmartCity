package com.city.smartcity.Entrepreneur;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AffaireCatServiceImpl implements AffaireCatService {
    private final AffaireCatService affaireCatService;
    @Override
    public List<AffaireCat> findAll() throws Exception {
        return affaireCatService.findAll();
    }

    @Override
    public Optional<AffaireCat> findById(Long idAffCat) throws Exception {
        return affaireCatService.findById(idAffCat);
    }

    @Override
    public Optional<AffaireCat> findByTitle(String titleAffCat) throws Exception {
        return affaireCatService.findByTitle(titleAffCat);
    }

    @Override
    public AffaireCat save(AffaireCat affaireCat) throws Exception {
        return affaireCatService.save(affaireCat);
    }
}
