package com.city.smartcity.DemadeurEmploi;

import java.util.List;

public interface DomaineService {
    Domaine save(Domaine domaine);
    List<Domaine> findAll();
}
