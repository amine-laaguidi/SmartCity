package com.city.smartcity.Touriste;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@RequiredArgsConstructor
public class TourismeConfig {

    private final TourismeRepository tourismeRepository;
    private final TourismeCatRepository tourismeCatRepository;
//    @Bean
  //  CommandLineRunner initTourisme(){
//        return args -> {
//            TourismeCat hotel = tourismeCatRepository.save(
//                    new TourismeCat(
//                            null,
//                            "hotel",
//                            null,
//                            new ArrayList<Tourisme>()
//                    )
//            );
//            TourismeCat banque = tourismeCatRepository.save(
//                    new TourismeCat(
//                            null,
//                            "banque",
//                            null,
//                            new ArrayList<Tourisme>()
//                    )
//            );
//            Tourisme hitel1 = tourismeRepository.save(
//                    new Tourisme(
//                            null,
//                            "hotel casa",
//                            "Casablanca",
//                            hotel
//                    )
//            );
//            Tourisme hitel2 = tourismeRepository.save(
//                    new Tourisme(
//                            null,
//                            "hotel rabat",
//                            "rabat",
//                            hotel
//                    )
//            );
//            Tourisme cih = tourismeRepository.save(
//                    new Tourisme(
//                            null,
//                            "cih",
//                            "oulfa",
//                            banque
//                    )
//            );
//            Tourisme bmce = tourismeRepository.save(
//                    new Tourisme(
//                            null,
//                            "bmce",
//                            "mdina",
//                            banque
//                    )
//            );
//        };
 //   }
}
