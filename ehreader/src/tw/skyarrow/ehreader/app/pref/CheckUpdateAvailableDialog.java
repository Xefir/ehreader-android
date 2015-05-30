package tw.skyarrow.ehreader.app.pref;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import tw.skyarrow.ehreader.R;
import tw.skyarrow.ehreader.util.UpdateHelper;

/**
 * Created by SkyArrow on 2014/2/17.
 */
public class CheckUpdateAvailableDialog extends DialogFragment {
    public static final String TAG = "CheckUpdateAvailableDialog";

    public static final String EXTRA_VERSION = "version";

    private String version;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        Bundle args = getArguments();
        version = args.getString(EXTRA_VERSION);

        dialog.setTitle(R.string.check_update_available_title)
                .setMessage(getString(R.string.check_update_available_msg, version))
                .setPositiveButton(R.string.update, onSubmitClick)
                .setNegativeButton(R.string.cancel, null);

        return dialog.create();
    }

    private DialogInterface.OnClickListener onSubmitClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent(Intent.ACTION_VIEW);

            intent.setData(Uri.parse(UpdateHelper.getDownloadUrl(version)));
            startActivity(intent);
        }
    };
}
