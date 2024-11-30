package br.group.backendmarmitas.services;

import br.group.backendmarmitas.entities.*;
import br.group.backendmarmitas.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBservice {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void InstanciaDB() {
        // Seeding de Entregadores
        Entregador entregador1 = new Entregador(null, "Tiago Marques", "ABC-123", Disponibilidade.DISPONIVEL, 10);
        Entregador entregador2 = new Entregador(null, "Lucas Silva", "DEF-456", Disponibilidade.EM_ROTA, 15);
        Entregador entregador3 = new Entregador(null, "Mariana Costa", "GHI-789", Disponibilidade.INDISPONIVEL, 12);
        Entregador entregador4 = new Entregador(null, "Carlos Pereira", "JKL-101", Disponibilidade.DISPONIVEL, 8);
        Entregador entregador5 = new Entregador(null, "Ana Souza", "MNO-112", Disponibilidade.EM_ROTA, 7);

        entregadorRepository.saveAll(Arrays.asList(entregador1, entregador2, entregador3, entregador4, entregador5));

        // Seeding de Usuários
        User user1 = new User(null, "Felipe", "089.921.978-30", "felipe@email.com", "(62) 98162713", "12345678", UserRole.admin);
        userRepository.save(user1);

        // Seeding de Produtos
        Produto produto1 = new Produto(null, "Marmita Tradicional", "Arroz, feijão, bife e salada", "https://example.com/marmita1.jpg", 12.50, 4, null);
        Produto produto2 = new Produto(null, "Marmita Fitness", "Frango grelhado, batata doce e brócolis", "https://example.com/marmita2.jpg", 15.00, 5, null);
        Produto produto3 = new Produto(null, "Marmita Vegana", "Quinoa, legumes grelhados e tofu", "https://example.com/marmita3.jpg", 14.00, 4, null);
        Produto produto4 = new Produto(null, "Marmita Infantil", "Macarrão, nuggets e purê", "https://example.com/marmita4.jpg", 10.00, 3, null);
        Produto produto5 = new Produto(null, "Marmita Premium", "Picanha, arroz à grega e farofa", "https://example.com/marmita5.jpg", 20.00, 5, null);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
    }
}
