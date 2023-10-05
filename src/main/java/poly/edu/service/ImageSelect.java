/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.edu.service;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Asus
 */
public class ImageSelect {
    public  static Image resize(Image org , int targetWidth , int targerHeight){
        Image rs = org.getScaledInstance(targetWidth, targerHeight, Image.SCALE_SMOOTH);
        return rs;
    }
    public static byte[] toArrayListImage(Image img ,  String type) throws IOException{
        BufferedImage bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D gr2d = bimg.createGraphics();
        gr2d.drawImage(img, 0, 0, null);
        gr2d.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimg, type, baos);
        byte[] ImageType = baos.toByteArray();
        
        return ImageType;
    }
    public static Image createFromByArrayListImage(byte[] data,String type) throws IOException{
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        BufferedImage bimg2 = ImageIO.read(bais);
        
        
        Image img  = bimg2.getScaledInstance(bimg2.getWidth(), bimg2.getHeight(), Image.SCALE_SMOOTH);
        return img;
    }
}
