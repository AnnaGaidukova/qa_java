package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int expectedkittensCount;
    private final int kittensCount;
    public FelineTest(int expectedkittensCount, int kittensCount) {
        this.expectedkittensCount = expectedkittensCount;
        this.kittensCount = kittensCount;
    }
    @Parameterized.Parameters(name = "Тест: кол-во котят: 0, 1")
    public static Object[][] params() {
        return new Object[][]{
                {1, 1},
                {2, 2},
        };
    }
    @Test
    public void getFamily(){
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void getFoodTest() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }
    @Test
    public void getKittens() {
        Feline feline = new Feline();
        Assert.assertEquals(1,feline.getKittens());
    }
    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        Assert.assertEquals(expectedkittensCount, feline.getKittens(kittensCount));
    }
}