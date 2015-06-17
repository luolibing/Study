package sync;

import org.junit.Test;
import sync.ato.AtomicIntegerTest;

/**
 * Created by LuoLiBing on 15/6/13.
 */
public class AtomicIntTest {

    @Test
    public void test() {
        for(int i=0; i<2; i++) {
            Thread th = new Thread(new AtomicIntegerTest());
            th.start();
        }
    }

}
