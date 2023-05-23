package com.city.smartcity.Touriste;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourismeCatServiceImpl implements TourismeCatService {
    private final TourismeCatRepository tourismeCatRepository ;
    @Override
    public List<TourismeCat> findAll() throws Exception {
        return tourismeCatRepository.findAll();
    }

    @Override
    public Optional<TourismeCat> findById(Long idTC) throws Exception {
        return tourismeCatRepository.findById(idTC);
    }

    @Override
    public Optional<TourismeCat> findByTitle(String titleTC) throws Exception {
        return tourismeCatRepository.findTourismeCatByTitleTC(titleTC);
    }
}
