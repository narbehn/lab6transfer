package model;

import java.util.Map;

import DAO.EnrollmentDAO;
import DAO.StudentDAO;
import bean.EnrollmentBean;
import bean.StudentBean;

public class SIS {

	private StudentDAO sd;
	private EnrollmentDAO ed;

	public SIS() throws ClassNotFoundException {
		ed = new EnrollmentDAO();
		sd = new StudentDAO();
	}

	public Map<String, StudentBean> retriveStudent(String namePrefix, String credit_taken) throws Exception {
		
		int credits=0;
		
		try{
			credits=Integer.parseInt(credit_taken);
		} catch(Exception e){
			System.out.println("try, again");
		}
		return sd.retrieve(namePrefix, credits);
	}

	public Map<String, EnrollmentBean> retriveEnrollment(String namePrefix, String credit_taken) throws Exception {
		int credits=0;
		try{
			credits=Integer.parseInt(credit_taken);
		} catch(Exception e){
			System.out.println("try, again");
		}
		return ed.retrieve(namePrefix, credits);

	}

}