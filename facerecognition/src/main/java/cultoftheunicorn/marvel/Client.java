package cultoftheunicorn.marvel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import android.os.AsyncTask;
import android.widget.TextView;

public class Client extends AsyncTask<Void, Void, Void> {

    String dstAddress;
    int dstPort;
    String response = "";
    TextView textResponse;
    String userInfo;
    Client(String addr, int port,TextView textResponse, String userInfo) {
        dstAddress = addr;
        dstPort = port;
        this.textResponse=textResponse;
        this.userInfo = userInfo;
        textResponse.setText("Connected to server");
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        Socket socket = null;

        try{
            socket = new Socket(dstAddress, dstPort);
            ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
           // byte[] buffer = new byte[1024];

            //int byteRead;

            //DataInputStream dis = new DataInputStream(socket.getInputStream());
            //String sendmsg = dis.readUTF();
            try {
                BufferedReader input;
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                Then:
                while (true) {
                    try {
                        response += input.readLine();//Read from server
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

//            InputStream input = socket.getInputStream();
//
//            while ((byteRead = input.read(buffer)) != -1) {
//                output.write(buffer, 0, byteRead);
//                response += output.toString("UTF-8")+"kamal";
//            }
        }catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "IOException: " + e.toString();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }@Override
    protected void onPostExecute(Void result) {
        textResponse.setText(response);
        super.onPostExecute(result);
    }

}

