package com.example.miwebbase.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = User.T_USUARIOS)
@Entity
@Data
@NoArgsConstructor
public class User {

    public static final String T_USUARIOS = "Usuarios";

    public User(String username, String hashedPassword) {
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static final String C_USUARIO = "usuario";
    @Column(name = C_USUARIO, unique = true)
    private String username;

    public static final String C_CONTRASEÑA = "contraseña";
    @Column(name = C_CONTRASEÑA, length = 255)
    private String hashedPassword;

    public static final String C_HABILITADO = "habilitado";
    @Column(name = C_HABILITADO)
    private boolean enabled = true;


}
