package com.example.miwebbase.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = User.T_USUARIOS)
@Entity
public class User {

    public static final String T_USUARIOS = "Usuarios";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static final String C_USUARIO = "usuario";
    @Column(name = C_USUARIO)
    private String username;

    public static final String C_CONTRASEÑA = "contraseña";
    @Column(name = C_CONTRASEÑA, length = 255)
    private String RSApassword;

}
