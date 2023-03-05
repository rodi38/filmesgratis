package br.com.ada.filmesgratis.dao;

import br.com.ada.filmesgratis.model.Filme;
import br.com.ada.filmesgratis.model.Noticia;

import java.util.ArrayList;
import java.util.List;

public class NoticiaDAO {

    private static List<Noticia> noticias = new ArrayList<>();
    private static int proximoId = 1;

    public void adicionar(Noticia noticia){
        noticia.setId(proximoId++);
        noticias.add(noticia);
    }
    public void atualizar(Noticia noticia){
        for (int i = 0; i < noticias.size(); i++) {
            Noticia n = noticias.get(i);
            if (n.getId() == noticia.getId()){
                noticias.set(i, noticia);
                break;
            }
        }
    }

    public void deletar(int id){
        noticias.removeIf(n -> n.getId() == id);
    }

    public Noticia buscarPorId(int id){
        return noticias.stream().filter(n -> n.getId() == id).findFirst().get();
    }

    public List<Noticia> buscarTodos(){
        return noticias;
    }
}
