package com.city.smartcity.Entrepreneur;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {
    private final OrganisationRepository organisationRepository;
    @Override
    public Page<Organisation> search(String search, Pageable pageable) throws Exception {
        return organisationRepository.findOrganisationsByTitreOrgContaining(search,pageable);
    }

    @Override
    public Optional<Organisation> findOrganisationByIdOrg(Long idOrg) throws Exception {
        return organisationRepository.findById(idOrg);
    }

    @Override
    public Page<Organisation> findAll(Pageable pageable) throws Exception {
        return organisationRepository.findAll(pageable);
    }

    @Override
    public List<Organisation> findAll() throws Exception {
        return organisationRepository.findAll();
    }

    @Override
    public Organisation save(Organisation organisation) throws Exception {
        return organisationRepository.save(organisation);
    }
}
