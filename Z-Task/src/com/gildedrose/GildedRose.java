package com.gildedrose;

class GildedRose {
    Item[] items;


    public GildedRose(Item[] items) {
        this.items = items;
    }

	public void updateQuality() {
		for (Item item : items) {
			int updatedQuality = 0;
			if ("Sulfuras".equals(item.name)) {
				continue;
			} else if ("Aged Brie".equals(item.name) || "Backstage passes".equals(item.name)) {
				updatedQuality = increaseQuality(item.sellIn, item.quality);
			} else {
				updatedQuality = decreaseQuality(item.sellIn, item.quality, item.name);
			}
			item.quality = updatedQuality;
			item.sellIn = --item.sellIn;
		}
	}



	/**
	 * This method is for increasing quality based on sellIn value.
	 * <ul>
	 * <li><b>Sell In value is zero or less: </b>quality will be zero</li>
	 * <li><b>Sell In value is in between 10-6: </b>quality will be increased by 2</li>
	 * <li><b>Sell In value is in between 5-1: </b>quality will be increased by 3</li>
	 * <li><b>Sell In value is greater than 10: </b>No change in quality</li>
	 * <li><b>If updatedQuality is greater than 50: </b>quality will be rounded to 50</li>
	 * </ul>
	 * @param sellIn
	 * @param quality
	 * @return updatedQuality
	 */
	private int increaseQuality(int sellIn, int quality) {
//		int updatedQuality = 0;
//		if (sellIn <= 0) {
//			updatedQuality = 0;
//		} else if (sellIn <= 10 && sellIn > 5) {
//			updatedQuality = quality + 2;
//		} else if (sellIn <= 5 && sellIn > 0) {
//			updatedQuality = quality + 3;
//		} else {
//			updatedQuality = quality;
//		}
		if (updatedQuality > 50) {
			updatedQuality = 50;
		}
		return updatedQuality;
	}

	/**
	 * This method is for decreasing quality based on sellIn and name.
	 * <ul>
	 * <li><b>Sell In value is zero or more: </b>quality will be reduced by one</li>
	 * <li><b>Sell In value is less than zero: </b>quality will be reduced by two</li>
	 * <li><b>If it is Conjured: </b>quality will be reduced twice as others</li>
	 * </ul>
	 * @param sellIn
	 * @param quality
	 * @param name
	 * @return
	 */
	private int decreaseQuality(int sellIn, int quality, String name) {
		int updatedQuality = 0;
		int degrade = sellIn >= 0 ? 1 : 2;
		if ("Conjured".equals(name)) {
			updatedQuality = quality - (degrade * 2);
		} else {
			updatedQuality = quality - degrade;
		}
		if (updatedQuality < 0) {
			updatedQuality = 0;
		}
		return updatedQuality;
	}
}