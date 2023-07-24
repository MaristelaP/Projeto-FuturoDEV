package br.com.lagoinha.adotation.services;

import br.com.lagoinha.adotation.dtos.ProdutoDTO;
import br.com.lagoinha.adotation.dtos.ProdutoEditDTO;
import br.com.lagoinha.adotation.entities.Estoque;
import br.com.lagoinha.adotation.entities.Produto;
import br.com.lagoinha.adotation.repositories.EstoqueRepository;
import br.com.lagoinha.adotation.repositories.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueService estoqueService;


    public List<Produto> mostrarTodos() {
        return produtoRepository.findAll();
    }


    public Produto salvar(ProdutoDTO produtoDto) throws Exception {
        Produto produto = new Produto();
        produto.setId(null);

        if(produto.getEstoque() != null){
            try {
                Estoque estoqueSelecionado = produto.getEstoque();
                produto.setEstoque(estoqueSelecionado);
            } catch (Exception e) {
                return null;
            }
        }
        Estoque estoque = estoqueService.buscarPorId(produtoDto.getEstoque());
        produto.setEstoque(estoque);
        // A ideia era não dar a opção para o cadastro de produtos de um animal que não fosse o animal do Estoque.
        // Por falta de tempo para resolver problemas de Experiência do usuário, retiramos do código a linha abaixo:
        // produto.setAnimal(estoque.getAnimal()); e demos liberdade ao usuário para cadastrar produto de
        // qualquer animal em qualquer estoque.
        produto.setAnimal(produtoDto.getAnimal());
        produto.setProduto(produtoDto.getProduto());
        produto.setCategoria(produtoDto.getCategoria());
        produto.setQuantidade(produtoDto.getQuantidade());

        return this.produtoRepository.save(produto);
    }

    public Produto atualizar(ProdutoEditDTO produtoEditDto){
        Produto produtoPesquisado = buscarPorId(produtoEditDto.getId());

        // as variáveis não modificadas pelo usuário serão permanecidas como estão:

        produtoPesquisado.setProduto(produtoEditDto.getProduto());
        produtoPesquisado.setQuantidade(produtoEditDto.getQuantidade());

        return this.produtoRepository.save(produtoPesquisado);

    }


    public Produto buscarPorId(Long id) {
        Optional<Produto> produtoPesquisado = this.produtoRepository.findById(id);
        if(produtoPesquisado.isPresent()){
        return produtoPesquisado.get();
        }
        return null;
    }

    public Produto buscarPorEstoque(Long idEstoque) {
        Optional<Produto> produtoPesquisado = this.produtoRepository.findById(idEstoque);
        if(produtoPesquisado.isPresent()){
            return produtoPesquisado.get();
        }
        return null;
    }

    public boolean removerPorId(Long id) {
        try{
            Produto produtoPesquisado = buscarPorId(id);
            if(produtoPesquisado == null) {
                return false;
            }
            this.produtoRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }



}
