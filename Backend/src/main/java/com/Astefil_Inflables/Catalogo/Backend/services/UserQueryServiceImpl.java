package com.Astefil_Inflables.Catalogo.Backend.services;

import com.Astefil_Inflables.Catalogo.Backend.exceptions.ItemNotFoundException;
import com.Astefil_Inflables.Catalogo.Backend.models.User;
import com.Astefil_Inflables.Catalogo.Backend.models.UserQuery;
import com.Astefil_Inflables.Catalogo.Backend.models.Zone;
import com.Astefil_Inflables.Catalogo.Backend.repositories.UserQueryRepository;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IUserQueryService;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IUserService;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserQueryServiceImpl implements IUserQueryService {
    @Autowired
    private UserQueryRepository userQueryRepository;

    @Autowired
    private IZoneService zoneService;

    @Autowired
    private IUserService userService;

    @Override
    public UserQuery createUserQuery(String firstName, String lastName, Long zoneId, LocalDate date, String generalQuery, String phone) {
        Zone zone = zoneService.getZoneById(zoneId);
        UserQuery userQuery = new UserQuery();
        userQuery.setFirstName(firstName);
        userQuery.setLastName(lastName);
        userQuery.setZone(zone);
        userQuery.setDate(date);
        userQuery.setGeneralQuery(generalQuery);
        userQuery.setPhone(phone);
        userQuery.setIsAnswered(false);
        return userQueryRepository.save(userQuery);
    }

    @Override
    public UserQuery answerUserQuery(Long queryId) {
        User answeredByUser  = userService.getUserInfo();
        UserQuery userQuery = userQueryRepository.findById(queryId).orElseThrow(() -> new ItemNotFoundException("Query not found"));
        userQuery.setIsAnswered(true);
        userQuery.setAnsweredDateTime(LocalDateTime.now());
        userQuery.setAnsweredByUser(answeredByUser);
        return userQueryRepository.save(userQuery);
    }
}