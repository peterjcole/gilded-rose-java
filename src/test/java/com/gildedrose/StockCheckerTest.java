package com.gildedrose;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class StockCheckerTest {
    @Test
    public void examineShouldReturnStandardItemStrategy() {
        Item greenTea = new Item("Green Tea", 5, 5);
        assertThat(StockChecker.examine(greenTea), isA(StandardItemStrategy.class));
    }
}