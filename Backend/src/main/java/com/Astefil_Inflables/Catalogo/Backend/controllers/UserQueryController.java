package com.Astefil_Inflables.Catalogo.Backend.controllers;

import com.Astefil_Inflables.Catalogo.Backend.dto.UserQuery.UserQueryDTO;
import com.Astefil_Inflables.Catalogo.Backend.models.UserQuery;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IUserQueryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user_query")
public class UserQueryController {

    @Autowired
    private IUserQueryService userQueryService;

    @PostMapping
    public ResponseEntity<UserQuery> createUserQuery(@Valid @RequestBody UserQueryDTO userQueryDTO) {
        UserQuery userQuery = userQueryService.createUserQuery(
                userQueryDTO.getFirstName(),
                userQueryDTO.getLastName(),
                userQueryDTO.getZoneId(),
                userQueryDTO.getDate(),
                userQueryDTO.getGeneralQuery(),
                userQueryDTO.getPhone()
        );
        return ResponseEntity.ok(userQuery);
    }

    @PutMapping("/{id}/answer")
    public ResponseEntity<UserQuery> answerUserQuery(@PathVariable Long id) {
        UserQuery userQuery = userQueryService.answerUserQuery(id);
        return ResponseEntity.ok(userQuery);
    }
}