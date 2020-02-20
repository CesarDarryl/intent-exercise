package id.ac.polinema.intentexercise;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.polinema.intentexercise.Model.User;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALERY_REQUEST_CODE = 1;

    //Create KEY : about me, fullname, email, homepage
    public static final String USER_KEY = "user";
    private TextView fullNameText,emailText,passwordText,conf_passwordText,homePageText,aboutText;

    //END
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //this place for binding
        fullNameText = findViewById(R.id.text_fullname);
        emailText = findViewById(R.id.text_email);
        passwordText = findViewById(R.id.text_password);
        conf_passwordText = findViewById(R.id.text_confirm_password);
        homePageText = findViewById(R.id.text_homepage);
        aboutText = findViewById(R.id.text_about);
    }

    public void handleChangeAvatar(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALERY_REQUEST_CODE);
    }

    public void handleSubmit(View view) {
        //
        String fullname = fullNameText.getText().toString();
        String email = emailText.getText().toString();
        String homePage = homePageText.getText().toString();
        String about = aboutText.getText().toString();
        String password = passwordText.getText().toString();
        String conf_password = conf_passwordText.getText().toString();

        User user = new User(fullname,email,homePage,about);
        Intent intent = new Intent(this,ProfileActivity.class);
        //Confirmation Password
        if (!fullname.equals("") && !email.equals("") && !homePage.equals("") && !about.equals(""))
        {
            if(password.equals(conf_password))
            {
                intent.putExtra(USER_KEY,user);
                startActivity(intent);
            }else
                {
                    Toast.makeText(this, "Password Tidak Sama", Toast.LENGTH_SHORT).show();
                }
        }else
            {
                Toast.makeText(this,"Silahkan isi Data diri dengan lengkap",Toast.LENGTH_SHORT).show();
            }
    }
}
