package app.dgandroid.eu.mycityforecast.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Duilio on 05/09/2017.
 */

public class Day implements Serializable {
    @SerializedName("weather")
    private List<Weather> weathers;
    @SerializedName("temp")
    private Temperature temperatures;
    @SerializedName("dt")
    private long dt;
    @SerializedName("pressure")
    private float pressure;
    @SerializedName("humidity")
    private int humidity;
    @SerializedName("speed")
    private float speed;
    @SerializedName("deg")
    private int deg;
    @SerializedName("clouds")
    private int clouds;

    public Day(List<Weather> weathers, Temperature temperatures, long dt, float pressure, int humidity, float speed, int deg, int clouds){
        this.weathers       = weathers;
        this.temperatures   = temperatures;
        this.dt             = dt;
        this.deg            = deg;
        this.pressure       = pressure;
        this.humidity       = humidity;
        this.speed          = speed;
        this.clouds         = clouds;
    }

    public Temperature getTemperatures() {
        return temperatures;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public int getHumidity() {
        return humidity;
    }

    public float getSpeed() {
        return speed;
    }

    public int getClouds() {
        return clouds;
    }

    public int getDeg() {
        return deg;
    }

    public long getDt() {
        return dt;
    }

    public float getPressure() {
        return pressure;
    }
}