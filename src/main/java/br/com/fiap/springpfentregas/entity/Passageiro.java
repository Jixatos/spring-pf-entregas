package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_2tdspf_passageiro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_passageiro")
    @SequenceGenerator(
            name = "sq_passageiro",
            sequenceName = "sq_passageiro",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "id_passageiro")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "Pessoa",
            referencedColumnName = "id_pessoa",
            foreignKey = @ForeignKey(name = "fK_pessoa_passageiro")
    )
    private Pessoa pessoa;
}
