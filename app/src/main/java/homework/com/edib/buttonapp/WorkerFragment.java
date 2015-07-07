package homework.com.edib.buttonapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Edib on 5.7.2015..
 */
public class WorkerFragment extends Fragment implements Worker {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void transactionWorker(final ViewFragment.OnJobDone listener) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                listener.onDone();
            }
        }, 5000);
    }




}
