package cultoftheunicorn.marvel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
//import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.opencv.cultoftheunicorn.marvel.R;

public class ClientActivity extends AppCompatActivity {
    Button conn,clear;
    EditText ip,port;
    TextView info;
    String valueFromReg,userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        conn = (Button)findViewById(R.id.connectButton);
        ip = (EditText)findViewById(R.id.ipEdit);
        port = (EditText)findViewById(R.id.portEdit);
        info = (TextView)findViewById(R.id.infoText);
        clear = (Button)findViewById(R.id.clearButton);

        try {
            Global g1 = Global.getInstance();
            valueFromReg = g1.getData();
            if(valueFromReg==null)
            {
                Toast.makeText(ClientActivity.this,"YOU ARE NOT REGISTERED",Toast.LENGTH_LONG).show();
            }
            else {
                int ind = valueFromReg.indexOf('+');
                userName = valueFromReg.substring(0, ind);
               // passWord = valueFromReg.substring((ind + 1));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            //Toast.makeText(MainActivity.this,"Error Occured",Toast.LENGTH_LONG).show();
        }

        conn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Client myClient = new Client(ip.getText().toString(), Integer.parseInt(port
                        .getText().toString()), info,userName);
                myClient.execute();
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText("");
            }
        });
    }
}

