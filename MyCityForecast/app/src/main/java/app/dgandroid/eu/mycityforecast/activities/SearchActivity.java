package app.dgandroid.eu.mycityforecast.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;
import app.dgandroid.eu.mycityforecast.R;
import app.dgandroid.eu.mycityforecast.customs.BurnsViewEffect;
import app.dgandroid.eu.mycityforecast.customs.LoopViewPager;
import app.dgandroid.eu.mycityforecast.rest.ActionCall;
import app.dgandroid.eu.mycityforecast.rest.ActionDelegate;
import app.dgandroid.eu.mycityforecast.rest.WeatherResponse;
import app.dgandroid.eu.mycityforecast.utils.Config;
import app.dgandroid.eu.mycityforecast.utils.Utility;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Duilio on 05/09/2017.
 */

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.searchBtn)           Button searchButton;
    @BindView(R.id.cityText)            EditText cityText;
    @BindView(R.id.ken_burns_view)      BurnsViewEffect burnsViewEffect;
    @BindView(R.id.view_pager_frame)    FrameLayout viewPagerFrame;

    private ActionCall actionCall;
    private Context context;
    private String city         = "Saint Petersburg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        context = this;
        initializeBurnsViewEffect();

        searchButton.setOnClickListener(e-> {
            if(cityText.getText().toString().length() == 0) {
                Toast.makeText(context, "Write your city!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                city = cityText.getText().toString();
            }
            actionCall = new ActionCall(context, city, true, new ActionDelegate() {
                @Override
                public void onSuccess(WeatherResponse weatherResponse) {
                    Intent intent = new Intent(SearchActivity.this, CityForecastActivity.class);
                    intent.putExtra(Config.WEATHER_RESP, weatherResponse);
                    startActivity(intent);
                }
                @Override
                public void onFailure(Object t) {
                    Toast.makeText(context, "Error cause - " +  t.toString(), Toast.LENGTH_LONG).show();
                }
            });
            actionCall.execute();
        });
    }

    private void initializeBurnsViewEffect(){
        burnsViewEffect.setScaleType(ImageView.ScaleType.CENTER_CROP);
        burnsViewEffect.setSwapMs(4500);
        burnsViewEffect.setFadeInOutMs(650);
        List<Integer> resourceIDs = Arrays.asList(Utility.IMAGES_RESOURCE);
        burnsViewEffect.loadResourceIDs(resourceIDs);
        LoopViewPager loopViewPager = new LoopViewPager(this, resourceIDs.size());
        viewPagerFrame.addView(loopViewPager);
        burnsViewEffect.setPager(loopViewPager);
    }
}