package com.netease.day01;

class Animal {
//abstract class Animal {
	private String name;
	
	Animal(String name){this.name=name;}
	
	public void enjoy(){System.out.println("scream...");}
	
	//public abstract void enjoy();
}


class Cat extends Animal {
	private String eyesColor;
	
	Cat(String n, String c){super(n); eyesColor=c;}
	
	public void enjoy(){System.out.prinln("cat scream...");}
}


class Dog extends Animal {
	private String furColor;
	
	Dog(String name) {
		super(name);
	}

	public void enjoy(){System.out.prinln("dog scream...");}
}


class Lady {
	private String name;
	private Animal pet;
	
	Lady(String name, Animal pet) {
		this.name = name;
		this.pet = pet;
	}
	
	public void myPetEnjoy(){pet.enjoy();}
}


public class TestPolymoph {
	public static void main(String[] args) {
		Cat c = new Cat("mimi", "blue");
		Dog d = new Dog("wangwang", "black");
		Lady l1 = new Lady("lili", c);
		Lady l2 = new Lady("juli", d);
		l1.myPetEnjoy();
		l2.myPetEnjoy();
	}
}