package pool;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by LuoLiBing on 15/6/8.
 * 对象池
 */
public class ReaderUtils {

    private static ReaderUtils instance;

    /**
     * objectPool对象池
     */
    private ObjectPool<StringBuffer> pool;

    private ReaderUtils(ObjectPool<StringBuffer> pool) {
        this.pool = pool;
    }

    public String readToString(Reader in) throws Exception {
        // 不再new出stringbuffer，直接从pool中获取
        StringBuffer buffer = pool.borrowObject();
        try {
            for(int c = in.read(); c != -1; c = in.read()) {
                buffer.append((char)c);
            }
            return buffer.toString();
        } catch(IOException e) {
            throw e;
        } finally {
            // 对象还给池
            pool.returnObject(buffer);
            try {
                in.close();
            } catch(Exception e) {
                // ignored
            }
        }
    }

    public synchronized static ReaderUtils getInstance() {
        if(instance == null) {
            GenericObjectPool<StringBuffer> pool = new GenericObjectPool<StringBuffer>(new PooledObjectFactoryImpl());
            instance = new ReaderUtils(pool);
        }
        return instance;
    }

}
