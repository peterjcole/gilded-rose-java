package com.gildedrose;

import java.util.Map;

public class StockChecker {

    public static final StandardItemStrategy standardItemStrategy = new StandardItemStrategy();
    public static final PreservedItemStrategy preservedItemStrategy = new PreservedItemStrategy();
    public static final EpicItemStrategy epicItemStrategy = new EpicItemStrategy();
    public static final DeadlineItemStrategy deadlineItemStrategy = new DeadlineItemStrategy();


    private static final Map<String, ItemStrategy> itemType = Map.of(
        "Aged Brie", preservedItemStrategy,
        "Sulfuras, Hand of Ragnaros", epicItemStrategy,
        "Backstage passes to a TAFKAL80ETC concert", deadlineItemStrategy
    );

    public static ItemStrategy examine(Item item) {
        return itemType.getOrDefault(item.name, standardItemStrategy);
    }
}