package com.gildedrose;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class EpicItemStrategyTest {

    private EpicItemStrategy epicItemStrategy;

    @Before
    public void setUp() {
        epicItemStrategy = new EpicItemStrategy();
    }
    
    @Test
    public void updateQuality_shouldNotAdjustQualityOrSellInForSulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        epicItemStrategy.update(item);
        assertEquals(10, item.quality);
        assertEquals(10, item.sellIn);
    }

}
