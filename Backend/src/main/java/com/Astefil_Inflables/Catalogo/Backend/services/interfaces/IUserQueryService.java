package com.Astefil_Inflables.Catalogo.Backend.services.interfaces;

import com.Astefil_Inflables.Catalogo.Backend.models.Role;
import com.Astefil_Inflables.Catalogo.Backend.models.User;
import com.Astefil_Inflables.Catalogo.Backend.models.UserQuery;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IUserQueryService {
    UserQuery createUserQuery(String firstName, String lastName, Long zoneId, LocalDate date, String generalQuery, String phone);
    UserQuery answerUserQuery(Long queryId);
}
