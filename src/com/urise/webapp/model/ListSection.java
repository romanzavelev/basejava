package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {
    private final List<String> items;

    public ListSection(String...items){
        this(List.of(items));
    }
    ListSection(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListSection that)) return false;
        return getItems().equals(that.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItems());
    }
}
