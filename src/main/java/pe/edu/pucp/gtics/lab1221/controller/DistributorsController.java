package pe.edu.pucp.gtics.lab1221.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import pe.edu.pucp.gtics.lab1221.repository.DistributorsRepository;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/distribuidoras")
public class DistributorsController {

    @Autowired
    DistributorsRepository distributorsRepository;
    @GetMapping("/lista")
    public String listaDistribuidoras (Model model){
        List<Distributors> distributorsList = distributorsRepository.findAll();
        model.addAttribute("distribuidorasList",distributorsList);
        return "distribuidoras/lista";
    };

    @GetMapping("/editar")
    public String editarDistribuidoras(@RequestParam("id") int id, Model model){
            Optional<Distributors> optionalDistributors = distributorsRepository.findById(id);
            if (optionalDistributors.isPresent()){
                Distributors distributors = optionalDistributors.get();
                model.addAttribute("distributors", distributors);
                return "distribuidoras/editar";
            }else{
            return "redirect:/distribuidoras/lista";}
    };

    @GetMapping("/nuevo")
    public String nuevaDistribuidora(){
        return "distribuidoras/nuevo";
    };

    @PostMapping("/guardar")
    public String guardarDistribuidora(Distributors distributors){
        distributorsRepository.save(distributors);
        return "redirect:/distribuidoras/lista";
    };

    @GetMapping("/borrar")
    public String borrarDistribuidora(@RequestParam("id") int id){
        Optional<Distributors> optionalDistribuidoras = distributorsRepository.findById(id);
        if (optionalDistribuidoras.isPresent()) {
            distributorsRepository.deleteById(id);
        }
        return "redirect:/distribuidoras/lista";
    };

}
