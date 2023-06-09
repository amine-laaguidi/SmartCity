package com.city.smartcity.Etudiant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Campus {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCmp;
    private String titreCmp;
    @Column(length = 2000)
    private String descriptionCmp;
    private String adresseCmp;
    @ElementCollection
    private List<String> imageUrls;
    @ManyToOne
    @JoinColumn(name = "idCCat")
    @JsonBackReference
    private CampusCat campusCat;
}