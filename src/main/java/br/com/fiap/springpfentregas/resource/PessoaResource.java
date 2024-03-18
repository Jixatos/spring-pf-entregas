package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {
    @Autowired
    private PessoaRepository pessoaRepo;

    @GetMapping
    public List<Pessoa> getAll() {
        return pessoaRepo.findAll();
    }

    @Transactional
    @PostMapping
    public Pessoa post(@RequestBody Pessoa pessoa) {
        return pessoaRepo.save(pessoa);
    }

    @GetMapping(value = "/{id}")
    public Pessoa getById(@PathVariable Long id) {
        return pessoaRepo.findById(id).orElseThrow();
    }
}
