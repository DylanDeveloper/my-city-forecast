package app.dgandroid.eu.mycityforecast.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by Duilio on 05/09/2017.
 */

public class Weather implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("main")
    private String main;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getMain() {
        return main;
    }

    public Weather(int id, String main, String description, String icon){
        this.id             = id;
        this.description    = description;
        this.main           = main;
        this.icon           = icon;
    }
}