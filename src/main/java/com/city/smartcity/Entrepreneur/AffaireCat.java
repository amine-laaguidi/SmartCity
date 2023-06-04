package com.city.smartcity.Entrepreneur;

import com.city.smartcity.Touriste.Tourisme;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AffaireCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAffCat;
    private String titleAffCat;
    private String imgAffCat;
    @OneToMany(mappedBy = "affaireCat",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Affaire> affaireList;
}
