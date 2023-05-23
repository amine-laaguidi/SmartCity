package com.city.smartcity.Touriste;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jdk.jfr.Registered;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Tourisme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idT;
    private String titreT;
    private String lieuT;
    @ManyToOne
    @JoinColumn(name = "idTC")
    @JsonBackReference
    private TourismeCat tourismeCat;

}
