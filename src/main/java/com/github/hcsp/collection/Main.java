package com.github.hcsp.collection;

import java.util.*;

public class Main {
    // 请编写一个方法，获得a和b集合中的公共元素。
    public static Set<Person> commonElementsIn(List<Person> a, List<Person> b) {
        Set<Person> set = new HashSet<>();//保存重复的值
        HashMap<String, Integer> map = new HashMap<>();//利用map来找出重复元素
        for (Person pa : a
        ) {
            map.put(pa.getName(), 1);
        }
        for (Person pb : b
        ) {
            if (map.containsKey(pb.getName())) {
                set.add(pb);
            } else {
                map.put(pb.getName(), 1);
            }
        }
        return set;
    }

    // Person类，如果两个Person对象的name相等，则认为这两个对象相等。
    public static class Person implements Comparable<Person> {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Person person) {
            return this.name.compareTo(person.name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Person> list1 = Arrays.asList(new Person("张学友"), new Person("周杰伦"));
        List<Person> list2 = Arrays.asList(new Person("周润发"), new Person("周杰伦"));
        System.out.println(commonElementsIn(list1, list2));
    }
}
