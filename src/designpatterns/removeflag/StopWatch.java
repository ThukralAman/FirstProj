package designpatterns.removeflag;

/**
 * Created by amthukra on 5/13/2019.
 */

public class StopWatch {
    int flag = 0;

    public boolean start()
    {
        if(flag != 0)
            return false;

        //logic
        flag = 1;
        return true;
    }
    public boolean stop()
    {
        if(flag != 1 || flag!= 2)
            return false;

        //logic
        flag = 0;
        return true;
    }
    public boolean pause()
    {
        if(flag != 1)
            return false;

        //logic
        flag = 2;
        return true;
    }
    public boolean resume()
    {
        if(flag != 2)
            return false;

        //logic
        flag = 1;
        return true;
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        sw.start();
        sw.pause();
        sw.resume();
        sw.stop();
    }
}

