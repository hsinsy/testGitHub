package dao;

import java.util.List;

import model.student;

public interface studentDao {
	void add(student s);
	
	String queryAll1();
	
	List<student> queryAll2();
}
