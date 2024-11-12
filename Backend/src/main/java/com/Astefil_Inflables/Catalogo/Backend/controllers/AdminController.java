package com.Astefil_Inflables.Catalogo.Backend.controllers;

import com.Astefil_Inflables.Catalogo.Backend.dto.Authentication.LoginDTO;
import com.Astefil_Inflables.Catalogo.Backend.models.User;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {
    @Autowired
    private IUserService userService;

    @PostMapping(path = "/employee")
    public User createEmployee(@RequestBody LoginDTO loginDTO) {
        return this.userService.createUser(loginDTO.getUsername(), loginDTO.getPassword(), "EMPLOYEE");
    }

    @GetMapping(path = "/employee")
    public ArrayList<User> getAllEmployees() {
        return this.userService.getAllEmployees();
    }

    @PutMapping(path ="/employee/{id}")
    public User updateEmployee(@PathVariable("id") Long id, @RequestBody LoginDTO loginDTO) {
        return this.userService.updateUser(id, loginDTO.getUsername(), loginDTO.getPassword(), "EMPLOYEE");
    }

    @DeleteMapping(path = "/employee/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
    }
}