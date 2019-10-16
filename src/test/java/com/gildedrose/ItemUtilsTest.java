package com.gildedrose;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

public class ItemUtilsTest {


    @Test
    public void adjustQuality_shouldReduceQualityByOne() {
        Item greenTea = new Item("Green Tea", 5, 5);
        ItemUtils.adjustQuality(greenTea, -1);

        assertEquals(4, greenTea.quality);
    }

    @Test
    public void adjustQuality_shouldNotReduceQualityBelowZero() {
        Item greenTea = new Item("Green Tea", 5, 0);
        ItemUtils.adjustQuality(greenTea, -1);

        assertEquals(0, greenTea.quality);
    }

    @Test
    public void adjustQuality_shouldIncreaseQualityByOne() {
        Item blueCheese = new Item("Blue Cheese", 5, 5);
        ItemUtils.adjustQuality(blueCheese, 1);

        assertEquals(6, blueCheese.quality);
    }

    @Test
    public void adjustQuality_shouldNotIncreaseQualityAboveMaximum() {
        Item blueCheese = new Item("Blue Cheese", 5, ItemUtils.MAXIMUM_QUALITY);
        ItemUtils.adjustQuality(blueCheese, 1);


        assertEquals(ItemUtils.MAXIMUM_QUALITY, blueCheese.quality);
    }

    @Test
    public void reduceSellInOf_shouldReduceSellInByOne() {
        Item blueCheese = new Item("Blue Cheese", 5, ItemUtils.MAXIMUM_QUALITY);
        ItemUtils.reduceSellInOf(blueCheese);

        assertEquals(4, blueCheese.sellIn);
    }

    @Test
    public void setQualityToZero_shouldSetQualityToZero() {
        Item blueCheese = new Item("Blue Cheese", 5, ItemUtils.MAXIMUM_QUALITY);
        ItemUtils.setQualityToZero(blueCheese);

        assertEquals(0, blueCheese.quality);
    }

    @Test
    public void isExpired_shouldReturnTrue_whenSellInIsBelowZero() {
        Item milk = new Item("Milk", 0, 5);
        Item oatMilk = new Item("Oat Milk", -1, 5);

        assertEquals(false, ItemUtils.isExpired(milk));
        assertEquals(true, ItemUtils.isExpired(oatMilk));
    }

    @Test
    public void isInDemand_shouldReturnTrue_whenSellInIsLessThanEleven() {
        Item concertTickets = new Item("Concert tickets", 11, 5);
        Item playTickets = new Item("Play Tickets", 10, 5);

        assertEquals(false, ItemUtils.isInDemand(concertTickets));
        assertEquals(true, ItemUtils.isInDemand(playTickets));
    }

    @Test
    public void isCoveted_shouldReturnTrue_whenSellInIsLessThanSix() {
        Item concertTickets = new Item("Concert tickets", 6, 5);
        Item playTickets = new Item("Play Tickets", 5, 5);

        assertEquals(false, ItemUtils.isCoveted(concertTickets));
        assertEquals(true, ItemUtils.isCoveted(playTickets));
    }
}
