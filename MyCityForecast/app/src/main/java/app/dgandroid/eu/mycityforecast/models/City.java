package app.dgandroid.eu.mycityforecast.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by Duilio on 05/09/2017.
 */

public class City implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;
    @SerializedName("id")
    private int id;

    public City (int id, String name, String country){
        this.id         = id;
        this.country    = country;
        this.name       = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }
}