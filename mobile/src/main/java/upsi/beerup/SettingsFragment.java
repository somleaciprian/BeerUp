package upsi.beerup;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener {
    EditText age;
    EditText weight;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        age = (EditText) view.findViewById(R.id.age);
        weight = (EditText) view.findViewById(R.id.weight);
        Button save = (Button) view.findViewById(R.id.button);
        save.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                // save the data
                sharedPref = this.getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);
                editor = sharedPref.edit();
                editor.putString("age", age.getText().toString());
                editor.putString("weight", weight.getText().toString());
                editor.commit();
                // open main fragment
                MainFragment mf = new MainFragment();
                FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, mf);
                transaction.commit();
                break;
        }
    }
}
