package upsi.beerup;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A fragment with a button.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    MiliChrono chrono;
    FloatingActionButton start;
    FloatingActionButton pause;
    long timeWhenStopped = 0;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //Find elements
        chrono = (MiliChrono) view.findViewById(R.id.chronometer);
        start = (FloatingActionButton) view.findViewById(R.id.start);
        start.setOnClickListener(this);
        pause = (FloatingActionButton) view.findViewById(R.id.pause);
        pause.setOnClickListener(this);
        FloatingActionButton stop = (FloatingActionButton) view.findViewById(R.id.stop);
        stop.setOnClickListener(this);

        return view;
    }

    public void startChronometer(){
        chrono.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chrono.start();
        start.hide();
        pause.show();
    }

    public void pauseChronometer(){
        timeWhenStopped = chrono.getBase() - SystemClock.elapsedRealtime();
        chrono.stop();
        pause.hide();
        start.show();
    }

    public void resetChronometer(){
        timeWhenStopped = 0;
        chrono.setBase(SystemClock.elapsedRealtime());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                startChronometer();
                break;
            case R.id.pause:
                pauseChronometer();
                break;
            case R.id.stop:
                resetChronometer();
                break;
        }
    }
}
