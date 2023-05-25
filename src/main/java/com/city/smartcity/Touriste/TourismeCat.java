package com.city.smartcity.Touriste;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class TourismeCat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTC;
    private String titleTC;
    private String imgTC;
    @OneToMany(mappedBy = "tourismeCat",cascade =CascadeType.ALL)
    @JsonManagedReference
    private List<Tourisme> tourismeList;

}
