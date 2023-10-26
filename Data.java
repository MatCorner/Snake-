package SwingLesson;
import java.net.URL;

import javax.swing.*;
public class Data {

    private static URL headerURL = Data.class.getResource("/statics/header.png");
    public static ImageIcon header = new ImageIcon(headerURL);
    private static URL upURL = Data.class.getResource("/statics/header.png");
    private static URL downURL = Data.class.getResource("/statics/header.png");
    private static URL leftURL = Data.class.getResource("/statics/header.png");
    private static URL rightURL = Data.class.getResource("/statics/header.png");

    public static ImageIcon up = new ImageIcon(headerURL);
    public static ImageIcon down = new ImageIcon(headerURL);
    public static ImageIcon left = new ImageIcon(headerURL);
    public static ImageIcon right = new ImageIcon(headerURL);

    private static URL bodyURL = Data.class.getResource("/statics/header.png");
    private static URL foodURL = Data.class.getResource("/statics/header.png");
    public static ImageIcon body = new ImageIcon(headerURL);
    public static ImageIcon food = new ImageIcon(headerURL);

}
