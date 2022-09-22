package br.edu.universidadedevassouras.SCP.Controller;

import br.edu.universidadedevassouras.SCP.Repository.PessoaDAO;
import br.edu.universidadedevassouras.SCP.Model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController {

    @Autowired
    private PasswordEncoder bCryptEncoder;

    @Autowired
    private PessoaDAO pessoaDAO;
    private Pessoa pessoa;

    @GetMapping
    public Iterable<Pessoa> getAll(){

        return pessoaDAO.findAll();
    }
    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<Pessoa> getPessoa(@PathVariable("id")Long id){
            return pessoaDAO.findById(id);
    }
    @PostMapping
    public Pessoa postPessoa(@RequestBody Pessoa p){
        p.setSenha(bCryptEncoder.encode(p.getSenha()));
        return pessoaDAO.save(p);
    }
    @DeleteMapping
    public void Delete(){
        pessoaDAO.deleteAll();
    }

    @PutMapping
    public Pessoa putPessoa(@RequestBody Pessoa p){
        return pessoaDAO.save(p);
    }
}
