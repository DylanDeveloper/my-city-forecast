package app.dgandroid.eu.mycityforecast.rest;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import app.dgandroid.eu.mycityforecast.models.City;
import app.dgandroid.eu.mycityforecast.models.Day;

/**
 * Created by Duilio on 05/09/2017.
 */

public class WeatherResponse implements Serializable {

    @SerializedName("list")
    private List<Day> listDays;
    @SerializedName("city")
    private City city;

    public WeatherResponse(List<Day> listDays, City city) {
        this.listDays   = listDays;
        this.city       = city;
    }

    public City getCity() {
        return city;
    }

    public List<Day> getListDays() {
        return listDays;
    }
}