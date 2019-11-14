package com.gildedrose;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class PreservedItemStrategyTest {

    private PreservedItemStrategy preservedItemStrategy;

    @Before
    public void setUp() {
        preservedItemStrategy = new PreservedItemStrategy();
    }
    
    @Test
    public void updateQuality_shouldIncreaseQualityOfAgedBrie() {
        Item item = new Item("Aged Brie", 5, 5);
        preservedItemStrategy.update(item);
        assertEquals(6, item.quality);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfAgedBrieByTwo_whenSellInIsBelowZero() {
        Item item = new Item("Aged Brie", -1, 5);
        preservedItemStrategy.update(item);
        assertEquals(7, item.quality);
        assertEquals(-2, item.sellIn);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfAgedBrieByTwo_whenSellInIsZero() {
        Item item = new Item("Aged Brie", 0, 5);
        preservedItemStrategy.update(item);
        assertEquals(7, item.quality);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void updateQuality_shouldNotIncreaseQualityOfAgedBrieAbove50() {
        Item item = new Item("standard item", 10, 49);
        preservedItemStrategy.update(item);
        preservedItemStrategy.update(item);
        assertEquals(50, item.quality);
        assertEquals(8, item.sellIn);
    }
}