package com.gildedrose;

import static com.gildedrose.ItemUtils.setQualityToZero;

class DeadlineItemExpiredException extends RuntimeException {
    public DeadlineItemExpiredException(Item item) {
        setQualityToZero(item);
        System.out.println(item);
    }
}
