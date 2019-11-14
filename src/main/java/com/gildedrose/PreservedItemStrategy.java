package com.gildedrose;

import static com.gildedrose.ItemUtils.*;

public class PreservedItemStrategy implements ItemStrategy {
    public void update(Item item) {
        reduceSellInOf(item);
        int qualityIncrease = (isExpired(item)) ? 2 : 1;
        adjustQuality(item, qualityIncrease);

    }
}
