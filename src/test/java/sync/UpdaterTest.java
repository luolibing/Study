package sync;

import org.junit.Test;
import sync.object.Author;
import sync.object.Updater;

/**
 * Created by LuoLiBing on 15/6/13.
 */
public class UpdaterTest {

    @Test
    public void test() {
        Updater.UpdateBuilder builder = new Updater.UpdateBuilder();
        Updater updater = builder.author(new Author()).updateText("test").build();
        System.out.println(updater);
    }

}
