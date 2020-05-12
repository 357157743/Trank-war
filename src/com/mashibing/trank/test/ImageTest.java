package com.mashibing.trank.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** 图片
 * @date 2020/4/22 - 13:53
 */

@RunWith(JUnit4.class)
public class ImageTest {
    @Test
    public void test() {

        try {
            // BufferedImage image = ImageIO.read(new File("src/images/bulletD.gif"));
            BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            Assert.assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* public ImageTest() {

    }*/
}
