package cn.boxfish;

import org.junit.Test;

import java.io.File;

/**
 * Created by LuoLiBing on 15/8/1.
 */
public class FileWatch {

    File basePath = new File("/share");

    @Test
    void fileWatch1() {
       basePath.toPath().register()
    }

}
