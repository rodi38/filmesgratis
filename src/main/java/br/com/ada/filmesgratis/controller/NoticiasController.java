package br.com.ada.filmesgratis.controller;

import br.com.ada.filmesgratis.dao.NoticiaDAO;
import br.com.ada.filmesgratis.model.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/noticia")
public class NoticiasController {

    @Autowired
    private NoticiaDAO noticiaDAO;

    @GetMapping
    public String listar(Model model) {
        List<Noticia> lista  = noticiaDAO.buscarTodos();
        model.addAttribute("noticias", lista);
        return "noticia_listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Noticia noticia = noticiaDAO.buscarPorId(id);
        model.addAttribute("noticia", noticia);
        return "noticia_editar";
    }
    @PostMapping("/editar")
    public String atualizar(Noticia noticia) {
        noticiaDAO.atualizar(noticia);
        return "redirect:/noticia";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable int id) {
        noticiaDAO.deletar(id);
        return "redirect:/noticia";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("noticia", new Noticia());
        return "noticia_novo";
    }

    @PostMapping("/novo")
    public String adicionar(Noticia noticia) {
        noticiaDAO.adicionar(noticia);
        return "redirect:/noticia";
    }

    @PostMapping("/ler/{id}")
    public String assistir(@PathVariable int id, Model model) {
        Noticia n = noticiaDAO.buscarPorId(id);
        model.addAttribute("noticia", n);
        return "ler_noticias";
    }


}
