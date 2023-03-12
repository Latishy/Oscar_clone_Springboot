package com.example.OscarSite.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OscarRowMapper implements RowMapper<Oscar>{
    public Oscar mapRow(ResultSet rs, int rowNum) throws SQLException{
        Oscar oscarObj=new Oscar(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("category"),
                                rs.getString("status"),
                                rs.getInt("yearof")
                                );
        
        return oscarObj;

    }

}