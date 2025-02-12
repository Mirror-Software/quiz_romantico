package com.quiz.romatico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.quiz.romatico.repository.RepositoryPergunta;


@Controller
public class ControllerPage{
    
    RepositoryPergunta repositoryPergunta = new RepositoryPergunta();

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/cadastro")
    public String cadastroQuiz(){
        return "redirect:/quiz";
    }
     @GetMapping("/quiz")
    public String exibirQuiz(Model model) {
        return "quiz"; // Retorna para a página quiz.html
    }
}