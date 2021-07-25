package com.titusnangi.theweatherproject.util;

import android.content.Context;
import android.text.format.Time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.titusnangi.theweatherproject.R;

public class Utility {
    public static String formatTemperature(Context context, double temperature) {

        // Data stored in Celsius by default.
        String suffix = "\u00B0";

        //temperature = (temperature * 1.8) + 32;
        return String.format(context.getString(R.string.format_temperature), temperature);
    }

    public static String toTitleCase(String str) {

        if (str == null) {
            return null;
        }

        boolean space = true;
        StringBuilder builder = new StringBuilder(str);
        final int len = builder.length();

        for (int i = 0; i < len; ++i) {
            char c = builder.charAt(i);
            if (space) {
                if (!Character.isWhitespace(c)) {
                    // Convert to title case and switch out of whitespace mode.
                    builder.setCharAt(i, Character.toTitleCase(c));
                    space = false;
                }
            } else if (Character.isWhitespace(c)) {
                space = true;
            } else {
                builder.setCharAt(i, Character.toLowerCase(c));
            }
        }

        return builder.toString();
    }

    public static String formatDate(long dateInMilliseconds) {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy ");
        String dateString = dateFormat.format(new Date(dateInMilliseconds * 1000));
        return dateString;
    }

    public static String format(long dateInMilliseconds) {
        DateFormat dateFormat = new SimpleDateFormat("EEEE ");
        String dateString = dateFormat.format(new Date(dateInMilliseconds * 1000));
        return dateString;
    }

    // Format used for storing dates in the database.  ALso used for converting those strings
    // back into date objects for comparison/processing.
    public static final String DATE_FORMAT = "yyyyMMdd";


    public static String getFormattedMonthDay(Context context, long dateInMillis) {
        Time time = new Time();
        time.setToNow();
        SimpleDateFormat dbDateFormat = new SimpleDateFormat(Utility.DATE_FORMAT);
        SimpleDateFormat monthDayFormat = new SimpleDateFormat("MMMM dd");
        String monthDayString = monthDayFormat.format(dateInMillis);
        return monthDayString;
    }

    public static String getFormattedWind(Context context, float windSpeed) {

        int windFormat;

        windFormat = R.string.format_wind_kmh;

        return String.format(context.getString(windFormat), windSpeed);
    }

    public static int getIconResourceForWeatherCondition(int weatherId) {

        // Based on weather code data found at:
        // http://bugs.openweathermap.org/projects/api/wiki/Weather_Condition_Codes
        if (weatherId >= 200 && weatherId <= 232) {
            return R.drawable.thunderstorm;
        } else if (weatherId >= 300 && weatherId <= 321) {
            return R.drawable.rain;
        } else if (weatherId >= 500 && weatherId <= 504) {
            return R.drawable.rain;
        } else if (weatherId == 511) {
            return R.drawable.snow_icon;
        } else if (weatherId >= 520 && weatherId <= 531) {
            return R.drawable.rain;
        } else if (weatherId >= 600 && weatherId <= 622) {
            return R.drawable.snow_icon;
        } else if (weatherId >= 701 && weatherId <= 761) {
            return R.drawable.fog;
        } else if (weatherId == 761 || weatherId == 781) {
            return R.drawable.storm;
        } else if (weatherId == 800) {
            return R.drawable.sun;
        } else if (weatherId == 801) {
            return R.drawable.patlycloud;
        } else if (weatherId >= 802 && weatherId <= 804) {
            return R.drawable.cloudy;
        }
        return -1;
    }

    public static int getArtResourceForWeatherCondition(int weatherId) {

        // Based on weather code data found at:
        // http://bugs.openweathermap.org/projects/api/wiki/Weather_Condition_Codes
        if (weatherId >= 200 && weatherId <= 232) {
            return R.drawable.storm;
        } else if (weatherId >= 300 && weatherId <= 321) {
            return R.drawable.rain;
        } else if (weatherId >= 500 && weatherId <= 504) {
            return R.drawable.rain;
        } else if (weatherId == 511) {
            return R.drawable.snow_icon;
        } else if (weatherId >= 520 && weatherId <= 531) {
            return R.drawable.rain;
        } else if (weatherId >= 600 && weatherId <= 622) {
            return R.drawable.snow_icon;
        } else if (weatherId >= 701 && weatherId <= 761) {
            return R.drawable.fog;
        } else if (weatherId == 761 || weatherId == 781) {
            return R.drawable.storm;
        } else if (weatherId == 800) {
            return R.drawable.sun;
        } else if (weatherId == 801) {
            return R.drawable.patlycloud;
        } else if (weatherId >= 802 && weatherId <= 804) {
            return R.drawable.cloudy;
        }
        return -1;
    }
}
