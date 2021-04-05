package com.example.PlanetsAndLords.Mapper;

import com.example.PlanetsAndLords.Domain.Lord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LordMapper implements RowMapper<Lord> {
    @Override
    public Lord mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Lord(resultSet.getString("name"),resultSet.getInt("age"),resultSet.getInt("id"));
    }
}
