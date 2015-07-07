package homework.com.edib.buttonapp;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Created by Edib on 5.7.2015..
 */
public class ViewFragment extends Fragment {

    private Button onOff;
    private FragmentCallback mFragmentCallback;
    private final String uniqueKey = "from.view.fragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof FragmentCallback ){
            mFragmentCallback = (FragmentCallback)activity;
        } else {
           throw new  ClassCastException(getActivity().toString()+" needs to implements interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View rootView = getView();
        onOff=(Button)rootView.findViewById(R.id.button);
        onOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               buttonState();
            }
        });
    }

    public interface OnJobDone {
        void onDone();
    }

    private void buttonState(){

        onOff.setClickable(false);
        mFragmentCallback.transactionWorker(new OnJobDone() {
            @Override
            public void onDone() {
                onOff.setClickable(true);

            }
        });
    }




}
