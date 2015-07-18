package cn.boxfish.test;

import cn.boxfish.tika.utils.FfmpegUtils;
import com.beust.jcommander.internal.Maps;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Created by LuoLiBing on 15/7/18.
 */
public class FfmpegUtilsTest {


    @Test
    public void checkTest() {
        assert FfmpegUtils.check();
    }

    @Test
    public void transferFileToTargetPath() throws TikaException, IOException, SAXException {
        String classPath = this.getClass().getClassLoader().getResource("").getPath();
        FfmpegUtils.transferFileToTargetPath(classPath+ "5虎克显微镜invent.m4v", classPath + "5虎克显微镜invent_output.mp4");
        assert Files.exists(Paths.get(classPath + "5虎克显微镜invent_output.mp4"));
    }


    @Test
    public void transferFileToTargetType() throws TikaException, IOException, SAXException {
        String classPath = this.getClass().getClassLoader().getResource("").getPath();
        FfmpegUtils.transferFileToTargetType(classPath + "原始人家族猎早餐记.m4v", "mov");
        assert Files.exists(Paths.get(classPath + "原始人家族猎早餐记.mov"));
    }

    @Test
    public void getFileMetadata() throws TikaException, IOException, SAXException {
        String classPath = this.getClass().getClassLoader().getResource("").getPath();
        Metadata fileMetadata = FfmpegUtils.getFileMetadata("/Users/boxfish/Downloads/马达加斯加动物园的一天-quicktime.mov");

        Map<String, String> metaMap = Maps.newHashMap();
        for (String tikaKey : fileMetadata.names())
        {
            metaMap.put(tikaKey, metaMap.get(tikaKey));
        }
        System.out.println(metaMap);
    }

}
