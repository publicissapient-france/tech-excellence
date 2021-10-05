package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GildedRoseTest {

    @Test
    void should_decrease_quality_and_sellIn_by_one() {
        Item[] items = new Item[]{new Item("foo", 2, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(1);
        assertThat(app.items[0].quality).isEqualTo(1);
    }

    @Test
    void should_degrade_quality_twice_as_fast_after_expiry() {
        // Given
        Item[] items = new Item[]{new Item("foo", 0, 2)};
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void should_never_have_a_quality_below_0() {
        Item[] items = new Item[]{new Item("foo", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(0);
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void should_increase_quality_of_Aged_Brie_with_time() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(1);
        assertThat(app.items[0].quality).isEqualTo(3);
    }

    @Test
    void should_never_have_a_quality_above_50() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(0);
        assertThat(app.items[0].quality).isEqualTo(49);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isEqualTo(50);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-2);
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    void should_not_modify_Sulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(2);
        assertThat(app.items[0].quality).isEqualTo(2);
    }

    @Test
    void should_increase_quality_of_Backstage_Passes_by_1() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 12, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(11);
        assertThat(app.items[0].quality).isEqualTo(3);
    }

    @Test
    void should_increase_quality_of_Backstage_Passes_by_2_when_sellin_below_10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 9, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(8);
        assertThat(app.items[0].quality).isEqualTo(4);
    }

    @Test
    void should_increase_quality_of_Backstage_Passes_by_3_when_sellin_below_5() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(3);
        assertThat(app.items[0].quality).isEqualTo(5);
    }

    @Test
    void should_drop_quality_of_Backstage_Passes_sellin_has_passed() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 18)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isEqualTo(0);
    }


}
