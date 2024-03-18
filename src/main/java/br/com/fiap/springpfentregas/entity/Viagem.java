package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
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
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
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
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
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
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "tbl_2tdspf_cliente",
            joinColumns = {
                    @JoinColumn(
                            name = "Viagem",
                            referencedColumnName = "id_viagem",
                            foreignKey = @ForeignKey(name = "fk_cliente_viagem")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "Pessoa",
                            referencedColumnName = "id_pessoa",
                            foreignKey = @ForeignKey(name = "fk_viagem_cliente")
                    )
            }
    )
    private Pessoa pessoa;

    //Relacionamen com Endereco : origem
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "tbl_2tdspf_origem",
            joinColumns = {
                    @JoinColumn(
                            name = "Viagem",
                            referencedColumnName = "id_viagem",
                            foreignKey = @ForeignKey(name = "fk_origem_viagem")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "Endereco",
                            referencedColumnName = "id_endereco",
                            foreignKey = @ForeignKey(name = "fk_viagem_origem")
                    )
            }
    )
    private Endereco origem;

    //Relacionamen com Endereco : destino
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "tbl_2tdspf_destino",
            joinColumns = {
                    @JoinColumn(
                            name = "Viagem",
                            referencedColumnName = "id_viagem",
                            foreignKey = @ForeignKey(name = "fk_destino_viagem")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "Endereco",
                            referencedColumnName = "id_endereco",
                            foreignKey = @ForeignKey(name = "fk_viagem_destino")
                    )
            }
    )
    private Endereco destino;
}
