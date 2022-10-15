package com.flexpag.paymentscheduler.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flexpag.paymentscheduler.usuario.model.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}