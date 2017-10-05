package com.shakeup.tweetnest.commons;

import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Jayson on 9/29/2017.
 *
 * Utility methods
 */

public class Utils {

    // getRelativeTimeAgo("Mon Apr 01 21:16:23 +0000 2014");
    public static String getRelativeTimeAgo(String rawJsonDate) {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        try {
            long dateMillis = sf.parse(rawJsonDate).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }

    public static String getCompactNumber(long num) {
        if (num < 1000) return Long.toString(num);

        double temp = num;
        while (temp > 1000) {
            temp = temp / 1000;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.getDefault(), "%.1f", temp));
        if (num < 1000000) {
            sb.append("K");
        } else if (num < 1000000000) {
            sb.append("M");
        } else if (num < 1000000000000L) {
            sb.append("B");
        }

        return sb.toString();
    }

}
