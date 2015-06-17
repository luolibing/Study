package sync;

import org.junit.Test;
import sync.locklatch.LocklatchExecution;

/**
 * Created by LuoLiBing on 15/6/17.
 */
public class LockLatchExecutionTest {

    @Test
    public void executeTest() {
        new LocklatchExecution().execute();
    }

}
