package br.com.ada.filmesgratis.controller;

import br.com.ada.filmesgratis.dao.FilmeDAO;
import br.com.ada.filmesgratis.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;*/

import java.util.List;

@Controller
@RequestMapping("/filme")
public class FilmeController {
    @Autowired
    private FilmeDAO filmeDAO;

    @GetMapping
    public String listar(Model model) {
        List<Filme> lista  = filmeDAO.buscarTodos();
        model.addAttribute("filmes", lista);
        return "filme_listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Filme filme = filmeDAO.buscarPorId(id);
        model.addAttribute("filme", filme);
        return "filme_editar";
    }
    @PostMapping("/editar")
    public String atualizar(Filme filme) {
        filmeDAO.atualizar(filme);
        return "redirect:/filme";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable int id) {
        filmeDAO.deletar(id);
        return "redirect:/filme";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("filme", new Filme());
        return "filme_novo";
    }

    @PostMapping("/novo")
    public String adicionar(Filme filme) {
        filmeDAO.adicionar(filme);
        return "redirect:/filme";
    }

    @PostMapping("/assistir/{id}")
    public String assistir(@PathVariable int id, Model model) {
        Filme f = filmeDAO.buscarPorId(id);
        model.addAttribute("filme", f);
        return "assistir_filme";
    }





}
