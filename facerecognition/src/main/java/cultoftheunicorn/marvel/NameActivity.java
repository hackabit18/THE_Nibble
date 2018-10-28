package cultoftheunicorn.marvel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.opencv.cultoftheunicorn.marvel.R;

public class NameActivity extends AppCompatActivity {

    String valueFromReg,userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        try {
            Global g1 = Global.getInstance();
            valueFromReg = g1.getData1();
            if(valueFromReg==null)
            {
                //Toast.makeText(NameActivity.this,"YOU ARE NOT REGISTERED",Toast.LENGTH_LONG).show();
            }
            else {
                int ind = valueFromReg.indexOf('+');
                userId = valueFromReg;
                //passWord = valueFromReg.substring((ind + 1));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            //Toast.makeText(MainActivity.this,"Error Occured",Toast.LENGTH_LONG).show();
        }

        final EditText name = (EditText) findViewById(R.id.name);
        Button nextButton = (Button) findViewById(R.id.nextButton);

        name.setText(userId);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.getText().toString().equals("")) {
                    Intent intent = new Intent(NameActivity.this, Training.class);
                    intent.putExtra("name", name.getText().toString().trim());
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(NameActivity.this, "Please enter the name", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
