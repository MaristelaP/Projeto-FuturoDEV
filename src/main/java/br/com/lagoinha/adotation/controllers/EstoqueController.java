package br.com.lagoinha.adotation.controllers;

import br.com.lagoinha.adotation.entities.Estoque;
import br.com.lagoinha.adotation.repositories.ProdutoRepository;
import br.com.lagoinha.adotation.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private ProdutoRepository produtoRepository;

    //lista de estoque
    @GetMapping
    public List<Estoque> get(){
        return estoqueService.listar();
    }

    //cadastrar
    @PostMapping
    public ResponseEntity post(@RequestBody Estoque estoque){
        try {
            estoque.setId(null);
            return ResponseEntity.ok(estoqueService.cadastrar(estoque));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Estoque getId(@PathVariable Long id){
        return estoqueService.buscarPorId(id);
    }

    //editar
    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable Long id, @RequestBody Estoque estoque){
        estoque.setId(id);
        try{
            return ResponseEntity.ok(estoqueService.editar(estoque));
        }catch (Exception e ){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    //deletar
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            return ResponseEntity.ok(estoqueService.deletarPorId(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }
}
