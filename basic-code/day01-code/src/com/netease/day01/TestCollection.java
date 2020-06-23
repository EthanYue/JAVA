package com.netease.day01;

import java.util.*;
public class TestCollection {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("hello");
		c.add(new Name1("ethan", "yue"));
		c.add(new Integer(100));
		System.out.println(c.size());
		System.out.println(c);
	}
}


class Name1 {
	private String firstName, lastName;
	public Name1(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String toString() {
		return firstName + "" + lastName;
	}
}