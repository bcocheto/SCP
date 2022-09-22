package br.edu.universidadedevassouras.SCP.Model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Data
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpessoa;

    @Column(nullable = false, unique = true)
    private String CPF;

    @Column(nullable = false)
    private String Nome;

    @Column(nullable = false, unique = true)
    private int Matricula;

    @Column(nullable = true)
    private Date Nascimento;

    @Column(nullable = true)
    private char Genero;

    @Column(nullable = true)
    private String Foto;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String Senha;
}
