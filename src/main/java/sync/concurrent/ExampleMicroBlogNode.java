package sync.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by LuoLiBing on 15/6/17.
 */
public class ExampleMicroBlogNode {

    private final ConcurrentHashMap<Updater, Long> arrivalTime = new ConcurrentHashMap<Updater, Long>();

    public void propagateUpdate(Updater updater) {
        arrivalTime.putIfAbsent(updater, System.currentTimeMillis());
    }

    public boolean confirmUpdaterRecived(Updater updater) {
        return arrivalTime.get(updater)!=null;
    }

}

class Updater {

}
