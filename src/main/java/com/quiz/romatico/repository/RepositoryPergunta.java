package com.quiz.romatico.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.quiz.romatico.Conexao.ModuloConexao;
import com.quiz.romatico.model.ModelPergunta;

public class RepositoryPergunta {
    Connection conexao;
    ResultSet rs;
    PreparedStatement pst;
    ModuloConexao con = new ModuloConexao();

    public ArrayList<ModelPergunta> carregarPerguntas(int quantidade){
        conexao = con.conexao();
        ArrayList<ModelPergunta> listaPergunta = new ArrayList<>();
        ModelPergunta mod = new ModelPergunta();
        try {
            pst = conexao.prepareStatement("SELECT * FROM pergunta ORDER BY RAND() LIMIT ?");
            pst.setInt(1, quantidade);
            rs = pst.executeQuery();
            while(rs.next()){
                mod = new ModelPergunta();
                mod.setTexto(rs.getString("pergunta.texto"));
                listaPergunta.add(mod);
            }
        } catch (SQLException e) {
            System.out.print("houve um erro ao tentar buscar as perguntas: "+e);
        }
        return listaPergunta;
    }
}
