package com.gildedrose;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class DeadlineItemStrategyTest {

    private DeadlineItemStrategy deadlineItemStrategy;

    @Before
    public void setUp() {
        deadlineItemStrategy = new DeadlineItemStrategy();
    }
    
    @Test
    public void updateQuality_shouldIncreaseQualityForBackstagePasses() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10);
        deadlineItemStrategy.update(item);
        assertEquals(11, item.quality);
        assertEquals(14, item.sellIn);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityForBackstagePassesBy2_whenSellInIs10OrLower() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        deadlineItemStrategy.update(item);
        deadlineItemStrategy.update(item);
        assertEquals(14, item.quality);
        assertEquals(8, item.sellIn);
    }

    @Test
    public void updateQuality_shouldIncreaseQualityForBackstagePassesBy3_whenSellInIsLessThan6() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        deadlineItemStrategy.update(item);
        deadlineItemStrategy.update(item);
        assertEquals(16, item.quality);
        assertEquals(3, item.sellIn);
    }

    @Test
    public void updateQuality_shouldSetQualityForBackStagePassesToZero_whenSellInIsBelowZero() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        deadlineItemStrategy.update(item);
        assertEquals(0, item.quality);
        assertEquals(-1, item.sellIn);
    }


    @Test
    public void updateQuality_shouldKeepQualityAtZero_afterDeadlineItemExpired() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0);
        deadlineItemStrategy.update(item);

        assertEquals(0, item.quality);
        assertEquals(-2, item.sellIn);
    }
}
