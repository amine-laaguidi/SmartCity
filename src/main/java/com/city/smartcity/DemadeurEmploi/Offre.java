package com.city.smartcity.DemadeurEmploi;

import com.city.smartcity.Entrepreneur.AffaireCat;
import com.city.smartcity.Entrepreneur.Entreprise;
import com.city.smartcity.Entrepreneur.Organisation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity @Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOff;
    private String titreOff;
    @Column(length = 2000)
    private String descriptionOff;
    private String adresseOff;
    @ElementCollection
    private List<String> imageUrls;
    @ManyToOne
    @JoinColumn(name = "idDom")
    @JsonBackReference
    private Domaine domaine;
    @ManyToOne
    @JoinColumn(name = "idOrg")
    @JsonBackReference
    private Organisation organisation;
    @ManyToOne
    @JoinColumn(name = "idE")
    @JsonBackReference
    private Entreprise entreprise;
}
