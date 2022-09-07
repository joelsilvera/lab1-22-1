package pe.edu.pucp.gtics.lab1221.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.pucp.gtics.lab1221.entity.Distributors;
import pe.edu.pucp.gtics.lab1221.repository.DistributorsRepository;
import org.springframework.ui.Model;
import java.util.List;

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

    public String editarDistribuidoras(){
        return "";
    };

    public String nuevaDistribuidora(){
        return "";
    };

    public String guardarDistribuidora(){
        return "";
    };

    public String borrarDistribuidora(){
        return "";
    };

}
