package SwingLesson;
import javax.swing.*;


public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setBounds(10,10,900,720);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //游戏需要放在面板上
        frame.add(new GamePanel());


        frame.setVisible(true);
    }
}
