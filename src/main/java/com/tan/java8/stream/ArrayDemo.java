package com.tan.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDemo {
public static void main(String[] args) {
    List<Integer> nums=new ArrayList<Integer>();
    List<Integer> evens = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
}

}
