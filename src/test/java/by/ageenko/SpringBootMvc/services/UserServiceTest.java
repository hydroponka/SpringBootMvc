package by.ageenko.SpringBootMvc.services;

import by.ageenko.SpringBootMvc.model.RoleType;
import by.ageenko.SpringBootMvc.model.User;
import by.ageenko.SpringBootMvc.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    UserService service;
    @Mock
    UserRepository userRepository;

    @Test
    void findAll() {

    }

    @Test
    void findByName() {
        User user = new User();
        user.setName("Cergey");
        user.setPassword("Cergey123321");

        System.out.println(service.authorization(user.getName(),user.getPassword()));
    }

    @Test
    void save() {
        User user = new User();
        user.setName("Cergey");
        user.setEmail("Ceageenk02@gmail.com");
        user.setRoleType(RoleType.ROLE_USER);
        service.save(user);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}