package sync;

import org.junit.Test;

/**
 * Created by LuoLiBing on 15/6/13.
 */
public class VolatileT {

    @Test
    public void nextIdTest() {
        for(int i=0; i<100; i++) {
            Thread th = new Thread(new VolatileTest());
            th.start();
        }
    }

}
