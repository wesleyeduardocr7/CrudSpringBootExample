package br.com.wesleyeduardo.CrudExample.config.validacao.security;

import br.com.wesleyeduardo.CrudExample.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${wesley.jwt.expiration}")
    private String expiration;

    @Value("${wesley.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {

        Usuario logado = (Usuario) authentication.getPrincipal();

        Date hoje = new Date();

        Date dataExpiracao = new Date(hoje.getTime()+ Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Wesley Eduardo")
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();

    }
}
