package tw.skyarrow.ehreader.app.pref;

import android.app.Activity;
import android.os.Bundle;

import tw.skyarrow.ehreader.R;

/**
 * Created by SkyArrow on 2014/2/9.
 */
public class AboutActivity extends Activity {
    public static final String TAG = "AboutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
}
