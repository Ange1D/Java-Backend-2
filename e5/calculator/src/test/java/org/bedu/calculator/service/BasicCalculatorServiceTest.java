package org.bedu.calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class) -> Pruebas de integracion
@ExtendWith(MockitoExtension.class) // -> Pruebas d eintegracion
class BasicCalculatorServiceTest {

    //Arrange (Preparacion de una preuba)
    @InjectMocks
    private BasicCalculatorService service;

    @Test
    @DisplayName("Should return 0 when both values are 0")
    public void sumWithZero() {
        //Act (Ejecucion de codigo a probar)
        int result = service.sum(0,0);

        //Assert (Comprobacion del resultado esperado)
        assertEquals(result,0);

    }

    @Test
    @DisplayName("Should return the same number when right side is zero")
    public void sumWithRightZero() {
        int result = service.sum(100,0);
        assertEquals(result,100);
    }

    @Test
    @DisplayName("Should return the same number when left side is zero")
    public void sumWithLeftZero() {
        int result = service.sum(0,80);
        assertEquals(result,80);
    }

}