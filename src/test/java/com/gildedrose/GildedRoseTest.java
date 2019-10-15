package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void updateQuality_shouldLowerQualityAndSellIn() {
        Item[] items = new Item[] { new Item("standard item", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_shouldMakeSellInNegativeButNotQuality() {
        Item[] items = new Item[] { new Item("standard item", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_shouldDegradeByTwo_whenSellInIsBelowZero() {
        Item[] items = new Item[] { new Item("standard item", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);

    }

    @Test
    public void updateQuality_shouldIncreaseQualityOfAgedBrieByTwo_whenSellInIsBelowZero() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_shouldNotIncreaseQualityOfAgedBrieAbove50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_shouldNotAdjustQualityOrSellInForSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80),  new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityForBackstagePassesBy2_whenSellInIs10OrLower() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(14, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityForBackstagePassesBy3_whenSellInIsLessThan6() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(16, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
    }

    @Test
    public void updateQuality_shouldSetQualityTo0_whenSellInIsBelowZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Ignore
    @Test
    public void updateQuality_shouldWorkForMultipleItems() {

    }
}