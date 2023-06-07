package org.bedu.unit.controller;

import org.bedu.unit.service.DogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DogControllerTest {

    @InjectMocks
    private DogController controller;

    @Mock
    private DogService service;

    @Test
    @DisplayName("should return Hello World")
    public void helloworld(){
        //Cuando el MOCK del servicio invoque el metodo fetchRandomImage va a regresar el valor "Hello World"
        when(service.fetchRandomImage()).thenReturn("Hello World");

        String response = controller.fetchRandomImage();
        assertEquals(response,"Hello World");
    }

}