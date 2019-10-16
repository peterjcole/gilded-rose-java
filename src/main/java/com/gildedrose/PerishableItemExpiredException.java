package com.gildedrose;

class PerishableItemExpiredException extends RuntimeException {
    public PerishableItemExpiredException(Item item) {
        System.out.println(item);
    }
}