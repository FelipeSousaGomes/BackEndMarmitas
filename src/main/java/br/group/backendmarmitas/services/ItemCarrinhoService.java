package br.group.backendmarmitas.services;

import br.group.backendmarmitas.entities.ItemCarrinho;
import br.group.backendmarmitas.repositories.ItemCarrinhoRepository;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    public ItemCarrinho salvar(ItemCarrinho itemCarrinho) {
        return itemCarrinhoRepository.save(itemCarrinho);
    }

    public ItemCarrinho findById(Long id) {
        return itemCarrinhoRepository.findById(id).orElse(null);
    }
    public List<ItemCarrinho> findByIdCarrinho(Long id){
        return itemCarrinhoRepository.findItemCarrinhoByCarrinhoId(id);
    }
}
