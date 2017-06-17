package pool;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by LuoLiBing on 15/6/8.
 */
public class ReaderUtilsTest {

    @Test
    public void poolTest() throws Exception {
        ReaderUtils instance = ReaderUtils.getInstance();
        String str = null;
        try {
            str = instance.readToString(Files.newBufferedReader(Paths.get("/Users/tim/ssh_spider.sh"), Charset.defaultCharset()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
}
