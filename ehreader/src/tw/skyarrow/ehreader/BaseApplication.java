package tw.skyarrow.ehreader;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.IOException;

import tw.skyarrow.ehreader.util.DownloadHelper;
import tw.skyarrow.ehreader.util.UpdateHelper;

/**
 * Created by SkyArrow on 2014/1/25.
 */
public class BaseApplication extends Application {
    private SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        initImageLoader();
        initAutoUpdate();
        setFolderVisibility();
    }

    @Override
    public void onLowMemory() {
        ImageLoader.getInstance().clearMemoryCache();
    }

    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .build();

        ImageLoader.getInstance().init(config);
    }

    private void initAutoUpdate() {
        boolean firstInstalled = preferences.getBoolean(getString(R.string.pref_first_installed), true);

        if (firstInstalled) {
            SharedPreferences.Editor editor = preferences.edit();
            UpdateHelper updateHelper = new UpdateHelper(this);

            updateHelper.setupAlarm();
            editor.putBoolean(getString(R.string.pref_first_installed), false);
            editor.apply();
        }
    }

    private void setFolderVisibility() {
        try {
            boolean isVisible = preferences.getBoolean(getString(R.string.pref_hide_files),
                    getResources().getBoolean(R.bool.pref_hide_files_default));

            DownloadHelper.setFolderVisibility(!isVisible);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
