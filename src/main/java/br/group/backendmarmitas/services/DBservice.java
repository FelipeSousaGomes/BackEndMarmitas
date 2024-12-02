
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

    @Autowired
    private EnderecoRepository enderecoRepository;

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
        User user2 = new User(null, "João Silva", "999.888.777-66", "joao@email.com", "(62) 999123456", "password", UserRole.user);

        userRepository.saveAll(Arrays.asList(user1, user2));

        // Seeding de Produtos
        Produto produto1 = new Produto(null, "Marmita de Frango", "Arroz, feijão, frango e salada", "https://crsupermercados.com.br/cdn/shop/files/marmita-frango_700x.png?v=1709309213", 12.50, 4,null);
        Produto produto2 = new Produto(null, "Marmita de Carne", "Frango grelhado, batata doce e brócolis", "https://crsupermercados.com.br/cdn/shop/files/marmita-carne_700x.png?v=1709309247", 15.00, 5,null);
        Produto produto3 = new Produto(null, "Marmita de Picadinho", "Quinoa, legumes grelhados e tofu", "https://crsupermercados.com.br/cdn/shop/files/marmitex_picadinho_450g_700x.png?v=1710517941", 14.00, 4,null);
        Produto produto4 = new Produto(null, "Marmita de peixe", "Macarrão, nuggets e purê", "https://crsupermercados.com.br/cdn/shop/files/marmita-peixe_700x.png?v=1711972358", 10.00, 3,null);
        Produto produto5 = new Produto(null, "Marmita de Almôndegas", "Picanha, arroz à grega e farofa", "https://crsupermercados.com.br/cdn/shop/files/marmitex_almondega_450g_700x.png?v=1710518837", 20.00, 5,null);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));

        // Seeding de Endereços
        Endereco endereco1 = new Endereco(null, "Rua A", "Próximo ao supermercado", "12345-678", "Apto 101", 10, null, user1);
        Endereco endereco2 = new Endereco(null, "Rua B", "Perto da escola", "23456-789", "Bloco B", 5, null, user2);
        Endereco endereco3 = new Endereco(null, "Rua C", "Em frente à praça", "34567-890", "Casa 23", 12, null, user1);

        enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2, endereco3));
    }
}
