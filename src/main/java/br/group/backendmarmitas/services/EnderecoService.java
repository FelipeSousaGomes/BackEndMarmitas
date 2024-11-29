package br.group.backendmarmitas.services;

import br.group.backendmarmitas.entities.Endereco;
import br.group.backendmarmitas.entities.Produto;
import br.group.backendmarmitas.entities.User;
import br.group.backendmarmitas.entities.dto.EnderecoDTO;
import br.group.backendmarmitas.entities.dto.ProdutoDTO;
import br.group.backendmarmitas.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {


    @Autowired
    EnderecoRepository enderecoRepository;

    public EnderecoDTO Insert (EnderecoDTO dto) {
        Endereco endereco = new Endereco();

        // Setando os valores do DTO na entidade
        endereco.setCep(dto.getCep());
        endereco.setDescricao(dto.getDescricao());
        endereco.setComplemento(dto.getComplemento());
        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());

        // Apenas atribuindo o ID do usuário (não o objeto User completo)
        User user = new User();
        user.setId(dto.getUserId()); // Assumindo que você já tenha um método para configurar o User com base no ID
        endereco.setUser(user); // Associando o ID do usuário no Endereco

        // Salvando no banco (se necessário)
        endereco = enderecoRepository.save(endereco);

        // Retornando o DTO com apenas o ID do usuário
        return new EnderecoDTO(endereco); // Isso agora incluirá apenas o ID do usuário no DTO
    }

    public EnderecoDTO findById(Long id) {
        return new EnderecoDTO(enderecoRepository.findById(id).get());
    }


    public List<EnderecoDTO> findAll() {
        List<Endereco> result = enderecoRepository.findAll();
        return result.stream().map(x -> new EnderecoDTO(x)).toList();
    }

    public EnderecoDTO Update(Long id, EnderecoDTO dto) {
        Endereco endereco = enderecoRepository.getReferenceById(id);
        endereco.setCep(dto.getCep());
        endereco.setDescricao(dto.getDescricao());
        endereco.setComplemento(dto.getComplemento());
        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());
        User user = new User();
        user.setId(dto.getUserId());
        endereco.setUser(user);
        endereco = enderecoRepository.save(endereco);
        return new EnderecoDTO(endereco);
    }

    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }
}


