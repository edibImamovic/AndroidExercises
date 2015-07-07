package homework.com.edib.buttonapp;

import android.support.v4.app.Fragment;

/**
 * Created by Edib on 5.7.2015..
 */
public class MyFirstHelper {
    private final Fragment mFragment;

    public static MyFirstHelper getFragmentInstance(Fragment fragment) {
        return new MyFirstHelper(fragment);
    }

    private MyFirstHelper(Fragment fragment) {
        mFragment = fragment;
    }

    public void getFragmentForMessage(InterfaceForHelper listener) {
        if (mFragment != null) {
            listener.onSendActionToFragment(mFragment);
        }
    }

}
