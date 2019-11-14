package com.gildedrose;

import static com.gildedrose.ItemUtils.*;

public class StandardItemStrategy implements ItemStrategy {
    public void update(Item item) {
        reduceSellInOf(item);
        int qualityDecrease = (isExpired(item) ? -2 : -1);
        adjustQuality(item, qualityDecrease);
    }
}
