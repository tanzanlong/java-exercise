package com.tan.jdk.clone;

public class CloningExample {
	 public static void main(String[] args) throws CloneNotSupportedException {

	        City city = new City("Dehradun");
	        Person person1 = new Person("Naresh", 10000, city);
	        System.out.println(person1);

	        Person person2 = person1.clone();
	        System.out.println(person2);

	        if (person1 == person2) { // Evaluate false, because person1 and person2 holds different objects
	            System.out.println("Both person1 and person2 holds same object");
	        }

	        if (person1.equals(person2)) { // Evaluate true, person1 and person2 are equal and have same content
	            System.out.println("But both person1 and person2 are equal and have same content");
	        }

	        if (person1.getCity() == person2.getCity()) {
	            System.out.println("Both person1 and person2 have same city object");
	        }
	    }
}
