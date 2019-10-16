package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void reduceSellIn(Item item){
        item.sellIn -= 1;
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private void reduceQualityOf(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    private void increaseQualityOf(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void setQualityToZero(Item item) {
        item.quality = 0;
    }

    private boolean isInDemand(Item item) {
        return item.sellIn <= 10;
    }

    private boolean isCoveted(Item item) {
        return item.sellIn <= 5;
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
        reduceSellIn(item);
        if(isExpired(item)) {
            reduceQualityOf(item);
        }
    }

    public void handlePreservedItem(Item item) {
        increaseQualityOf(item);
        reduceSellIn(item);
        if(isExpired(item)) {
            increaseQualityOf(item);
        }
    }

    public void handleEpicItem(Item item) {}

    public void handleDeadlineItem(Item item) {
        increaseQualityOf(item);
        reduceSellIn(item);
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
