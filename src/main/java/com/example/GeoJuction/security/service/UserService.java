package com.example.GeoJuction.security.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.GeoJuction.security.model.Role;
import com.example.GeoJuction.security.model.User;
import com.example.GeoJuction.security.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private RoleRepository roleRepository;

    //Get All Users
    public List<User> findAll() {
        return userRepository.findAll();
    }

      //Get User By Id
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    //Delete User
    public void delete(int id) {
        userRepository.deleteById(id);
    }



    //save new user
    public void save(User user)
    {
        //encode password
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
        
    }

    // public void createRoles() {
    //     if (roleRepository.count() == 0) {
    //         Role roleAccounts = roleRepository.findByDescription("ACCOUNTANT");
    //         if (roleAccounts == null) {
    //             roleAccounts = new Role();
    //             roleAccounts.setDescription("ACCOUNTANT");
    //             roleAccounts.setDetails("ACCOUNTANT");
    //             roleRepository.save(roleAccounts);
    //         }
    
    //         Role roleAgent = roleRepository.findByDescription("AGENT");
    //         if (roleAgent == null) {
    //             roleAgent = new Role();
    //             roleAccounts.setDescription("AGENT");
    //             roleAccounts.setDetails("AGENT");
    //             roleRepository.save(roleAgent);
    //         }
    //     }
    // }

    public void createAdminUser() {
        Optional<User> optionalAdmin = userRepository.findByEmail("admin@example.com");

        if (optionalAdmin.isPresent()) {
            return; // admin user already exists
        }

        Role adminRole = new Role(null, "ADMIN", "ADMIN");

        String encodedPassword = encoder.encode("admin");
     
        User adminUser = User.builder()
                .username("admin")
                .password(encodedPassword) // password is "password"
                .email("admin@example.com")
                .firstname("Admin")
                .lastname("Admin")
                .roles(Set.of(adminRole))
                .build();

        userRepository.save(adminUser);
    }

    public List<User> getLoggedInAgents() {
        return userRepository.findByRolesDescriptionOrDetailsAndLoggedIn("AGENT", true);
    }

    //search for users
    public List<User> searchUsers(String query) {
        return userRepository.searchUsers(query);
    }
    
}
