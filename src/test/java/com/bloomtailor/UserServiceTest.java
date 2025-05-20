package com.bloomtailor.service;

import com.bloomtailor.model.Role;
import com.bloomtailor.model.User;
import com.bloomtailor.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = List.of(
                new User("user1", "pass1"),
                new User("user2", "pass2")
        );
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetUserById() {
        User user = new User("user1", "pass1");
        user.setId(1L);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> found = userService.getUserById(1L);

        assertTrue(found.isPresent());
        assertEquals("user1", found.get().getUsername());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testGetUserByUsername() {
        User user = new User("user1", "pass1");
        when(userRepository.findByUsername("user1")).thenReturn(Optional.of(user));

        Optional<User> found = userService.getUserByUsername("user1");

        assertTrue(found.isPresent());
        assertEquals("user1", found.get().getUsername());
        verify(userRepository, times(1)).findByUsername("user1");
    }

    @Test
    void testSaveUser() {
        User user = new User("user1", "pass1");
        when(userRepository.save(user)).thenReturn(user);

        User saved = userService.saveUser(user);

        assertNotNull(saved);
        assertEquals("user1", saved.getUsername());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }
}
