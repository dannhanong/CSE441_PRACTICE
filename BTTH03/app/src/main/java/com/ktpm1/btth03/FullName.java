package com.ktpm1.btth03;

public class FullName {
    private String first;
    private String last;
    private String midd;

    public FullName(String first, String last, String midd) {
        this.first = first;
        this.last = last;
        this.midd = midd;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getMidd() {
        return midd;
    }

    public void setMidd(String midd) {
        this.midd = midd;
    }
}
