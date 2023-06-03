package com.city.smartcity.Entrepreneur;

import com.city.smartcity.Touriste.TourismeCat;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idE;
    private String titreE;
    @Column(length = 2000)
    private String descriptionE;
    private String adresseE;
    @ElementCollection
    private List<String> imageUrls;
}
