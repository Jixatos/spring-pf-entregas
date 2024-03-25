package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_2tdspf_viagem")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_viagem")
    @SequenceGenerator(
            name = "sq_viagem",
            sequenceName = "sq_viagem",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "id_viagem")
    private Long id;
    @Column(name = "saida")
    private LocalDateTime saida;
    @Column(name = "chegada")
    private LocalDateTime chegada;

    //Relacionamento com Produto
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "tbl_2tdspf_produtos",
            joinColumns = {
                    @JoinColumn(
                            name = "Viagem",
                            referencedColumnName = "id_viagem",
                            foreignKey = @ForeignKey(name = "fk_produtos_viagem")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "Produto",
                            referencedColumnName = "id_produto",
                            foreignKey = @ForeignKey(name = "fk_viagem_produtos")
                    )
            }
    )
    private Set<Produto> produtos = new LinkedHashSet<>();

    //Relacionamento com Passageiros
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "tbl_2tdspf_passageiros",
            joinColumns = {
                    @JoinColumn(
                            name = "Viagem",
                            referencedColumnName = "id_viagem",
                            foreignKey = @ForeignKey(name = "fk_passageiros_viagem")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "Passageiro",
                            referencedColumnName = "id_passageiro",
                            foreignKey = @ForeignKey(name = "fk_viagem_passageiros")
                    )
            }
    )
    private Set<Passageiro> passsageiros = new LinkedHashSet<>();

    //Relacionamento com Pessoa
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "Cliente",
            referencedColumnName = "id_pessoa",
            foreignKey = @ForeignKey(name = "fk_cliente_viagem")
    )
    private Pessoa cliente;

    //Relacionamento com Endereco : origem
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "Endereco",
            referencedColumnName = "id_endereco",
            foreignKey = @ForeignKey(name = "fK_endereco_viagem_origem")
    )
    private Endereco origem;

    //Relacionamento com Endereco : destinos
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "Destino",
            referencedColumnName = "id_endereco",
            foreignKey = @ForeignKey(name = "fk_destino_viagem")
    )
    private Endereco destino;
}
