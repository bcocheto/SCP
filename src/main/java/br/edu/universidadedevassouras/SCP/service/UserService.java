package br.edu.universidadedevassouras.SCP.service;

import br.edu.universidadedevassouras.SCP.Model.Pessoa;
import br.edu.universidadedevassouras.SCP.Repository.PessoaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PessoaDAO pessoaDAO;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Pessoa pessoaUser = pessoaDAO.findByUsername(userName);
        if (pessoaUser == null){
            throw new UsernameNotFoundException("Username not found:" + userName);
        }
        return new User(pessoaUser.getUsername(),pessoaUser.getSenha(), new ArrayList<>());
    }
}
