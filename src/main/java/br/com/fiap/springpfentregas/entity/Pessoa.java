package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_2tdspf_pessoa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_pessoa")
    @SequenceGenerator(
            name = "sq_pessoa",
            sequenceName = "sq_pessoa",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "id_pessoa")
    private Long id;
    @Column(name = "nm_pessoa")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "dt_nascimento")
    private LocalDate nascimento;

}
