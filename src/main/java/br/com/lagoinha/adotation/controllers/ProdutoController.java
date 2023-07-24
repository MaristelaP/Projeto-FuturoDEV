package br.com.lagoinha.adotation.controllers;

import br.com.lagoinha.adotation.dtos.ProdutoDTO;
import br.com.lagoinha.adotation.dtos.ProdutoEditDTO;
import br.com.lagoinha.adotation.entities.Estoque;
import br.com.lagoinha.adotation.entities.Produto;
import br.com.lagoinha.adotation.services.EstoqueService;
import br.com.lagoinha.adotation.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id){
        return this.produtoService.buscarPorId(id);
    }

    @GetMapping("/{idEstoque}")
    public Produto buscarPorEstoque(@PathVariable Long idEstoque){
        return this.produtoService.buscarPorId(idEstoque);
    }

    @GetMapping
    public List<Produto> mostrarTodos(){
        return produtoService.mostrarTodos();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody ProdutoDTO produtoDto) {
        Produto produto = new Produto();
        Estoque estoque = estoqueService.buscarPorId(produtoDto.getEstoque());
        if(estoque == null) {
            return ResponseEntity.badRequest().body("Estoque não encontrado");
        }
        try{
            produto.setId(null);
            produto = produtoService.salvar(produtoDto);
            return ResponseEntity.ok(produto);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Só poderão ser editadas a quantidade e o tipo de produto:

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody ProdutoEditDTO produtoEditDTO) {
        produtoEditDTO.setId(id);
        try{
            return ResponseEntity.ok(produtoService.atualizar(produtoEditDTO));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            return ResponseEntity.ok(produtoService.removerPorId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
