package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void reduceSellIn(Item item){
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
          item.sellIn -= 1;
      }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private void handleExpiredItems(Item item){
        if (isExpired(item)) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        reduceQualityOf(item);
                    }
                } else {
                    expire(item);
                }
            } else {
                increaseQualityOf(item);
            }
        }
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

    private void expire(Item item) {
        item.quality = 0;
    }

    private boolean isInDemand(Item item) {
        return item.sellIn <= 10;
    }

    private boolean isCoveted(Item item) {
        return item.sellIn <= 5;
    }

    private void handleQualityUpdate(Item item) {
        if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            reduceQualityOf(item);
        } else {
            increaseQualityOf(item);
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (isInDemand(item)) {
                    increaseQualityOf(item);
                }
                if (isCoveted(item)) {
                    increaseQualityOf(item);
                }
            }
        }
    }

    public void updateQuality() {
        for (Item item : items ) {
            handleItem(item);
        }
    }

    public void useLegacyItemStrategy(Item item) {
        handleQualityUpdate(item);
        reduceSellIn(item);
        handleExpiredItems(item);
    }

    public void handleItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                // handlePreservedItem(item);
                useLegacyItemStrategy(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                // handleEpicItem(item);
                useLegacyItemStrategy(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                // handleDeadlineItem(item);
                useLegacyItemStrategy(item);
                break;
            default:
                handleStandardItem(item);
        }
    }

    public void handleStandardItem(Item item) {
        reduceQualityOf(item);
        reduceSellIn(item);
        if(isExpired(item)) {
            reduceQualityOf(item);
        }
    }
}
