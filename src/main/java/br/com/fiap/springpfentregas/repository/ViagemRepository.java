package br.com.fiap.springpfentregas.repository;

import br.com.fiap.springpfentregas.entity.Viagem;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
}
