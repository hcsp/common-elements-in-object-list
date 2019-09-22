package com.github.hcsp.collection;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Arrays;

public class Main {
    // 请编写一个方法，获得a和b集合中的公共元素。
    public static Set<Person> commonElementsIn(List<Person> a, List<Person> b) {
        Set<Person> result = new HashSet<>();
        Map<Person, Integer> hashMap = new HashMap<>(a.size() + b.size());
        for (Person p : a) {
            hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        }
        for (Person p : b) {
            hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        }
        hashMap.forEach((key, value) -> {
            if (value >= 2) {
                result.add(key);
            }
        });
        return result;
    }


    // Person类，如果两个Person对象的name相等，则认为这两个对象相等。
    public static class Person {
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
        public boolean equals(Object obj) {
            return Objects.equals(name, ((Person) obj).getName());
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

    }

    public static void main(String[] args) {
        List<Person> list1 = Arrays.asList(new Person("张学友"), new Person("周杰伦"));
        List<Person> list2 = Arrays.asList(new Person("周润发"), new Person("周杰伦"));
        System.out.println(commonElementsIn(list1, list2));
    }
}
