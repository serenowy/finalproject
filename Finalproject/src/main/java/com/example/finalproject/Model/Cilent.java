package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Cilent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id//P key
    private Integer id ;
    @NotEmpty(message= " name can not empty")
    @Size(min = 5, message="Length more than 5")

    private String name;
    @NotEmpty(message= "  username can not empty")
    @Length(min = 3, message=" user Length more than 3")
    @Column(columnDefinition = "varchar(20)   unique")

    private String username;
    @NotNull(message= "  password can not null")

    private Integer password;
}
