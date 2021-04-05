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
    public String addLord(Lord lord){
        userService.addLord(lord);
        return "redirect:";
    }
    @GetMapping("/addPlanet")
    public String addPlanet(){
        return "addPlanet";
    }
    @PostMapping("/addPlanet")
    public String addPlanet(Planet planet){
        userService.addPlanet(planet);
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