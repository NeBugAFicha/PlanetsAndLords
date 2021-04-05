package com.example.PlanetsAndLords.Service;


import com.example.PlanetsAndLords.Domain.Lord;
import com.example.PlanetsAndLords.Domain.Planet;
import com.example.PlanetsAndLords.Mapper.LordMapper;
import com.example.PlanetsAndLords.Mapper.PlanetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.RowSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Override
    public void addLord(Lord lord) {
        jdbcTemplate.update("insert into lords (name, age, countOfPlanets) values (?,?,0)",lord.getName(),lord.getAge());
    }

    @Override
    public void addPlanet(Planet planet) {
        jdbcTemplate.update("insert into planets (name, lord) values (?, null)",planet.getName());
    }

    @Override
    public List<Lord> findAllLords() {
        return jdbcTemplate.query("Select * from lords", new LordMapper());
    }

    @Override
    public List<Planet> findAllPlanets() {
        return jdbcTemplate.query("Select * from planets", new PlanetMapper());
    }

    @Override
    public void appointLord(String newLordId, String planetName, String lordName) {
        SqlRowSet rowset = jdbcTemplate.queryForRowSet("Select * from lords where id = ?", newLordId);
        while(rowset.next()) {
            jdbcTemplate.update("update planets set lord = ? where name = ?", rowset.getString("name"), planetName);
            jdbcTemplate.update("update lords set countOfPlanets = ? where id = ?", rowset.getInt("countOfPlanets") + 1, newLordId);
        }
        if(lordName!=""){
            SqlRowSet rowset2 = jdbcTemplate.queryForRowSet("Select * from lords where name = ?", lordName);
            while(rowset2.next()) jdbcTemplate.update("update lords set countOfPlanets = ? where name = ?", rowset2.getInt("countOfPlanets") - 1,lordName);
        }
    }
}
