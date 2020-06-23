package com.netease.day02.demo13;

import com.netease.util.printUtils;

import java.util.*;

public class DemoMap {
    public static void main(String[] args) {
//        hashMap();
//        customMap();
//        linkedHashMap();
        HashMap<Character, Integer> map = countChar();
        System.out.println(map);
        //jdk9: of method just be used List, Set, Map and return an unchanged collection;
//        List<String> list = List.of("A", "B");
    }

    public static void hashMap() {
        Map<String, String> hashMap = new HashMap<>();
        String v1 = hashMap.put("lichen", "fanbingbing");
        String v2 = hashMap.put("lichen", "fanbingbing2");
        hashMap.put("yangmi", "liukaiwei");
        hashMap.put("zhaoliying", "fengshaofeng");
        System.out.println(v1); //null
        System.out.println(v2);  // fanbingbing
        System.out.println(hashMap); // {lichen=fanbingbing2}

        printUtils.print("=", 50);

        String i1 = hashMap.remove("lichen"); // fanbingbing2
        System.out.println(i1);
        String i2 = hashMap.remove("unknown"); // null
        System.out.println(i2);

        printUtils.print("=", 50);

        String i3 = hashMap.get("yangmi");
        System.out.println(i3);  // liukaiwei
        String i4 = hashMap.get("yuefeiyu");
        System.out.println(i4);  // null

        printUtils.print("=", 50);

        Boolean i5 = hashMap.containsKey("zhaoliying");
        System.out.println(i5);

        printUtils.print("=", 50);

        for (String key : hashMap.keySet()) {
            System.out.println(key + ":" + hashMap.get(key)); // yangmi:liukaiwei \n zhaoliying:fengshaofeng
        }

        printUtils.print("=", 50);

        for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
            System.out.println(stringStringEntry); // yangmi=liukaiwei \n zhaoliying=fengshaofeng
            System.out.println(stringStringEntry.getKey()); // yangmi \n zhaoliying
            System.out.println(stringStringEntry.getValue()); // liukaiwei \n fengshaofeng
        }

        printUtils.print("=", 50);

        Iterator<Map.Entry<String, String>> meIter = hashMap.entrySet().iterator();
        while (meIter.hasNext()) {
            Map.Entry<String, String> entry = meIter.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());  // yangmi:liukaiwei \n zhaoliying:fengshaofeng
        }
    }

    public static void customMap() {
        HashMap<String, Student> map = new HashMap<>();
        map.put("beijing", new Student("yuefeiyu", 14));
        map.put("shanghai", new Student("allen", 17));
        map.put("hangzhou", new Student("ethan", 19));
        map.put("beijing", new Student("ethan", 19));
        for (String s : map.keySet()) {
            System.out.println(s + ":" + map.get(s));
        }


        HashMap<Student, String> map1 = new HashMap<>();  // must override hashCode() and equals() when custom Class is key of HashMap
        map1.put(new Student("zhaoliying", 18), "zhaoliying");
        map1.put(new Student("delireba", 19), "delireba");
        map1.put(new Student("delireba", 19), "delireba");
        for (Map.Entry<Student, String> entry : map1.entrySet()) {
            Student student = entry.getKey();
            String value = entry.getValue();
            System.out.println(student + ":" + value);
        }
    }

    public static void linkedHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.put("d", "D");
        map.put("c", "C");
        System.out.println(map);

        printUtils.print("=", 50);

        LinkedHashMap<String, String> lmap = new LinkedHashMap<>();
        lmap.put("a", "A");
        lmap.put("b", "B");
        lmap.put("d", "D");
        lmap.put("c", "C");
        System.out.println(lmap);
    }

    public static HashMap<Character, Integer> countChar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input string:");
        String str = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
           /* Character c = s.charAt(i);
            if (map.containsKey(c)) {
                int cnt = map.get(c);
                map.put(c, ++cnt);
            } else {
                map.put(c, 1);
            }*/
            Integer value = map.get(c);
            if (value != null) ++value;
            else value = 1;
            map.put(c, value);
        }
        return map;
    }

}


class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

