package pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * Created by LuoLiBing on 15/6/8.
 */
public class PooledObjectFactoryImpl extends BasePooledObjectFactory {
    @Override
    public Object create() throws Exception {
        return new StringBuffer(100);
    }

    @Override
    public PooledObject wrap(Object obj) {
        return new DefaultPooledObject(obj);
    }
}
