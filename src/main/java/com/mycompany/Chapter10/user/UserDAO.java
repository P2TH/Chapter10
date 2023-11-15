package com.mycompany.Chapter10.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<UserVO> getUser(UserVO vo) {
		String GET_USER = "select * from users where id=? and password =?";
		Object[] arg = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.query(GET_USER, arg, new UserRowMapper());
		}
	
	class UserRowMapper implements RowMapper<UserVO>{
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO user = new UserVO();
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			return user;
		}
	}
	
}
