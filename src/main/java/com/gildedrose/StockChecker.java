package com.gildedrose;

import java.util.Map;

public class StockChecker {

    public static final StandardItemStrategy standardItemStrategy = new StandardItemStrategy();
    // private static final Map<String, ItemStrategy> itemType = Map.of(
    //     "Aged Brie", preservedItemStrategy
    //     "Sulfuras, Hand of Ragnaros", epicItemStrategy,
    //     "Backstage passes to a TAFKAL80ETC concert", deadlineItemStrategy
    // );

    public static StandardItemStrategy examine(Item item) {
        return new StandardItemStrategy();
    }
}