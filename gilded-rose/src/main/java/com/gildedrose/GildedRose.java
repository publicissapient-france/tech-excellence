package com.gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            item.sellIn = item.sellIn - 1;
            if (item.name.equals("Aged Brie")) {
                increaseQuality(item);
                if (item.sellIn < 0) {
                    increaseQuality(item);
                }
            } else if (item.name.equals("Conjured")) {
                decreaseQuality(item);
                decreaseQuality(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;
                    if (item.sellIn < 11) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQuality(item);
                    }
                }

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            } else {
                decreaseQuality(item);

                if (item.sellIn < 0) {
                    decreaseQuality(item);
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
}