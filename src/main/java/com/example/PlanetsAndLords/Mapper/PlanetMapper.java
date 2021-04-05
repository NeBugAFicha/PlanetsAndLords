package com.example.PlanetsAndLords.Mapper;

import com.example.PlanetsAndLords.Domain.Planet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanetMapper implements RowMapper<Planet> {
    @Override
    public Planet mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Planet(resultSet.getString("name"),resultSet.getString("lord"));
    }
}
