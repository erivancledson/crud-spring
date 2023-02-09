package com.example.crudspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Entity
@SQLDelete(sql = "UPDATE Course SET status = 'Inativo' WHERE id = ?") //quando for chamado o delete o sql vai ser chamado é este
@Where(clause = "status = 'Ativo'") //status é do atributo da classe. Só vai listar quem for Ativo
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 100, nullable = false)
    @NotNull //não deixa ser nul e não deixa ser vazio
    @NotBlank
    @Min(5) @Max(100)
    private String name;

    @Column(length = 100, nullable = false)
    @Max(100)
    @NotNull
    @Pattern(regexp = "Back-end | Front-end") //só pode ser um desses dois valores
    private String category;

    @Column(length = 100, nullable = false)
    @Max(100)
    @NotNull
    @Pattern(regexp = "Ativo | Inativo") //só pode ser um desses dois valores
    private String status = "Ativo";
}
