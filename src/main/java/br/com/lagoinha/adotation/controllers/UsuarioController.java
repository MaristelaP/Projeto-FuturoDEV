package br.com.lagoinha.adotation.controllers;

import br.com.lagoinha.adotation.entities.Usuario;
import br.com.lagoinha.adotation.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity post(@RequestBody Usuario usuario) {
        try {

            return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuario));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping
    public List<Usuario> get() {
        return usuarioService.listarTodos();
    }
}
