package com.example.models.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.config.DBConnection;
import com.example.models.entities.Colors;

@Repository
public class ColorDaoImpl implements ColorDao{
	
	@Qualifier(value = "connectDb")
	@Autowired
	private DBConnection connection;

	public List<Colors> getColors() {	
		Statement statement = null;
		
		String sql = "select id, color_number, name from tsveta";
		
		List<Colors> colors = new ArrayList<Colors>();			
		try{			
			statement = connection.getConnection()
								  .createStatement();
			
			ResultSet resultSet =  statement.executeQuery(sql);
			resultSet = statement.getResultSet();	
					
			while (resultSet.next()) {
				Colors color = new Colors();
				color.setColor_number(resultSet.getString("color_number"));
				color.setName(resultSet.getString("name"));
				colors.add(color);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {				
				statement.close();
				connection.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return colors;
	}
	
	public String getInfo(String param) {
		CallableStatement statement = null;		
		try {
			String SPsql = "{CALL get_info(?,?)}";   			
			statement = connection.getConnection().prepareCall(SPsql);
			statement.setString(1, param); 		   
			statement.registerOutParameter(2, java.sql.Types.VARCHAR);
            statement.execute();
            return statement.getString(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				connection.closeConnection();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			
		}
		return "";
	}

}
