package DAO;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

//import javax.activation.DataSource;
import javax.naming.*;
import javax.sql.DataSource;

import bean.StudentBean;

public class StudentDAO {

	private DataSource ds;

	public StudentDAO() throws ClassNotFoundException{
		try {
		ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
		e.printStackTrace();
		}
	}
	
	public Map<String, StudentBean> retrieve(String namePrefix, int credit_taken) throws
	SQLException{
	String query = "select * from students where surname like '%" + namePrefix + 
			"'% and credit_taken >=" + credit_taken;
	 Map<String, StudentBean> rv = new HashMap<String, StudentBean>();
	Connection con = this.ds.getConnection();
	PreparedStatement p = con.prepareStatement(query);
	ResultSet r = p.executeQuery();
	
		while (r.next()){
			String name = r.getString("GIVENNAME") + ", " + r.getString("SURNAME");
			String sid = r.getString("SID");
			int credittaken = r.getInt("CREDITS_TAKEN");
			int creditgraduate = r.getInt("CREDIT_GRADUATE");
			StudentBean sb = new StudentBean(name, sid, credittaken, creditgraduate);
			rv.put(sid, sb);
	    }
		r.close();
		p.close();
		con.close();
		return rv;
	}
}
