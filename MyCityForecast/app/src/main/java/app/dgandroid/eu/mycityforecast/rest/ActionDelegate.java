package app.dgandroid.eu.mycityforecast.rest;

/**
 * Created by Duilio on 05/09/2017.
 */

public interface ActionDelegate {
    void onSuccess(WeatherResponse weatherResponse);
    void onFailure(Object t);
}