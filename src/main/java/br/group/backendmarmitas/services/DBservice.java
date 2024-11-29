package br.group.backendmarmitas.services;

import br.group.backendmarmitas.entities.Disponibilidade;
import br.group.backendmarmitas.entities.Entregador;
import br.group.backendmarmitas.entities.User;
import br.group.backendmarmitas.entities.UserRole;
import br.group.backendmarmitas.repositories.EntregadorRepository;
import br.group.backendmarmitas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBservice {
    @Autowired
    EntregadorRepository entregadorRepository;
    @Autowired
    private UserRepository userRepository;

    public void InstanciaDB(){
        Entregador entregador1 = new Entregador(null, "Tiago Marques", "ABC-123", Disponibilidade.DISPONIVEL, 10);
        entregadorRepository.save(entregador1);

        Entregador entregador2 = new Entregador(null, "Lucas Silva", "DEF-456", Disponibilidade.EM_ROTA, 15);
        entregadorRepository.save(entregador2);

        Entregador entregador3 = new Entregador(null, "Mariana Costa", "GHI-789", Disponibilidade.INDISPONIVEL, 12);
        entregadorRepository.save(entregador3);

        Entregador entregador4 = new Entregador(null, "Carlos Pereira", "JKL-101", Disponibilidade.DISPONIVEL, 8);
        entregadorRepository.save(entregador4);

        Entregador entregador5 = new Entregador(null, "Ana Souza", "MNO-112", Disponibilidade.EM_ROTA, 7);
        entregadorRepository.save(entregador5);

        User user1 = new User(null,"Felipe","089.921.978-30","felipe@email.com","(62) 98162713","12345678", UserRole.USER);

                userRepository.save(user1);
    }
}
