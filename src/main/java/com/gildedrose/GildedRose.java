package com.gildedrose;

import static com.gildedrose.ItemUtils.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items ) {
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
        } catch (PerishableItemExpiredException e) {

        }
    }

    public void handleStandardItem(Item item) {
        reduceQualityOf(item);
        reduceSellInOf(item);
        if(isExpired(item)) {
            reduceQualityOf(item);
        }
    }

    public void handlePreservedItem(Item item) {
        increaseQualityOf(item);
        reduceSellInOf(item);
        if(isExpired(item)) {
            increaseQualityOf(item);
        }
    }

    public void handleEpicItem(Item item) {}

    public void handleDeadlineItem(Item item) {
        increaseQualityOf(item);
        reduceSellInOf(item);
        if(isExpired(item)) {
            setQualityToZero(item);
            throw new PerishableItemExpiredException(item); 
        }
        if (isInDemand(item)) {
            increaseQualityOf(item);
        }
        if (isCoveted(item)) {
            increaseQualityOf(item);
        }
    }
}
