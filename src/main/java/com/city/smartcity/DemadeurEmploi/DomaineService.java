package com.city.smartcity.DemadeurEmploi;

import java.util.List;
import java.util.Optional;

public interface DomaineService {
    Domaine save(Domaine domaine);
    List<Domaine> findAll();
    Optional<Domaine> findByIdDom(Long idDom);
}
