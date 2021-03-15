package com.github.hcsp.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    // 请编写一个方法，获得a和b集合中的公共元素。git
    public static Set<Person> commonElementsIn(List<Person> a, List<Person> b) {
        Set<Person> commonElements = new HashSet<>(a);
        commonElements.retainAll(b);
        return commonElements;
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
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Person) {
                Person person = (Person) obj;
                return this.name.equals(person.getName());
            }
            return false;
        }
    }

    public static void main(String[] args) {
        List<Person> list1 = Arrays.asList(new Person("张学友"), new Person("周杰伦"));
        List<Person> list2 = Arrays.asList(new Person("周润发"), new Person("周杰伦"));
        System.out.println(commonElementsIn(list1, list2));
    }
}
