package app.realtyagency.service;

import app.realtyagency.entity.Realty;
import app.realtyagency.repository.RealtyImageRepository;
import app.realtyagency.repository.RealtyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class RealtiesServiceTest {


    @Mock
    RealtyRepository realtyRepository;

    @InjectMocks
    RealtiesService realtiesService;

    private List<Realty> getRealty() {
        Realty firstRealty = new Realty();
        Realty secondRealty = new Realty();

        firstRealty.setId(1L);
        firstRealty.setUserId(1L);
        firstRealty.setPrice(100000000);
        firstRealty.setType("квартира");
        firstRealty.setDescription("продать");

        secondRealty.setId(2L);
        secondRealty.setUserId(1L);
        secondRealty.setPrice(30000000);
        secondRealty.setType("квартира");
        secondRealty.setDescription("продать");

        return List.of(firstRealty);

    }

    @Test
    void getAll() {
        List<Realty> realties = getRealty();

        Mockito.when(realtyRepository.findAll()).thenReturn(realties);

        List<Realty> result = realtiesService.getAll();

        Assertions.assertNotNull(result);
    }


//    @Test
//    void getRealtyByID() {
//        List<Realty> realties = getRealty();
//
//        Mockito.when(realtyRepository.findAll()).thenReturn(realties);
//
//        List<Realty> result = realtiesService.getAll();
//
//        Realty realty = realtiesService.getRealtyByID(1L);
//
//        Assertions.assertNotNull(result);
////        Assertions.assertEquals(realties.get(1), realty);
//        Assertions.assertEquals(1, result.size());
//    }
}