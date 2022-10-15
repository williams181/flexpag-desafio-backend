package com.flexpag.paymentscheduler.auth.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.flexpag.paymentscheduler.usuario.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
    
    @Value("864000000")
    private String expiration;


    @Value("rm'!@N=Ke!~p8VTA2ZRK~nMDQX5Uvm!m'D&]{@Vr?G;2?XhbC:Qa#9#eMLN\\}x3?JR3.2zr~v)gYF^8\\:8>:XfB:Ww75N/emt9Yj[bQMNCWwW\\J?N,nvH.<2\\.r~w]*e~vgak)X\"v8H`MH/7\"2E`,^k@n<vE-wD3g9JWPy;CrY*.Kd2_D])=><D?YhBaSua5hW%{2]_FVXzb9`8FH^b[X3jzVER&:jw2<=c38=>L/zBq`}C6tT*cCSVC^c]-L}&/")
    private String secret;

    public String gerarToken(Authentication authentication) {
        
        var logado = (Usuario) authentication.getPrincipal();
        
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
            .setIssuer("Usuário do sistema flexpag")
            .setSubject(logado.getIdUsuario().toString())
            .setIssuedAt(new Date())
            .setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }

    public String gerarTokenOauth(Usuario usuarioOauth) {
        ;
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Usuário do sistema flexpag")
                .setSubject(usuarioOauth.getIdUsuario().toString())
                .setIssuedAt(new Date())
                .setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        var claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }


}
