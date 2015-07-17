package cn.boxfish.jgit.test.utils;

import java.io.File;

/**
 * Created by LuoLiBing on 15/7/8.
 */
public class FileUtils {

    public static File getClassPathFile(String path) {
        return new File(FileUtils.class.getClassLoader().getResource(path).getFile());
    }

}
