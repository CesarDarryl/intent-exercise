package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import id.ac.polinema.intentexercise.Model.User;

import static id.ac.polinema.intentexercise.RegisterActivity.USER_KEY;

public class ProfileActivity extends AppCompatActivity {

    private TextView fullnameText,emailText,homepageText,aboutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Binding
        fullnameText = findViewById(R.id.label_fullname);
        emailText = findViewById(R.id.label_email);
        homepageText = findViewById(R.id.label_homepage);
        aboutText = findViewById(R.id.label_about);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            User data = getIntent().getParcelableExtra(USER_KEY);
            fullnameText.setText(data.getFullname());
            emailText.setText(data.getEmail());
            homepageText.setText(data.getHomepage());
            aboutText.setText(data.getAbout());
        }
    //TO URL
    }

}
