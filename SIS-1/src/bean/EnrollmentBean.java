package bean;

import java.util.ArrayList;

public class EnrollmentBean {
	
	private String cid;
	private ArrayList<String> students;
	private int credit;
	
	public EnrollmentBean(String cid, ArrayList<String> students, int credit) {
		this.setCid(cid);
		this.setStudents(students);
		this.setCredit(credit);
	}

	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 * @return the students
	 */
	public ArrayList<String> getStudents() {
		return students;
	}

	/**
	 * @param students2 the students to set
	 */
	public void setStudents(ArrayList<String> students2) {
		this.students = students2;
	}

	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}

}
