package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Student {
	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column
	private Integer mark;

	public Student() {
	}

	public Student(String name, Integer mark) {
		this.name = name;
		this.mark = mark;
	}
}
