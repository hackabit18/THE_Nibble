package cultoftheunicorn.marvel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.opencv.cultoftheunicorn.marvel.R;

public class MainActivity extends AppCompatActivity {

    String userName,passWord;
    EditText user,pass;
    Button login,register;
    String valueFromReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Global g1 = Global.getInstance();
            valueFromReg = g1.getData();
            if(valueFromReg==null)
            {
                Toast.makeText(MainActivity.this,"YOU ARE NOT REGISTERED",Toast.LENGTH_LONG).show();
            }
            else {
                int ind = valueFromReg.indexOf('+');
                userName = valueFromReg.substring(0, ind);
                passWord = valueFromReg.substring((ind + 1));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            //Toast.makeText(MainActivity.this,"Error Occured",Toast.LENGTH_LONG).show();
        }

        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        register = (Button)findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = user.getText().toString();
                String pass_word = pass.getText().toString();

                if((userName != null && !userName.trim().isEmpty()) || (passWord != null && !passWord.trim().isEmpty())){

                    if(user_name.equals(userName) && pass_word.equals(passWord))
                    {
                        Intent server = new Intent(MainActivity.this, Recognize.class);
                        startActivity(server);
                        finish();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "WRONG CREDENTIALS, TRY AGAIN!!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "You are not Registered, Please Register First", Toast.LENGTH_LONG).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerActvity = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registerActvity);
                finish();
            }
        });

//        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
//        setSupportActionBar(toolbar);

//        if(getSupportActionBar() != null) {
//            getSupportActionBar().setTitle("DAR");
//        }
//
//        Button recognizeButton = (Button) findViewById(R.id.recognizeButton);
//        Button trainingButton = (Button) findViewById(R.id.trainingButton);
//
//        recognizeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, Recognize.class));
//            }
//        });
//
//        trainingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, NameActivity.class));
//            }
//        });

    }
}
