package tw.skyarrow.ehreader.app.pref;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import tw.skyarrow.ehreader.R;
import tw.skyarrow.ehreader.util.LoginHelper;

/**
 * Created by SkyArrow on 2014/2/4.
 */
public class LogoutDialog extends DialogFragment {
    public static final String TAG = "LogoutDialog";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());

        dialog.setTitle(R.string.logout_title)
                .setMessage(R.string.logout_msg)
                .setPositiveButton(R.string.ok, onSubmitClick)
                .setNegativeButton(R.string.cancel, null);

        return dialog.create();
    }

    private DialogInterface.OnClickListener onSubmitClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            LoginHelper.getInstance(getActivity()).logout();
        }
    };
}
