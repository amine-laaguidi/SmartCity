package com.city.smartcity.Etudiant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CampusCatServiceImpl implements CampusCatService {
    private final CampusCatRepository campusCatRepository;
    @Override
    public List<CampusCat> findAll() throws Exception {
        return campusCatRepository.findAll();
    }
    @Override
    public Optional<CampusCat> findById(Long idCmpCat) throws Exception {
        return Optional.ofNullable(campusCatRepository.findById(idCmpCat).orElseThrow(() -> new Exception("Campus category not found")));
    }
    @Override
    public Optional<CampusCat> findByTitle(String titleCmpCat) throws Exception {
        return Optional.ofNullable(campusCatRepository.findCampusCatByTitleCmpCat(titleCmpCat).orElseThrow(() -> new Exception("Campus category not found")));
    }

    @Override
    public CampusCat save(CampusCat campusCat) throws Exception {
        return campusCatRepository.save(campusCat);
    }
}
