package com.example.myapplication13;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.annotation.RequiresApi;

/**
 * Implementation of App Widget functionality.
 */
public class FirstWidget extends AppWidgetProvider {
    static Intent intent;
    static PendingIntent pendingIntent;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.first_widget);
        //views.setTextViewText(R.id.appwidget_text, widgetText);
        intent.setAction(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("https://www.youtube.com/"));

        pendingIntent.getActivity(context, 0, intent, 0);
        //views.setOnClickPendingIntent(R.id.button, pendingIntent);
        views.setOnClickResponse(R.id.btn, RemoteViews.RemoteResponse.fromPendingIntent(pendingIntent));


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}