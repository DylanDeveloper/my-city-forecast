package app.dgandroid.eu.mycityforecast.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import app.dgandroid.eu.mycityforecast.R;
import app.dgandroid.eu.mycityforecast.adapters.WeatherAdapter;
import app.dgandroid.eu.mycityforecast.models.Day;
import app.dgandroid.eu.mycityforecast.rest.ActionCall;
import app.dgandroid.eu.mycityforecast.rest.ActionDelegate;
import app.dgandroid.eu.mycityforecast.rest.WeatherResponse;
import app.dgandroid.eu.mycityforecast.utils.Config;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Duilio on 05/09/2017.
 */

public class CityForecastActivity extends AppCompatActivity {

    @BindView(R.id.weather_recycler_view)   RecyclerView recyclerView;
    @BindView(R.id.swipeContainer)          SwipeRefreshLayout refresh;
    @BindView(R.id.cityName)                TextView cityNameTv;

    private Intent intentExtra;
    private WeatherResponse response;
    private List<Day> days;
    private ActionCall actionCall;
    private String cityName;
    private Context context;
    private WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_forecast);
        ButterKnife.bind(this);

        context         = this;
        intentExtra     = getIntent();
        this.response   = (WeatherResponse) intentExtra.getSerializableExtra(Config.WEATHER_RESP);
        this.days       = response.getListDays();
        cityName        = response.getCity().getName();

        cityNameTv.setText("7 Days Weather in " + cityName);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        weatherAdapter = new WeatherAdapter(days, R.layout.list_item, this);
        recyclerView.setAdapter(weatherAdapter);

        refresh.setOnRefreshListener(this::fetchTimelineAsync);
    }

    public void fetchTimelineAsync() {
        actionCall = new ActionCall(context, cityName, false, new ActionDelegate() {
            @Override
            public void onSuccess(WeatherResponse weatherResponse) {
                days = weatherResponse.getListDays();
                weatherAdapter.onUpdate(days);
                refresh.setRefreshing(false);
            }
            @Override
            public void onFailure(Object t) {
                Toast.makeText(context, "Error cause - " +  t.toString(), Toast.LENGTH_LONG).show();
                refresh.setRefreshing(false);
            }
        });
        actionCall.execute();
    }
}