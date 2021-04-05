package com.example.PlanetsAndLords.Service;

import com.example.PlanetsAndLords.Domain.Lord;
import com.example.PlanetsAndLords.Domain.Planet;

import java.util.List;

public interface UserService {
    void addLord(Lord lord);
    void addPlanet(Planet planet);
    List<Lord> findAllLords();
    List<Planet> findAllPlanets();
    void appointLord(String newLordId, String planetName, String lordName);
}
