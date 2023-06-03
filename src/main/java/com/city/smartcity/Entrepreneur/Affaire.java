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
public class Affaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAff;
    private String titreAff;
    @Column(length = 2000)
    private String descriptionAff;
    private String adresseAff;
    @ElementCollection
    private List<String> imageUrls;
    @ManyToOne
    @JoinColumn(name = "idAffCat")
    @JsonBackReference
    private AffaireCat affaireCat;
}
