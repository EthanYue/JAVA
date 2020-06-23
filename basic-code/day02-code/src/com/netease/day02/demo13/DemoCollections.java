package com.netease.day02.demo13;

import com.netease.util.printUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DemoCollections {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);

        printUtils.print("=", 50);

        Collections.addAll(list, "a", "b");
        System.out.println(list);

        printUtils.print("=", 50);

        Collections.shuffle(list);
        System.out.println(list);

        printUtils.print("=", 50);

        Collections.sort(list);
        System.out.println(list);

        printUtils.print("=", 50);

        ArrayList<Person> list2 = new ArrayList<>();
        list2.add(new Person("yuefeiyu", 18));
        list2.add(new Person("ethan", 14));
        list2.add(new Person("ethan", 18));
        list2.add(new Person("allen", 19));
        System.out.println(list2);
        Collections.sort(list2); // must implement Comparable interface and have compareTo method
        System.out.println(list2);

        printUtils.print("=", 50);

        Collections.sort(list2, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result =  o2.getAge() - o1.getAge();
                if (result == 0) {
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });  // decrease
        System.out.println(list2);
    }
}


