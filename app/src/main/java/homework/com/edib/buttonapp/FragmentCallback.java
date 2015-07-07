package homework.com.edib.buttonapp;

import android.widget.Button;

/**
 * Created by Edib on 5.7.2015..
 */
public interface FragmentCallback {

    void onMessageReceived();

    void transactionWorker(ViewFragment.OnJobDone listener);


}
