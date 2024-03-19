package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Passageiro;
import br.com.fiap.springpfentregas.repository.PassageiroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/passageiro")
public class PassageiroResource {

    @Autowired
    private PassageiroRepository passageiroRepo;

    @GetMapping
    public List<Passageiro> findAll() {
        return passageiroRepo.findAll();
    }

    @Transactional
    @PostMapping
    public Passageiro save(@RequestBody Passageiro passageiro) {
        return passageiroRepo.save(passageiro);
    }
}
