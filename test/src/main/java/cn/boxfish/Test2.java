package cn.boxfish;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by LuoLiBing on 15/8/3.
 */
public class Test2 {

    @Test
    public void test() {
        String[] arr = "/share/视频/图片//".split("/");
        System.out.println(arr[arr.length-1]);
    }

    @Test
    public void testPath() {
        Path path = Paths.get("/share");
        System.out.println(path);
    }

}
