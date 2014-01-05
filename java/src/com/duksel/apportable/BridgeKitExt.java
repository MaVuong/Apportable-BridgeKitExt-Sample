package com.duksel.apportable;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.*;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;

public class BridgeKitExt
{
    private static final String TAG = "BridgeKitExt";

    private String initMessage = "";

    public BridgeKitExt( String str )
    {
        Log.d( TAG, "Execute constructor" );
        
        initMessage = str;
    }

    public String getDeviceIMEI( Activity activity )
    {
        Log.d( TAG, "Execute getDeviceIMEI()" );

        String imei;
        
		try
		{
            imei = Settings.Secure.getString( activity.getContentResolver(), Settings.Secure.ANDROID_ID );
		}
		catch( Exception e )
		{
            imei = "undefined";
		}

        return imei + " by ["+initMessage+"]";
    }
    
    public void createView( final Activity activity )
    {
        Log.d( TAG, "Execute createView()" );

        Handler handler = new Handler( activity.getBaseContext().getMainLooper() );
        
        handler.post( new Runnable() {
            @Override
            public void run()
            {
                View viewBlue = new View(activity);
                viewBlue.setBackgroundColor(Color.BLUE);
                viewBlue.invalidate();

                LayoutParams layout = new RelativeLayout.LayoutParams( 400, 100 );

                Window activityWindow = activity.getWindow();
                activityWindow.addContentView( viewBlue, layout );
            }
        });
    }

    public void createPopupWindow( final Activity activity )
    {
        Log.d( TAG, "Execute createPopupWindow()" );

        Handler handler = new Handler( activity.getBaseContext().getMainLooper() );
        
        handler.post( new Runnable() {
            @Override
            public void run()
            {
                PopupWindow  popupWindow = new PopupWindow(activity);
                LinearLayout popupLayout = new LinearLayout(activity);
                LinearLayout mainLayout  = new LinearLayout(activity);


                View viewGreen = new View(activity);
                viewGreen.setBackgroundColor(Color.GREEN);
                viewGreen.invalidate();
                popupLayout.addView( viewGreen, new LayoutParams( 100, 40 ) );
                
                
                View viewRed = new View(activity);
                viewRed.setBackgroundColor(Color.RED);
                viewRed.invalidate();
                popupLayout.addView(viewRed, new LayoutParams( 80, 30 ) );
                
                
                popupLayout.setOrientation(LinearLayout.HORIZONTAL);
                
                
                popupWindow.setContentView( popupLayout );
                popupWindow.showAtLocation( mainLayout, Gravity.BOTTOM, 0, 0 );
                popupWindow.update( 0, 0, 300, 100 );
            }
        });
    }
}
