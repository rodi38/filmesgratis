package br.com.ada.filmesgratis.dao;

import br.com.ada.filmesgratis.model.Filme;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class FilmeDAO {
    private List<Filme> filmes = new ArrayList<>();

    public void adicionar(Filme filme){
        filmes.add(filme);
    }
    public void atualizar(Filme filme){
        for (int i = 0; i <filmes.size(); i++) {
            Filme f = filmes.get(i);
            if (f.getId() == filme.getId()){
                filmes.set(i, filme);
                break;
            }
        }
    }

    public void deletar(int id){
        filmes.removeIf(f -> f.getId() == id);
    }

    public Filme buscarPorId(int id){
        return filmes.stream().filter(f -> f.getId() == id).findFirst().get();
    }

    public List<Filme> buscarTodos(){
        return filmes;
    }
}
