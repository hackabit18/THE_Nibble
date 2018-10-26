package com.example.aj.dar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public abstract class ServerActivity extends AppCompatActivity implements View.OnClickListener {

    Server server;
    EditText sub,branch;
    TextView ipPort,message;
    Button startServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        sub = (EditText)findViewById(R.id.subText);
        branch = (EditText)findViewById(R.id.branchInfo);
        startServer = (Button)findViewById(R.id.startServer);
        ipPort = (TextView)findViewById(R.id.serverIp);
        message = (TextView)findViewById(R.id.message);

        startServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server = new Server(this);
                ipPort.setText("IP : PORT :"+server.getIpAddress()+" : "+server.getPort());
                //port.setText("PORT : "+server.getPort());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        server.onDestroy();
    }

}
