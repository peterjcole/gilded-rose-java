package com.gildedrose;

import static com.gildedrose.ItemUtils.*;
import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
            .forEach(item -> StockChecker.examine(item).update(item));
    }
}
