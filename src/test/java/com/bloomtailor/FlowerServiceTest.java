package com.bloomtailor.service;

import com.bloomtailor.model.Flower;
import com.bloomtailor.repository.FlowerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FlowerServiceTest {

    @Mock
    private FlowerRepository flowerRepository;

    @InjectMocks
    private FlowerService flowerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllFlowers() {
        Flower f1 = new Flower(1L, "Rose", "rose.jpg", "Red", 2.5);
        Flower f2 = new Flower(2L, "Tulip", "tulip.jpg", "Pink", 1.8);

        when(flowerRepository.findAll()).thenReturn(Arrays.asList(f1, f2));

        List<Flower> result = flowerService.getAllFlowers();

        assertEquals(2, result.size());
        assertEquals("Rose", result.get(0).getName());
        verify(flowerRepository, times(1)).findAll();
    }

    @Test
    void testGetFlowerByIdFound() {
        Flower flower = new Flower(1L, "Rose", "rose.jpg", "Red", 2.5);
        when(flowerRepository.findById(1L)).thenReturn(Optional.of(flower));

        Optional<Flower> result = flowerService.getFlowerById(1L);

        assertTrue(result.isPresent());
        assertEquals("Rose", result.get().getName());
    }

    @Test
    void testGetFlowerByIdNotFound() {
        when(flowerRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Flower> result = flowerService.getFlowerById(99L);

        assertFalse(result.isPresent());
    }

    @Test
    void testAddFlower() {
        Flower flowerToAdd = new Flower(null, "Lily", "lily.jpg", "White", 3.0);
        Flower savedFlower = new Flower(3L, "Lily", "lily.jpg", "White", 3.0);

        when(flowerRepository.save(flowerToAdd)).thenReturn(savedFlower);

        Flower result = flowerService.addFlower(flowerToAdd);

        assertNotNull(result.getId());
        assertEquals("Lily", result.getName());
        verify(flowerRepository, times(1)).save(flowerToAdd);
    }
}
