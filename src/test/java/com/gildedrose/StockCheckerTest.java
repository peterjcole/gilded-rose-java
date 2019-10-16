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

    @Test
    public void examineShouldReturnPreservedItemStrategy_whenItemIsAgedBrie() {
        Item agedBrie = new Item("Aged Brie", 5, 5);
        assertThat(StockChecker.examine(agedBrie), isA(PreservedItemStrategy.class));
    }

    @Test
    public void examineShouldReturnEpicItemStrategy_whenItemIsSulfuras() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 5, 5);
        assertThat(StockChecker.examine(sulfuras), isA(EpicItemStrategy.class));
    }

    @Test
    public void examineShouldReturnDeadlineItemStrategy_whenItemIsConcertTickets() {
        Item concertTickets = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5);
        assertThat(StockChecker.examine(concertTickets), isA(DeadlineItemStrategy.class));
    }
}