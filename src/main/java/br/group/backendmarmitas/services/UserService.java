package br.group.backendmarmitas.services;

import br.group.backendmarmitas.entities.Produto;
import br.group.backendmarmitas.entities.User;
import br.group.backendmarmitas.entities.dto.ProdutoDTO;
import br.group.backendmarmitas.entities.dto.UserDTO;
import br.group.backendmarmitas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).get();
        return new UserDTO(user);
    }

    public User findCompletUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }



    public List<UserDTO> findAll() {
        List<User> result = userRepository.findAll();
        return result.stream().map(x -> new UserDTO(x)).toList();
    }
}
