package br.com.fiap.springpfentregas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringPfEntregasApplication {

    public static void main(String[] args) {
        SpringApplication.run( SpringPfEntregasApplication.class, args );
    }

    @GetMapping(value = "/")
    public String index(){
        return "Site";
    }
}
