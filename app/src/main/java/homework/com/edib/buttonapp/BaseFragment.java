package homework.com.edib.buttonapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Edib on 5.7.2015..
 */
public abstract class BaseFragment extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_base);
        initWorkerFragments();
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.container, getSingleFragment()).commit();
        }
    }

    public void initWorkerFragments(){}

    public abstract Fragment getSingleFragment();

    public <T extends Fragment> void addWorkerFragment(T instance, String fragmentTag) {
        if (getFragmentByTag(fragmentTag) == null) {
            getSupportFragmentManager().beginTransaction().add(instance, fragmentTag).commit();
        }
    }

    public Fragment getFragmentByTag(String fragmentTag) {
        return getSupportFragmentManager().findFragmentByTag(fragmentTag);
    }

    public Fragment getFragmentById(int fragmentId) {
        return getSupportFragmentManager().findFragmentById(fragmentId);
    }
}
