package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import id.ac.polinema.intentexercise.Model.User;

import static id.ac.polinema.intentexercise.RegisterActivity.USER_KEY;

public class ProfileActivity extends AppCompatActivity {

    private static final String IMAGE_KEY = "image";
    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private TextView fullnameText,emailText,homepageText,aboutText;
    private ImageView Gambar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Binding
        fullnameText = findViewById(R.id.label_fullname);
        emailText = findViewById(R.id.label_email);
        homepageText = findViewById(R.id.label_homepage);
        aboutText = findViewById(R.id.label_about);
        Gambar = findViewById(R.id.image_profile);


        User data = getIntent().getParcelableExtra(USER_KEY);
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            try {
                fullnameText.setText(data.getFullname());
                emailText.setText(data.getEmail());
                homepageText.setText(data.getHomepage());
                aboutText.setText(data.getAbout());
                Bitmap Avatar = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getPathImage());
                Gambar.setImageBitmap(Avatar);
            } catch (IOException e){
                Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                Log.e(TAG, e.getMessage());
            }

        }

        }
    //TO URL
    public void visitHomePage(View view) {
        String url = homepageText.getText().toString();
        if(!url.startsWith("http://") && !url.startsWith("https://"))
        {
            url = "http://" + url;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
