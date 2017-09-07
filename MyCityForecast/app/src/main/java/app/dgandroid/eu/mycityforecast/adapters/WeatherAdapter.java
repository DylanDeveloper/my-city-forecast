package app.dgandroid.eu.mycityforecast.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import app.dgandroid.eu.mycityforecast.R;
import app.dgandroid.eu.mycityforecast.models.Day;
import app.dgandroid.eu.mycityforecast.utils.Utility;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Duilio on 05/09/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<Day> days;
    private int rowLayout;
    private Context context;

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(rowLayout, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        int morn                    = (int)days.get(position).getTemperatures().getMorn();
        int day                     = (int)days.get(position).getTemperatures().getDay();
        int eve                     = (int)days.get(position).getTemperatures().getEve();
        int nght                    = (int)days.get(position).getTemperatures().getNight();
        String dateDayNumber        = Utility.getTypeDateUnit(days.get(position).getDt(), Utility.DAY_NUMBER);
        String dateDayText          = Utility.getTypeDateUnit(days.get(position).getDt(), Utility.DAY_TEXT);
        String dateMonthNumber      = Utility.getTypeDateUnit(days.get(position).getDt(), Utility.MONTH_NUMBER);
        holder.dayNumber.setText(dateDayNumber+"/"+dateMonthNumber);
        holder.dayName.setText(dateDayText);
        holder.tempMorn.setText     (morn   + "°");
        holder.tempDay.setText      (day    + "°");
        holder.tempEve.setText      (eve    + "°");
        holder.tempNight.setText    (nght   + "°");
        holder.main.setText(days.get(position).getWeathers().get(0).getMain());
        holder.icon.setBackground(Utility.getIcon(context, days.get(position).getWeathers().get(0).getIcon()));
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.main)        TextView    main;
        @BindView(R.id.icon)        ImageView   icon;
        @BindView(R.id.temp_morn)   TextView    tempMorn;
        @BindView(R.id.temp_day)    TextView    tempDay;
        @BindView(R.id.temp_eve)    TextView    tempEve;
        @BindView(R.id.temp_night)  TextView    tempNight;
        @BindView(R.id.dayNumber)   TextView    dayNumber;
        @BindView(R.id.dayName)     TextView    dayName;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public WeatherAdapter(List<Day> days, int rowLayout, Context context) {
        this.days       = days;
        this.rowLayout  = rowLayout;
        this.context    = context;
    }

    public void onUpdate(List<Day> days){
        this.days.clear();
        this.days = days;
        notifyDataSetChanged();
    }
}