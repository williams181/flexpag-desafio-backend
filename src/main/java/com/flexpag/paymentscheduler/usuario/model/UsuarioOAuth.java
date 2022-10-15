package com.flexpag.paymentscheduler.usuario.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.flexpag.paymentscheduler.usuario.model.UsuarioOAuth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioOAuth {

    @JsonProperty("email")
    private String email;
    
}
