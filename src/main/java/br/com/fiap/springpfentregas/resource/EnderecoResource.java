package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Endereco;
import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.EnderecoRepository;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {
    @Autowired
    private EnderecoRepository enderecoRepo;

    @Autowired
    private PessoaRepository pessoaRepo;

    @GetMapping
    public List<Endereco> findAll(){
        return enderecoRepo.findAll();
    }

    @Transactional
    @PostMapping
    public Endereco save(@RequestBody Endereco endereco, @RequestBody Pessoa pessoa) {
        return enderecoRepo.save(endereco);
    }

    @GetMapping(value = "/{cep}")
    public Endereco findByCep(@PathVariable String cep) {
        return enderecoRepo.findByCep(cep).orElseThrow();
    }

    @GetMapping("/pessoa/{idPessoa}")
    public List<Endereco> findByPessoaId(@PathVariable Long idPessoa) {
        return enderecoRepo.findByPessoaId(idPessoa);
    }
}
