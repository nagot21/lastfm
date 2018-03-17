package com.nagot.lastfm.utils;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Nagot on 17/03/2018.
 */

public class KeyboardUtil {
    public static void looseSearchEditTextFocus(Context context, Window window, EditText editText) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        editText.clearFocus();
        InputMethodManager imm =
                (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

        }
    }
}
