package com.city.smartcity.Touriste;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourismeServiceImpl implements TourismeService {
    private final TourismeRepository tourismeRepository;
    @Override
    public Page<Tourisme> findTourismesByTourismeCatIdTCAndTitreTContaining(Long idTC,String titleTC, Pageable pageable) throws Exception {
        return tourismeRepository.findTourismesByTourismeCatIdTCAndTitreTContaining(idTC,titleTC,pageable);
    }
    @Override
    public Page<Tourisme> findAll(Pageable pageable) throws Exception {
        return tourismeRepository.findAll(pageable);
    }

    @Override
    public List<Tourisme> findAll() throws Exception {
        return tourismeRepository.findAll();
    }
}
