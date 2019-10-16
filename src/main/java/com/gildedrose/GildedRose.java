package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void reduceSellIn(Item item){
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
          item.sellIn = item.sellIn - 1;
      }
    }

    private void handleExpiredItems(Item item){
        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
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
            item.quality = item.quality + 1;
        }
    }

    private void handleQualityUpdate(Item item) {
        if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                    && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            reduceQualityOf(item);
        } else {
            increaseQualityOf(item);

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 11) {
                    increaseQualityOf(item);
                }

                if (item.sellIn < 6) {
                    increaseQualityOf(item);
                }
            }
        }
    }

    public void updateQuality() {
        for (Item item : items ) {
            handleQualityUpdate(item);
            reduceSellIn(item);
            handleExpiredItems(item);
        }
    }
}