package com.gildedrose;

import static com.gildedrose.ItemUtils.*;

public class DeadlineItemStrategy implements ItemStrategy {
    public void update(Item item) {
        reduceSellInOf(item);

        if(isExpired(item)) {
            throw new DeadlineItemExpiredException(item); 
        }

        int qualityIncrease = calculateDeadlineQualityIncrease(item);
        adjustQuality(item, qualityIncrease);
    }

    private int calculateDeadlineQualityIncrease(Item item) {
        if (isCoveted(item)) {
            return 3;
        } else if (isInDemand(item)) {
            return 2;
        } else {
            return 1;
        }
    }
}
