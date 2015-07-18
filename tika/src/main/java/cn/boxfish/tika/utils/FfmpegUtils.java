package cn.boxfish.tika.utils;

import cn.boxfish.tika.ffmepeg.TikaIntrinsicAVFfmpegParserFactory;
import cn.boxfish.tika.metadata.PBCore;
import cn.boxfish.tika.parser.FfmpegExternalParser;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.ToTextContentHandler;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by LuoLiBing on 15/7/18.
 */
public class FfmpegUtils {

    private final static String FFMPEG_COMMAND = "ffmpeg";


    public static boolean check() {
        return FfmpegExternalParser.check(FFMPEG_COMMAND + " -version", 136, 137);
    }


    public static void transferFileToTargetPath(String srcPath, String targetPath) throws IOException, TikaException, SAXException {
        Parser parser = getTransferParser(srcPath, targetPath);
        try {
            parser.parse(
                    Files.newInputStream(Paths.get(srcPath)),
                    new ToTextContentHandler(),
                    new Metadata(),
                    new ParseContext());
        } finally {
            parser = null;
        }
    }


    public static void transferFileToTargetType(String srcPath, String extName) throws TikaException, IOException, SAXException {
        String targetPath = srcPath.substring(0, srcPath.lastIndexOf(".") + 1) + extName;
        transferFileToTargetPath(srcPath, targetPath);
    }


    public static Metadata getFileMetadata(String srcPath) throws IOException, TikaException, SAXException {

        Metadata result = new Metadata();
        Parser parser = getMetadataParser(srcPath);
        try {
            parser.parse(
                    Files.newInputStream(Paths.get(srcPath)),
                    new ToTextContentHandler(),
                    result,
                    new ParseContext());
            return result;
        } finally {
            parser = null;
        }
    }


    public static boolean checkEnableVideo(String srcPath) throws TikaException, IOException, SAXException {
        Metadata fileMetadata = getFileMetadata(srcPath);
        return "h264".equalsIgnoreCase(fileMetadata.get(PBCore.ESSENCE_TRACK_ENCODING(1)))
                && "VIDEO".equalsIgnoreCase(fileMetadata.get(PBCore.ESSENCE_TRACK_TYPE(1)));
    }


    private static Parser getTransferParser(String srcPath, String targetPath) {
        FfmpegExternalParser parser = getParser();
        parser.setCommand(String.format("%s -i %s %s", FFMPEG_COMMAND, srcPath, targetPath));
        parser.setCommand(String.format("%s", FFMPEG_COMMAND));
        return parser;
    }


    private static Parser getMetadataParser(String srcPath) {
        FfmpegExternalParser parser = getParser();
        parser.setCommand(String.format("%s -i %s", FFMPEG_COMMAND, srcPath));
        return parser;
    }


    private static FfmpegExternalParser getParser() {
        return TikaIntrinsicAVFfmpegParserFactory.createDefaultInstance();
    }

}
