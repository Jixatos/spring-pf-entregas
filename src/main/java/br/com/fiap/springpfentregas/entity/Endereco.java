package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_2tdspf_endereco")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_endereco")
    @SequenceGenerator(
            name = "sq_endereco",
            sequenceName = "sq_endereco",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "id_endereco")
    private Long id;
    @Column(name = "cep")
    private String cep;
    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "Pessoa",
            referencedColumnName = "id_pessoa",
            foreignKey = @ForeignKey(name = "fK_pessoa_endereco")
    )
    private Pessoa pessoa;
}
