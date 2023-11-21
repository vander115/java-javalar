package view.style;

import java.awt.Font;
import java.awt.FontFormatException;

import java.io.IOException;
import java.io.InputStream;

public class Fonts {
  private static Font importFont(String fontName, int fontSize) {
    try {
      InputStream is = Fonts.class.getResourceAsStream(Paths.FONTS_PATH + fontName);
      Font font = Font.createFont(Font.TRUETYPE_FONT, is);

      return font.deriveFont(Font.PLAIN, fontSize);
    } catch (FontFormatException e) {
      System.err.println("Font not found.");
      return null;
    } catch (IOException e) {
      System.err.println("Font not found.");
      return null;
    }
  }

  public static Font upheavalPro(int fontSize) {
    return importFont("UpheavalPro.ttf", fontSize);
  }
}