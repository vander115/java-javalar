package controller.tools;

import javax.swing.ImageIcon;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

public class Utils {

  public static String getPlanetName(int index) {
    switch (index) {
      case 1:
        return "Python";
      case 2:
        return "JavaScript";
      case 3:
        return "Ruby On Rails";
      case 4:
        return "PHP";
      case 5:
        return "C#";
      case 6:
        return "C++";
      case 7:
        return "C";
      default:
        return null;
    }
  }

  public static ImageIcon convertIconToGrayScale(ImageIcon icon) {
    BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = (Graphics2D) image.getGraphics();
    g2d.drawImage(icon.getImage(), 0, 0, null);
    ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
    op.filter(image, image);
    icon = new ImageIcon(image);
    return icon;
  }

  public static ImageIcon resizeImage(ImageIcon icon, int width, int height) {
    Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    return new ImageIcon(image);
  }

}