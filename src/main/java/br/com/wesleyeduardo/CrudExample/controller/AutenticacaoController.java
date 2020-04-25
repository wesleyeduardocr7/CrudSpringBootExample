package br.com.wesleyeduardo.CrudExample.controller;

import br.com.wesleyeduardo.CrudExample.config.validacao.security.TokenService;
import br.com.wesleyeduardo.CrudExample.dto.TokenDto;
import br.com.wesleyeduardo.CrudExample.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {


        @Autowired
        private AuthenticationManager authManager;

        @Autowired
        private TokenService tokenService;

        @PostMapping
        public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){

            UsernamePasswordAuthenticationToken dadosLogin = form.converter();

            try {

                Authentication authentication =  authManager.authenticate(dadosLogin);

                String token = tokenService.gerarToken(authentication);

                return  ResponseEntity.ok(new TokenDto(token,"Bearer"));

            }catch (AuthenticationException e){
                    return  ResponseEntity.badRequest().build();
            }


        }

}
