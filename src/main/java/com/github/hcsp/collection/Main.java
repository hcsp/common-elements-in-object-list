package com.github.hcsp.collection;

import java.util.*;

public class Main {
    // 请编写一个方法，获得a和b集合中的公共元素。
    public static Set<Person> commonElementsIn(List<Person> a, List<Person> b) {
        ArrayList<Person> personsOne = new ArrayList<>(a);
        ArrayList<Person> personsTwo = new ArrayList<>(b);
        personsOne.retainAll(personsTwo);
        return new HashSet<>(personsOne);
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
            if(obj instanceof Person) {
                Person person = (Person) obj;
                return this.getName().equals(person.getName());
            }
            return false;
        }


        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        List<Person> list1 = Arrays.asList(new Person("张学友"), new Person("周杰伦"));
        List<Person> list2 = Arrays.asList(new Person("周润发"), new Person("周杰伦"));
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(commonElementsIn(list1, list2));
    }
}
