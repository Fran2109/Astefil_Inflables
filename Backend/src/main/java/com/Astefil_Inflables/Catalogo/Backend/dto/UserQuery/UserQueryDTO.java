package com.Astefil_Inflables.Catalogo.Backend.dto.UserQuery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

public class UserQueryDTO {
    @NotNull(message = "First name is required")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotNull(message = "Last name is required")
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @NotNull(message = "Zone ID is required")
    private Long zoneId;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "General query is required")
    @NotBlank(message = "General query cannot be blank")
    private String generalQuery;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format")
    private String phone;

    public UserQueryDTO() {
    }
    public UserQueryDTO(String firstName, String lastName, Long zoneId, LocalDate date, String generalQuery, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zoneId = zoneId;
        this.date = date;
        this.generalQuery = generalQuery;
        this.phone = phone;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Long getZoneId() {
        return zoneId;
    }
    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getGeneralQuery() {
        return generalQuery;
    }
    public void setGeneralQuery(String generalQuery) {
        this.generalQuery = generalQuery;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}