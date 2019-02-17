package com.example.androidavanzadoclase2.Users;

import java.util.Dictionary;

public class Company {
    String name;
    String catchPhrase;
    String bs;
    Geo geo;

    public Company(String name, String catchPhrase, String bs, Geo geo) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
        this.geo = geo;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
