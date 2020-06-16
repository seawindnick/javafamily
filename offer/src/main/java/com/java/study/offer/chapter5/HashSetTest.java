package com.java.study.offer.chapter5;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.HashSet;

public class HashSetTest {


    public static void main(String[] args) {

        Person person = new Person();
        person.setAge(11);
        person.setName("abc");
        HashSet set = new HashSet();
        set.add(person);
        person.setName("234");

        person = new Person();
        person.setAge(11);
        person.setName("234");

        System.out.println(set.contains(person));




    }




    @Data
    public static class Person{
        private int age;
        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (!(o instanceof Person)) return false;

            Person person = (Person) o;

            return new EqualsBuilder()
                    .append(getAge(), person.getAge())
                    .append(getName(), person.getName())
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(getAge())
                    .append(getName())
                    .toHashCode();
        }
    }
}
