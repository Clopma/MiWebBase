package com.example.miwebbase.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = User.T_USUARIOS)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public static final String T_USUARIOS = "Usuarios";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public static final String C_USUARIO = "usuario";
    @Column(name = C_USUARIO, unique = true)
    private String username;

    public static final String C_CONTRASEÑA = "contraseña";
    @Column(name = C_CONTRASEÑA)
    private String hashedPassword;


    public static final String C_HABILITADO = "habilitado";
    @Column(name = C_HABILITADO)
    @Builder.Default
    private boolean enabled = true;


}
