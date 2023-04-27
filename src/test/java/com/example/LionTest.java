package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean expectedRes;
    @Mock
    Feline feline;

    public LionTest(String sex, boolean expectedRes) {
        this.sex = sex;
        this.expectedRes = expectedRes;
    }
    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"Самец",true},
                {"Самка",false}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1,feline.getKittens());
    }
    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(expectedRes,lion.doesHaveMane());
    }
    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        //Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());

    }
}