package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Endereco;
import br.com.fiap.springpfentregas.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {
    @Autowired
    private EnderecoRepository enderecoRepo;

    @GetMapping
    public List<Endereco> getAll(){
        return enderecoRepo.findAll();
    }

    @Transactional
    @PostMapping
    public Endereco post(@RequestBody Endereco endereco) {
        return enderecoRepo.save(endereco);
    }

}
