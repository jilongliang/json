package ivyy.taobao.com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *@Author:liangjl
 *@Date:2014-12-19
 *@Version:1.0
 *@Description:
 */
public class Classz implements Serializable{

	private List<Student> students=new ArrayList<Student>();

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
