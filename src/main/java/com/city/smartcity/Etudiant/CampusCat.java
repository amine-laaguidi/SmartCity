package com.city.smartcity.Etudiant;

import com.city.smartcity.Touriste.Tourisme;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CampusCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCmpCat;
    private String titleCmpCat;
    private String imgCmpCat;
    @OneToMany(mappedBy = "campusCat",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Campus> campusList;
}
