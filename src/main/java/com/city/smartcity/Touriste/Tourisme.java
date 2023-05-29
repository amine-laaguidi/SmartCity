package com.city.smartcity.Touriste;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jdk.jfr.Registered;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Tourisme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idT;
    private String titreT;
    @Column(length = 2000)
    private String descriptionT;
    private String adresseT;
    @ElementCollection
    private List<String> imageUrls;
    @ManyToOne
    @JoinColumn(name = "idTC")
    @JsonBackReference
    private TourismeCat tourismeCat;

}
