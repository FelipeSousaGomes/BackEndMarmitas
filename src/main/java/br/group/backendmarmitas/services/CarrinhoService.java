package br.group.backendmarmitas.services;

import br.group.backendmarmitas.entities.Carrinho;
import br.group.backendmarmitas.entities.CarrinhoEnum;
import br.group.backendmarmitas.entities.ItemCarrinho;
import br.group.backendmarmitas.entities.Produto;
import br.group.backendmarmitas.entities.dto.*;
import br.group.backendmarmitas.repositories.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ItemCarrinhoService itemCarrinhoService;



    public Carrinho salvar(SalvarCarrinhoDto carrinho) {
        boolean verificar = verSeUsuarioPossuiCarrinhoPendente(carrinho);
        System.out.println(verificar);
        Carrinho carrinhoSalva = new Carrinho();
        if (verificar) {
            carrinhoSalva = findByUsuarioId(carrinho.getId_usuario());
            List<ItemCarrinho> listaDeItensDoCarrinho = itemCarrinhoService.findByIdCarrinho(carrinhoSalva.getId());

            boolean produtoExistente = false;

            for (ItemCarrinho item : listaDeItensDoCarrinho) {
                if (item.getProduto().getId().equals(carrinho.getId_produto())) {
                    // Produto já existe no carrinho, atualiza a quantidade
                    item.setQuantidade(item.getQuantidade() + 1);
                    itemCarrinhoService.salvar(item);
                    produtoExistente = true;
                    break; // Produto encontrado, não precisa continuar o loop
                }
            }

            if (!produtoExistente) {
                // Produto não existe no carrinho, cria um novo item
                ItemCarrinho itemCarrinho = new ItemCarrinho();
                itemCarrinho.setCarrinho(carrinhoSalva);
                itemCarrinho.setProduto(produtoService.findCompleteProductFromId(carrinho.getId_produto()));
                itemCarrinho.setAtivo(true);
                itemCarrinho.setQuantidade(1);
                itemCarrinhoService.salvar(itemCarrinho);
            }
        }


        else {

            carrinhoSalva.setUsuario(userService.findCompletUserById(carrinho.getId_usuario()));
            carrinhoSalva.setStatus(CarrinhoEnum.PENDENTE);

            Carrinho carrinhoAdicionado = carrinhoRepository.save(carrinhoSalva);
            ItemCarrinho itemCarrinho = new ItemCarrinho();
            itemCarrinho.setCarrinho(carrinhoAdicionado);
            itemCarrinho.setProduto(produtoService.findCompleteProductFromId(carrinho.getId_produto()));
            itemCarrinho.setAtivo(true);
            itemCarrinho.setQuantidade(1);
            itemCarrinhoService.salvar(itemCarrinho);
        }
        return carrinhoSalva;
    }

    public CarrinhoEItemsDto pegarCarrinhoEItensPorUsuario(Long idUsuario) {
        List<ProdutoCarrinhoDto> produtos = new ArrayList<>();
        CarrinhoEItemsDto carrinhoEItemsDto = new CarrinhoEItemsDto();
        Carrinho carrinho = carrinhoRepository.findCarrinhoByUsuarioId(idUsuario);
        CarrinhoDto carrinhoDto = new CarrinhoDto();
        carrinhoDto.setId(carrinho.getId());
        carrinhoDto.setStatus(carrinho.getStatus());
        UserDTO usuarioDto = new UserDTO(carrinho.getUsuario());

        carrinhoDto.setUsuario(usuarioDto);
        carrinhoEItemsDto.setCarrinho(carrinhoDto);

        List<ItemCarrinho> listaItensCarrinho = itemCarrinhoService.findByIdCarrinho(carrinho.getId());
        for(ItemCarrinho item : listaItensCarrinho) {
            ProdutoCarrinhoDto novoProduto = new ProdutoCarrinhoDto();
            novoProduto.setProduto(produtoService.findCompleteProductFromId(item.getProduto().getId()));
            novoProduto.setQuantidade(item.getQuantidade());
            produtos.add(novoProduto);
        }

        carrinhoEItemsDto.setProdutos(produtos);
        return carrinhoEItemsDto;
    }
    public Carrinho findByUsuarioId(Long id) {
        return carrinhoRepository.findCarrinhoByUsuarioId(id);
    }
    private boolean verSeUsuarioPossuiCarrinhoPendente(SalvarCarrinhoDto carrinho){
        Carrinho carrinhoUsuario = carrinhoRepository.findCarrinhoByUsuarioId(carrinho.getId_usuario());
        System.out.println("aquiiii");
        System.out.println(carrinhoUsuario);
        if(carrinhoUsuario == null){
            return false;
        }
        else{
            if(carrinhoUsuario.getStatus() == CarrinhoEnum.PENDENTE){
                return true;
            }
            return false;

        }
    }
}
