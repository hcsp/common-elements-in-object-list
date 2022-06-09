package com.github.hcsp.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void test() {
        List<Main.Person> list1 = Arrays.asList(new Main.Person("张学友"), new Main.Person("周杰伦"));
        List<Main.Person> list2 = Arrays.asList(new Main.Person("周润发"), new Main.Person("周杰伦"));
        Assertions.assertEquals(
                new HashSet(Arrays.asList(new Main.Person("周杰伦"))),
                Main.commonElementsIn(list1, list2));
    }
}
