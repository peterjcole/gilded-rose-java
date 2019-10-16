package com.gildedrose;

import static com.gildedrose.ItemUtils.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            handleItem(item);
        }
    }

    public void handleItem(Item item) {
        try {
            switch (item.name) {
                case "Aged Brie":
                    handlePreservedItem(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    handleEpicItem(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    handleDeadlineItem(item);
                    break;
                default:
                    handleStandardItem(item);
            }
        } catch (DeadlineItemExpiredException e) {

        }
    }

    public void handleStandardItem(Item item) {
        reduceSellInOf(item);
        int qualityDecrease = (isExpired(item) ? -2 : -1);
        adjustQuality(item, qualityDecrease);
    }

    public void handlePreservedItem(Item item) {
        reduceSellInOf(item);
        int qualityIncrease = (isExpired(item)) ? 2 : 1;
        adjustQuality(item, qualityIncrease);
    }

    public void handleEpicItem(Item item) {}

    public void handleDeadlineItem(Item item) {
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
