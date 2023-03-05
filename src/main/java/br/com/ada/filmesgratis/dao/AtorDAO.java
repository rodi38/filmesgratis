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

    public void deletar(Ator ator){
         atores.removeIf(a -> a.getNome() == ator.getNome());
    }

    public Ator buscarPorNome(String nome){
        return atores.stream().filter(a -> a.getNome() == nome).findFirst().get();
    }

    public List<Ator> buscarTodos(){
        return atores;
    }
}
