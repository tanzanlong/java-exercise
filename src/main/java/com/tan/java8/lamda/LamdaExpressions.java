package com.tan.java8.lamda;

import java.util.ArrayList;
import java.util.List;

public class LamdaExpressions {
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }
    
    
    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
            for (Person p : roster) {
                if (low <= p.getAge() && p.getAge() < high) {
                    p.printPerson();
                }
            }
        }
    
    
    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
            for (Person p : roster) {
                if (tester.test(p)) {
                    p.printPerson();
                }
            }
        }
    
    
    interface CheckPerson {
        boolean test(Person p);
    }
    
    class CheckPersonEligibleForSelectiveService implements CheckPerson {
        public boolean test(Person p) {
            return p.gender == Person.Sex.MALE &&
                p.getAge() >= 18 &&
                p.getAge() <= 25;
        }
    }
    
    public static void main(String[] args) {
        List<Person> roster=new ArrayList<Person>();
        Person person1=new Person();
        roster.add(person1);
        
        printPersons(
                roster,
                (Person p) -> p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 18
                    && p.getAge() <= 25
            );
    }
    
}
