package upsi.beerup;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
            String  age = sharedPref.getString("age","");

            if (TextUtils.isEmpty(age)) {
                SettingsFragment sf = new SettingsFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, sf);
                transaction.commit();
            }
            else {
                MainFragment mf = new MainFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, mf);
                transaction.commit();
            }
        }
    }
}
