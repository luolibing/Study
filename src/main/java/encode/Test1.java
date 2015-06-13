package encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by LuoLiBing on 15/6/10.
 */
public class Test1 {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "want;I want to be a doctor.我想成为一名医生。.jpg";
        str = URLEncoder.encode(str, "UTF-8");
        System.out.println(str);

        str = URLDecoder.decode(str,"UTF-8");
        System.out.println(str);
    }

}
