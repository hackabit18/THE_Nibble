package com.example.aj.dar;

import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.util.Patterns;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText edName, edEmail, edPassword, edDepartment;
    Button btnReg;
    TextView tvName, tvEmail, tvPassword;
//    FirebaseAuth mAuth;
//    DatabaseReference databaseTeachers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tvName = (TextView) findViewById(R.id.tvName1);
        tvEmail = (TextView) findViewById(R.id.tvName2);
        tvPassword = (TextView) findViewById(R.id.tvName3);
        edName = (EditText) findViewById(R.id.editName);
        edEmail = (EditText) findViewById(R.id.editEmail);
        edPassword = (EditText) findViewById(R.id.editPassword);
        edDepartment = (EditText) findViewById(R.id.editDepartment);
        btnReg = (Button) findViewById(R.id.buttonRegister);
    //    mAuth = FirebaseAuth.getInstance();
      //  databaseTeachers = FirebaseDatabase.getInstance().getReference();

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edName.getText().toString().isEmpty()) {
                    edName.setError("Name required");
                    edName.requestFocus();
                    return;
                }
                if (edEmail.getText().toString().isEmpty()) {
                    edEmail.setError("Email required");
                    edEmail.requestFocus();
                    return;
                }
                if (edPassword.getText().toString().isEmpty()) {
                    edPassword.setError("Password required");
                    edPassword.requestFocus();
                    return;
                }
                if (edDepartment.getText().toString().isEmpty()) {
                    edDepartment.setError("Department required");
                    edDepartment.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(edEmail.getText().toString()).matches()) {
                    edEmail.setError("Enter valid email");
                    edEmail.requestFocus();
                    return;
                }
                if (edPassword.getText().toString().length() < 6) {
                    edPassword.setError("Minimum length of password required is 6");
                    edPassword.requestFocus();
                    return;
                }

//                mAuth.createUserWithEmailAndPassword(edEmail.getText().toString(), edPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
//                            startActivity(intent);
//                            finish();
//                        } else {
//                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });


//                FirebaseAuth auth = FirebaseAuth.getInstance();
//                FirebaseUser user = auth.getCurrentUser();
//
//                user.sendEmailVerification()
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()) {
//                                    Log.d(TAG, "Email sent.");
//                                }
//                            }
//                        });

                //addUser();


                //Registration Data without Firebase
                String userName = edEmail.getText().toString();
                String passWord = edPassword.getText().toString();
                String valueToSend = userName+"+"+passWord;
                Toast.makeText(RegisterActivity.this,""+valueToSend+"",Toast.LENGTH_LONG).show();
                //((Mygolbalapp) get).setSomeVariable();

                Global g=Global.getInstance();
                g.setData(valueToSend);

                Intent loginActivity = new Intent(RegisterActivity.this, MainActivity.class);
               // Bundle bundle = new Bundle();
               // bundle.putString("USERNAME",edEmail.getText().toString() );
                //bundle.putString("PASSWORD",edPassword.getText().toString());

                //loginActivity.putExtra("valueReceived",valueToSend);

                startActivity(loginActivity);

            }
        });
    }

//    private void addUser() {
//        String name = edName.getText().toString().trim();
//        String email = edEmail.getText().toString().trim();
//        String password = edPassword.getText().toString().trim();
//        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
//            String id = databaseTeachers.push().getKey();
//            User user = new User(id, name, email, password);
//            databaseTeachers.child(id).setValue(user);
//            Toast.makeText(this, "User added", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(this, "Fill details", Toast.LENGTH_LONG).show();
//        }
//    }
}


