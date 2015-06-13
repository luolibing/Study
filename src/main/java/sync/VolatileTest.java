package sync;

/**
 * Created by LuoLiBing on 15/6/13.
 */
public class VolatileTest implements Runnable {

    private static volatile Integer id = 0;

    public int nextId() {
        return id++;
    }

    public void run() {
        System.out.println(nextId());
    }
}
