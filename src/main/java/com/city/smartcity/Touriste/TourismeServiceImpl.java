package com.city.smartcity.Touriste;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourismeServiceImpl implements TourismeService {
    private final TourismeRepository tourismeRepository;
    @Override
    public Page<Tourisme> search(TourismeCat tourismeCat, String search, Pageable pageable) throws Exception {
        return tourismeRepository.findTourismesByTitreTContainingIgnoreCaseAndTourismeCat(search,tourismeCat,pageable);
    }
    @Override
    public Page<Tourisme> findTourismesByCategorie(TourismeCat tourismeCat, Pageable pageable) throws Exception {
        return tourismeRepository.findTourismesByTourismeCat(tourismeCat,pageable);
    }
    @Override
    public Tourisme findTourismeByIdT(Long idT) throws Exception {
        return tourismeRepository.findById(idT).orElseThrow(() -> new Exception("item not found"));
    }
    @Override
    public Page<Tourisme> findAll(Pageable pageable) throws Exception {
        return tourismeRepository.findAll(pageable);
    }
    @Override
    public List<Tourisme> findAll() throws Exception {
        return tourismeRepository.findAll();
    }
    @Override
    public Tourisme save(Tourisme tourisme) throws Exception {
        return tourismeRepository.save(tourisme);
    }
}
