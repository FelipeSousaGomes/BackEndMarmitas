package br.group.backendmarmitas.infra.Security;

import br.group.backendmarmitas.entities.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTCreator.Builder builder = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(genExpirationDate());

            // Adiciona os dados do usuário como claims
            builder.withClaim("nome", user.getNome());
            builder.withClaim("cpf", user.getCPF());
            builder.withClaim("telefone", user.getTelefone());
            builder.withClaim("role", user.getRole().toString());


            String token = builder.sign(algorithm); // Assina o token após adicionar as claims
            return token;

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro de geração de token", exception);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();

    }catch (JWTVerificationException exception){
            return "";
        }
    }

        private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
        }
}
