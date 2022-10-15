package com.flexpag.paymentscheduler.usuario.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

import com.flexpag.paymentscheduler.pessoa.model.Pessoa;
import com.flexpag.paymentscheduler.usuario.model.Perfil;
import com.flexpag.paymentscheduler.usuario.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario implements UserDetails {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idUsuario;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PESSOA_ID", referencedColumnName = "ID")
    private Pessoa pessoa;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Perfil> perfils = new ArrayList<>();

    @Override
    public String getPassword() {
        
        return this.senha;
    }

    @Override
    public String getUsername() {
        
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @Override
    public boolean isEnabled() {
        
        return true;
    }

    @Override
    public List<Perfil> getAuthorities() {
        return this.perfils;
    }
}

