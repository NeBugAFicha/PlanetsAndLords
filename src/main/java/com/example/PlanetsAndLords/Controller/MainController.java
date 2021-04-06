package com.example.PlanetsAndLords.Controller;

import com.example.PlanetsAndLords.Domain.Lord;
import com.example.PlanetsAndLords.Domain.Planet;
import com.example.PlanetsAndLords.Service.UserService;
import com.example.PlanetsAndLords.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    public UserServiceImpl userService;

    @GetMapping
    public String main(Model model){
        Iterable<Lord> allLords = userService.findAllLords();
        Iterable<Planet> allPlanets = userService.findAllPlanets();
        model.addAttribute("lords",allLords);
        model.addAttribute("planets",allPlanets);
        return "main";
    }
    @GetMapping("/addLord")
    public String addLord(){
        return "addLord";
    }
    @PostMapping("/addLord")
    public String addLord(@RequestParam String name, @RequestParam double age, Model model){
        if(age<=0||age>Integer.MAX_VALUE){
            model.addAttribute("ageError","Некорректный значение возраста Повелителя");
            if(name.length()==0||name.length()>255) {
                model.addAttribute("nameError", "Некорректные данные имени Повелителя");
                return "addLord";
            }
            return "addLord";
        }else if(name.length()==0||name.length()>255) {
            model.addAttribute("nameError", "Некорректные данные имени Повелителя");
            return "addLord";
        }
        List<Lord> allLords = userService.findAllLords();
        for(int i = 0; i < allLords.size();i++) if(allLords.get(i).getName().equals(name)) {
            model.addAttribute("nameError", "Повелитель с таким именем уже существует");
            return "addLord";
        }
        userService.addLord(new Lord(name,(int) age));
        return "redirect:";
    }
    @GetMapping("/addPlanet")
    public String addPlanet(){
        return "addPlanet";
    }
    @PostMapping("/addPlanet")
    public String addPlanet(@RequestParam String name, Model model){
        if(name.length()==0||name.length()>255) {
            model.addAttribute("nameError", "Некорректные данные имени планеты");
            return "addPlanet";
        }
        List<Planet> allPlanets = userService.findAllPlanets();
        for(int i = 0; i < allPlanets.size();i++) if(allPlanets.get(i).getName().equals(name)) {
            model.addAttribute("nameError", "Планета с таким именем уже существует");
            return "addPlanet";
        }
        userService.addPlanet(new Planet(name));
        return "redirect:";
    }
    @GetMapping("/appointLord")
    public String appointLord(@RequestParam String newLordId, @RequestParam String planetName,@RequestParam String lordName){
        userService.appointLord(newLordId,planetName,lordName);
        return "redirect:";
    }
    @GetMapping("/deletePlanet/{planetName}")
    public String deletePlanet(@PathVariable("planetName") String planetName){
        userService.deletePlanet(planetName);
        return "redirect:";
    }
    @GetMapping("/showSlackers")
    public String showSlackers(Model model){
        Iterable<Lord> slackers = userService.findSlackers();
        Iterable<Lord> allLords = userService.findAllLords();
        Iterable<Planet> allPlanets = userService.findAllPlanets();
        model.addAttribute("lords",allLords);
        model.addAttribute("planets",allPlanets);
        model.addAttribute("slackers",slackers);
        return "main";
    }
    @GetMapping("/showYoungLords")
    public String showYoungLords(Model model){
        Iterable<Lord> youngLords = userService.findYoungLords();
        Iterable<Lord> allLords = userService.findAllLords();
        Iterable<Planet> allPlanets = userService.findAllPlanets();
        model.addAttribute("lords",allLords);
        model.addAttribute("planets",allPlanets);
        model.addAttribute("youngLords",youngLords);
        return "main";
    }
    @GetMapping("/hideAllLists")
    public String hideAllLists(){
        return "redirect:/";
    }
}