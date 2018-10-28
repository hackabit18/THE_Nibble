package cultoftheunicorn.marvel;

/**
 * Created by KAMAL NAYAN on 27-10-2018.
 */

public class Global {
    private static Global instance;

    // Global variable
    private String data,data1;

    // Restrict the constructor from being instantiated
    private Global(){}

    public void setData(String d){
        this.data=d;

    }
    public void setData1(String d1)
    {
        this.data1=d1;
    }
    public String getData(){
        return this.data;

    }
    public String getData1(){
        return this.data1;

    }

    public static synchronized Global getInstance(){
        if(instance==null){
            instance=new Global();
        }
        return instance;
    }
}

