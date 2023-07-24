package br.com.lagoinha.adotation.services;

import br.com.lagoinha.adotation.entities.Estoque;
import br.com.lagoinha.adotation.repositories.EstoqueRepository;
import br.com.lagoinha.adotation.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    //listar
    public List<Estoque> listar(){
        return estoqueRepository.findAll();
    }

    //cadastro
    public Estoque cadastrar(Estoque estoque) throws Exception{
        if (estoque.getNome() == null || estoque.getNome().isEmpty()){
            throw new Exception("Nome é obrigatório!");
        }
        if (estoque.getAnimal() == null || estoque.getAnimal().isEmpty()){
            throw new Exception("Animal para estoque é obrigatório!");
        }
        if (estoque.getSituacao() == null){
            estoque.setSituacao(true);
        }
            return  estoqueRepository.save(estoque);
    }

    //listar por id
    public Estoque buscarPorId(Long id){
        Optional<Estoque> estoquePesquisado = estoqueRepository.findById(id);
        if (estoquePesquisado.isPresent()){
            return estoquePesquisado.get();
        }else {
            return null;
        }
    }


    //editar
    public Estoque editar(Estoque estoqueAtualizado){
        Estoque estoquePesquisado = buscarPorId(estoqueAtualizado.getId());
        if (estoquePesquisado != null){
            estoquePesquisado.setNome(estoqueAtualizado.getNome());
            estoquePesquisado.setAnimal(estoqueAtualizado.getAnimal());
            return this.estoqueRepository.save(estoquePesquisado);
        }
        return null;
    }

    //deletar
    public boolean deletarPorId(Long id) throws Exception{

        Estoque estoquePesquisado = buscarPorId(id);

        if(produtoRepository.existsByEstoque(id)){
            throw new Exception("Estoque possui produto");
        }
        if (estoquePesquisado == null){
            throw new Exception("Id do estoque é obrigatório");
        }
        this.estoqueRepository.deleteById(id);
        return true;
    }


}
