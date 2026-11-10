
package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class WorkintechList extends ArrayList<Object> {

    @Override
    public boolean add(Object element) {
        if (contains(element)) {
            return false;
        }

        return super.add(element);
    }

    @Override
    public void add(int index, Object element) {
        if (!contains(element)) {
            super.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<?> collection) {
        boolean changed = false;

        for (Object element : collection) {
            if (add(element)) {
                changed = true;
            }
        }

        return changed;
    }

    @Override
    public boolean addAll(int index, Collection<?> collection) {
        boolean changed = false;
        int currentIndex = index;

        for (Object element : collection) {
            if (!contains(element)) {
                add(currentIndex, element);
                currentIndex++;
                changed = true;
            }
        }

        return changed;
    }

    public void sort() {
        super.sort(new Comparator<Object>() {
            @Override
            public int compare(Object first, Object second) {
                if (first instanceof Number && second instanceof Number) {
                    return Double.compare(
                            ((Number) first).doubleValue(),
                            ((Number) second).doubleValue()
                    );
                }

                if (first instanceof String && second instanceof String) {
                    return ((String) first).compareTo((String) second);
                }

                if (first == null) {
                    return second == null ? 0 : -1;
                }

                if (second == null) {
                    return 1;
                }

                return first.toString().compareTo(second.toString());
            }
        });
    }

    @Override
    public boolean remove(Object element) {
        boolean removed = super.remove(element);

        if (removed) {
            sort();
        }

        return removed;
    }
}
