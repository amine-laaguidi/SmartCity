package com.city.smartcity.Entrepreneur;

import com.city.smartcity.DemadeurEmploi.Offre;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrg;
    private String titreOrg;
    @Column(length = 2000)
    private String descriptionOrg;
    private String adresseOrg;
    @ElementCollection
    private List<String> imageUrls;

    @OneToMany(mappedBy = "organisation",cascade =CascadeType.ALL)
    @JsonManagedReference
    private List<Offre> offres;
}
