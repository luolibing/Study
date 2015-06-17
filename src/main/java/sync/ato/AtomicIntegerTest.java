package sync.ato;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by LuoLiBing on 15/6/13.
 */
public class AtomicIntegerTest implements Runnable {

    private final static AtomicInteger atomicInteger = new AtomicInteger(0);

    public void nextId() {
        System.out.println(atomicInteger.getAndIncrement());
    }

    public void run() {
        for(int i=0; i<100; i++)
            nextId();
    }
}
