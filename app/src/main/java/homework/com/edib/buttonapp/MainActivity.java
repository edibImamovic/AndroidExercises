package homework.com.edib.buttonapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class MainActivity extends BaseFragment implements FragmentCallback {

    private static final String FRAGMENT_WORKER = "fragment_worker";

    @Override
    public Fragment getSingleFragment() {
        return new ViewFragment();
    }


    @Override
    public void onMessageReceived() {
        Toast.makeText(this, "It's Alive", Toast.LENGTH_LONG).show();
    }


    @Override
    public void transactionWorker(final ViewFragment.OnJobDone listener) {
        Fragment fragment  = getFragmentByTag(FRAGMENT_WORKER);
        if (fragment != null) {
            if (fragment instanceof Worker) {
                Worker worker = (Worker)fragment;
                worker.transactionWorker(listener);
            }
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addWorkerFragment(new WorkerFragment(), FRAGMENT_WORKER);
    }

}
