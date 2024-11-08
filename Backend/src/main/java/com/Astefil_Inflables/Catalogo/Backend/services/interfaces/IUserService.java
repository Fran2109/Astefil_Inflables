package com.Astefil_Inflables.Catalogo.Backend.services.interfaces;

import com.Astefil_Inflables.Catalogo.Backend.models.Role;
import com.Astefil_Inflables.Catalogo.Backend.models.User;

import java.util.ArrayList;

public interface IUserService {
    User createUser(User user);
    User createUser(String username, String password, String role);
    Role createRole(Role role);
    boolean checkUserById(Long id);
    String authenticate(String username, String password);
    User getUserInfo();
    ArrayList<User> getAllEmployees();
    User updateUser(Long id, String username, String password, String role);
    void deleteUser(Long id);
}
