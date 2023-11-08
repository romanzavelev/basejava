package com.urise.webapp.model;

public class Link {

    private final String name;
    private final String url;

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Link(" + name + ',' + url + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Link link = (Link) o;
        return name.equals(link.name) && url.equals(link.url);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode() + url.hashCode();
        return result;
    }
}
