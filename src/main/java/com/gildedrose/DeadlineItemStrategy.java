package com.gildedrose;

import static com.gildedrose.ItemUtils.*;

public class DeadlineItemStrategy implements ItemStrategy {
    public void update(Item item) {
        try {
            handleUpdate(item);
        } catch (DeadlineItemExpiredException e) {
            System.out.println(item.name + " is expired, please throw it away!");
        }
    }

    private void handleUpdate(Item item) {
        reduceSellInOf(item);
        expireIfDeadlineHit(item);
        adjustQuality(item, calculateDeadlineQualityIncrease(item));
    }

    private void expireIfDeadlineHit(Item item) {
        if(isExpired(item)) {
            throw new DeadlineItemExpiredException(item); 
        }
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
