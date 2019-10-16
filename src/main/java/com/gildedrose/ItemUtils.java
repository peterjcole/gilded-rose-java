package com.gildedrose;

public class ItemUtils {

    public static final int MAXIMUM_QUALITY = 50;

    public static void adjustQuality(Item item, int qualityAdjustment) {
        boolean tooHigh = qualityTooHigh(item, qualityAdjustment);
        boolean tooLow = qualityTooLow(item);

        item.quality += (tooHigh || tooLow) ? 0 : qualityAdjustment;
    }

    public static void reduceSellInOf(Item item) {
        item.sellIn -= 1;
    }

    public static void setQualityToZero(Item item) {
        item.quality = 0;
    }

    public static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    public static boolean isInDemand(Item item) {
        return item.sellIn <= 10;
    }

    public static boolean isCoveted(Item item) {
        return item.sellIn <= 5;
    }

    private static boolean qualityTooHigh(Item item, int qualityAdjustment) {
        return item.quality + qualityAdjustment > MAXIMUM_QUALITY;
    }

    private static boolean qualityTooLow(Item item) {
        return item.quality <= 0;
    }
}
