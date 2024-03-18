package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_2tdspf_produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_produto")
    @SequenceGenerator(
            name = "sq_produto",
            sequenceName = "sq_produto",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "id_produto")
    private Long id;
    @Column(name = "etq")
    private String etiqueta;
    @Column(name = "nm_produto")
    private String nome;
    @Column(name = "peso")
    private float peso;
    @Column(name = "largura")
    private float largura;
    @Column(name = "altura")
    private float altura;
    @Column(name = "profundidade")
    private float profundidade;
}
