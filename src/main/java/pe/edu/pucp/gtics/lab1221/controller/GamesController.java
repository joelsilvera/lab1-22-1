package pe.edu.pucp.gtics.lab1221.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.pucp.gtics.lab1221.repository.PlatformsRepository;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/juegos")
public class GamesController {

    @Autowired
    GamesRepository gamesRepository;
    @Autowired
    PlatformsRepository platformsRepository;

    @GetMapping("/lista")
    public String listaJuegos (Model model){
        List<Games> gamesList = gamesRepository.findAll();
        model.addAttribute("gamesList",gamesList);
        return "juegos/lista";
    };

    public String editarJuegos(){
        return "";
    };

    public String guardarJuegos(){
        return "";
    };

}
