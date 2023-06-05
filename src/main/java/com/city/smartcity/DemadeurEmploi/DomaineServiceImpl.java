package com.city.smartcity.DemadeurEmploi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class DomaineServiceImpl implements DomaineService {

    private  final DomaineRepository domaineRepository;
    @Override
    public Domaine save(Domaine domaine) {
        return domaineRepository.save(domaine);
    }

    @Override
    public List<Domaine> findAll() {
        return domaineRepository.findAll();
    }
}
