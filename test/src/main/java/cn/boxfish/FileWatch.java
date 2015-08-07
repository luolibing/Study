package cn.boxfish;

import org.junit.Test;

import java.io.IOException;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.*;

/**
 * Created by LuoLiBing on 15/8/1.
 */
public class FileWatch {

    Path basePath = Paths.get("/share/watch");

    @Test
    public void fileWatch1() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        WatchKey key = basePath.register(watchService, ENTRY_MODIFY);
        boolean shutdown = false;

        while(!shutdown) {
            key = watchService.take();
            for(WatchEvent event:key.pollEvents()) {
                final Path target = (Path) event.context();
                System.out.println(target.toFile().getPath());
                System.out.println(event.kind().name());
            }
            key.reset();

        }
    }


    @Test
    public void fileWatch2() {

    }

}
