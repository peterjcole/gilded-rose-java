package com.gildedrose;

import static com.gildedrose.ItemUtils.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            try {
                StockChecker.examine(item).update(item);
            } catch (DeadlineItemExpiredException e) {
                System.out.println("You have expired items, chuck them!");
            }
        }
    }
}
