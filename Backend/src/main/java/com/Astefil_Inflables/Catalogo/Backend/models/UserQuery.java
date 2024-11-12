package com.Astefil_Inflables.Catalogo.Backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_query")
public class UserQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_query")
    private Long id;

    @NotNull(message = "First name is required")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotNull(message = "Last name is required")
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Date is required")
    private LocalDateTime createdDateTime = LocalDateTime.now();

    private LocalDateTime answeredDateTime;

    @NotNull(message = "General query is required")
    @NotBlank(message = "General query cannot be blank")
    private String generalQuery;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format")
    private String phone;

    @Column(nullable = false)
    private boolean isAnswered = false;

    @ManyToOne
    @JoinColumn(name = "answered_by_user_id")
    private User answeredByUser;

    public UserQuery() {
    }
    public UserQuery(String firstName, String lastName, Zone zone, LocalDate date, String generalQuery, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zone = zone;
        this.date = date;
        this.generalQuery = generalQuery;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Zone getZone() {
        return zone;
    }
    public void setZone(Zone zone) {
        this.zone = zone;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }
    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
    public LocalDateTime getAnsweredDateTime() {
        return answeredDateTime;
    }
    public void setAnsweredDateTime(LocalDateTime answeredDateTime) {
        this.answeredDateTime = answeredDateTime;
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
    public boolean getIsAnswered() {
        return isAnswered;
    }
    public void setIsAnswered(boolean isAnswered) {
        this.isAnswered = isAnswered;
    }
    public User getAnsweredByUser() {
        return answeredByUser;
    }
    public void setAnsweredByUser(User answeredByUser) {
        this.answeredByUser = answeredByUser;
    }

}