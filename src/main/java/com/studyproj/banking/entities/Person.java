package com.studyproj.banking.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;


@Schema(name = "Person",description = "Person Model")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    @Schema(description = "Person ID generated automatically", example = "1")
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Person name", example = "Jão")
    @NonNull
    private String name;

    @Schema(description = "Person CPF", example = "123.456.789-00")
    @NonNull
    private String cpf;

    @Schema(description = "Person birth date", pattern = "dd-MM-yyyy")
    @NonNull
    private LocalDate birthDate;

    @OneToOne
    @JoinColumn(name = "idAccount", referencedColumnName = "id")
    @JsonManagedReference
    private Account account;
}
