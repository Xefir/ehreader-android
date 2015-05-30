package tw.skyarrow.ehreader.app.pref;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import tw.skyarrow.ehreader.R;

/**
 * Created by SkyArrow on 2014/2/17.
 */
public class CheckUpdateLatestDialog extends DialogFragment {
    public static final String TAG = "CheckUpdateLatestDialog";

    public static final String EXTRA_VERSION = "version";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        Bundle args = getArguments();
        String version = args.getString(EXTRA_VERSION);

        dialog.setTitle(R.string.check_update_latest_title)
                .setMessage(getString(R.string.check_update_latest_msg, version))
                .setPositiveButton(R.string.ok, null);

        return dialog.create();
    }
}