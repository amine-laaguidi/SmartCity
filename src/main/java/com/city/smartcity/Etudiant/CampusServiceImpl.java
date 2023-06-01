package com.city.smartcity.Etudiant;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CampusServiceImpl implements CampusService {
    private  final CampusRepository campusRepository;
    @Override
    public Page<Campus> search(CampusCat campusCat, String search, Pageable pageable) throws Exception {
        return campusRepository.findCampusByCampusCatAndTitreCmpContainingIgnoreCase(campusCat,search,pageable);
    }
    @Override
    public Page<Campus> findCampusByCategorie(CampusCat campusCat, Pageable pageable) throws Exception {
        return campusRepository.findCampusByCampusCat(campusCat,pageable);
    }
    @Override
    public Campus findCampusByIdT(Long idCmp) throws Exception {
        return campusRepository.findById(idCmp).orElseThrow(() -> new Exception("Campus not found"));
    }
    @Override
    public Page<Campus> findAll(Pageable pageable) throws Exception {
        return null;
    }
    @Override
    public List<Campus> findAll() throws Exception {
        return campusRepository.findAll();
    }
    @Override
    public Campus save(Campus campus) throws Exception {
        return campusRepository.save(campus);
    }
}
