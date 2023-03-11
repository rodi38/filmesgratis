package br.com.ada.filmesgratis.dao;

import br.com.ada.filmesgratis.model.Ator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AtorDAO {
    private static List<Ator> atores = new ArrayList<>();

    public void adicionar(Ator ator){
        atores.add(ator);
    }
    public void atualizar(Ator ator){
        for (int i = 0; i <atores.size(); i++) {
            Ator a = atores.get(i);
            if (a.getNome() == ator.getNome()){
                atores.set(i, ator);
                break;
            }
        }
    }

    public void deletar(int id){
        atores.removeIf(a -> a.getId() == id);
    }
    public Ator buscarPorId(int id){
        return atores.stream().filter(a -> a.getId() == id).findFirst().get();
    }

    public List<Ator> buscarTodos(){
        return atores;
    }
}
