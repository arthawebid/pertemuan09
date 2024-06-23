package pertemuan09;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
/**
 *
 * @author BCMedia
 */
public class loadIMG {
    public static BufferedImage loadImage(String urlGambar){
        BufferedImage bimg = null;
        try{
            bimg = ImageIO.read(new File(urlGambar) );
        }catch(Exception e){
            
        }
        return bimg;
    }
}
