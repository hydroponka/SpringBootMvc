package by.ageenko.SpringBootMvc.services;

import by.ageenko.SpringBootMvc.model.User;
import by.ageenko.SpringBootMvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(int id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }
    @Transactional(readOnly = true)
    public boolean authorization(String name, String password){
        Optional<User> user = userRepository.findUserByName(name);
        return user.map(value -> value.getPassword().equals(password)).orElse(false);
    }
    @Transactional
    public void save(User user){
        userRepository.save(user);
    }
    @Transactional
    public void update(int id, User user){
        user.setId(id);
        userRepository.save(user);
    }
    @Transactional
    public void deleteById(int id){
        userRepository.deleteById(id);
    }
}
