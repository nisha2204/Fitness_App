package com.example.fitness_1;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.RelativeLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    //widgets
    private EditText mEmail, mPassword;
    private TextView mRegisterTextView;
    private ProgressBar mProgressBar;
    private RelativeLayout mLoginButton;

    //Firebase Authentication
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail=findViewById(R.id.username);
        mPassword=findViewById(R.id.password);
        mRegisterTextView=findViewById(R.id.register_tv);
        mProgressBar=findViewById(R.id.loading);
        mLoginButton=findViewById(R.id.login);
        mAuth=FirebaseAuth.getInstance();

        //add onclicklistener to login button
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email, password;
                email=mEmail.getText().toString().trim();
                password=mPassword.getText().toString().trim();
                if (!email.equals("")&&!password.equals("")){
                    mProgressBar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //to hide progressbar
                                    mProgressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()){
                                        Intent intent=new Intent(login.this.getApplicationContext(), recoomendation.class);
                                        intent.putExtra("email", email);
                                        startActivity(intent);

                                    }
                                    else{


                                    }
                                }
                            });
                }

            }
        });
        //add onclicklistener to text view
        mRegisterTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when Regiwe click on register page should flip from login to register
                startActivity(new Intent(login.this, register.class));



            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentuser=mAuth.getCurrentUser();
        if (currentuser!=null) {
            Intent intent = new Intent(login.this, recoomendation.class);
            intent.putExtra("email", currentuser.getEmail());
            startActivity(intent);
            finish();

        }
        else{
            Toast.makeText(this,"user not login",Toast.LENGTH_SHORT);
        }
    }



}
