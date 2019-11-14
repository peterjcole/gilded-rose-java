package com.gildedrose;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class StandardItemStrategyTest {

    private StandardItemStrategy standardItemStrategy;

    @Before
    public void setUp() {
        standardItemStrategy = new StandardItemStrategy();
    }
    
    @Test
    public void updateQuality_shouldLowerQualityAndSellIn() {
        Item item = new Item("standard item", 5, 5);
        standardItemStrategy.update(item);
        assertEquals(4, item.quality);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void updateQuality_shouldMakeSellInNegativeButNotQuality() {
        Item item = new Item("standard item", 0, 0);
        standardItemStrategy.update(item);
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void updateQuality_shouldDegradeByTwo_whenSellInIsBelowZero() {
        Item item = new Item("standard item", -1, 5);
        standardItemStrategy.update(item);
        assertEquals(3, item.quality);
        assertEquals(-2, item.sellIn);
    }

    @Test
    public void updateQuality_shouldDegradeByTwo_whenSellInIsZero() {
        Item item = new Item("standard item", 0, 5);
        standardItemStrategy.update(item);
        assertEquals(3, item.quality);
        assertEquals(-1, item.sellIn);
    }
}