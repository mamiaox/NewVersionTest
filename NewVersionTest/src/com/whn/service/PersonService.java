package com.whn.service;

import java.util.ArrayList;

import com.whn.dao.PersonDao;
import com.whn.domain.Person;

/**
 * 业务层
 *
 * @author user
 */
public class PersonService {
	PersonDao personDao = new PersonDao();

	/**
	 * 新增人员
	 *
	 * @param p
	 */
	public void add(Person p) {
		personDao.add(p);
	}

	public void update(Person p) {
		personDao.update(p);
	}

	public ArrayList<Person> show() {

		ArrayList<Person> arrayList = personDao.show();
		// for (Person person : arrayList) {
		// System.out.println(person.getName());
		// }
		return arrayList;
	}

	public void delete(Person p) {
		personDao.delete(p);
	}

}
