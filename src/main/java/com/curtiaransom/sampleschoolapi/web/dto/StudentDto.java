package com.curtiaransom.sampleschoolapi.web.dto;

public record StudentDto (
    Long id,
    String firstName,
    String lastName) {

    public StudentDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
