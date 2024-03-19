package br.com.fiap.springpfentregas.repository;

import br.com.fiap.springpfentregas.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findByCep(String cep);
    List<Endereco> findByPessoaId(Long id);
}
