package com.Astefil_Inflables.Catalogo.Backend.controllers;

import com.Astefil_Inflables.Catalogo.Backend.dto.Authentication.LoginDTO;
import com.Astefil_Inflables.Catalogo.Backend.dto.Authentication.ResponseLoginDTO;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthenticationController {

    @Autowired
    private IUserService userService;

    @PostMapping(path = "/login")
    public ResponseLoginDTO authenticate(@RequestBody LoginDTO loginDTO) {
        return new ResponseLoginDTO(this.userService.authenticate(loginDTO.getUsername(), loginDTO.getPassword()));
    }
}