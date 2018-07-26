package com.code.common.tool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 */
public class Base64Util {

    public static String encode(BufferedImage bufferedImage, String imgType) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, imgType, outputStream);
        return encode(outputStream);
    }

    public static String encode(InputStream inputStream) throws IOException {
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();
        return Base64.getEncoder().encodeToString(data);
    }


    public static String encode(ByteArrayOutputStream outputStream) {
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }


    public static BufferedImage decode2Img(String base64) throws IOException {
        byte[] bytes = Base64.getDecoder().decode(base64.getBytes("utf-8"));
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        return ImageIO.read(inputStream);
    }
}
