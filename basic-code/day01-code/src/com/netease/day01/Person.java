package com.netease.day01;

public class Person {
	int id;
	int age = 20;
	
	Person(int _id, int _age) {
		id = _id;
		age = _age;
	}
	
	public static void main(String[] args) {
		Person tom = new Person(1, 25);
		Person john = new Person(2, 27);
		Person jerry = new Person(1 ,3);  // error
	}
}

/*
class Point {
	int x;
	int y;
	
	//Point () {}
}
*/