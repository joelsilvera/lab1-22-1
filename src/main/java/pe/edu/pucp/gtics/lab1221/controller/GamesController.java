package pe.edu.pucp.gtics.lab1221.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Games;
import pe.edu.pucp.gtics.lab1221.entity.Platforms;
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

    @GetMapping("/editar")
    public String editarJuegos(@RequestParam("id") int id, Model model) {
        List<Platforms> platformsList = platformsRepository.findAll();
        model.addAttribute("platformsList",platformsList);

        Optional<Games> optionalGames = gamesRepository.findById(id);
        if(optionalGames.isPresent()){
            Games games = optionalGames.get();
            model.addAttribute("games", games);
            return "juegos/editar";
        }else{
            return "redirect:/juegos/lista";
        }

    };

    @PostMapping("/guardar")
    public String guardarJuegos(Games games){
        gamesRepository.save(games);
        return "redirect:/juegos/lista";
    };

}
