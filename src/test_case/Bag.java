package test_case;

import java.util.ArrayList;
import java.util.List;

public class Bag extends Item {

    private final int capacity = 6;
    private Item[] items;

    public Bag() {
        items = new Item[capacity];
    }

    public boolean addItem(Item item) {

        List<Bag> innerBags = new ArrayList<>();

        for (int i = 0; i < this.items.length; i++) {

            if (items[i] == null) {
                items[i] = item;
                return true;
            }

        }

        for (int i = 0; i < this.items.length; i++) {

            if (items[i] instanceof Bag) {
                innerBags.add((Bag) items[i]);
            }
        }

        if (innerBags.size() == 0) {
            return false;
        }

        for (Bag bag : innerBags) {
            boolean isItemAdded = bag.addItem(item);

            if (isItemAdded) {
                return true;
            }
        }

        return  false;
    }
}
