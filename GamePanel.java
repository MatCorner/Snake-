package SwingLesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    //定义蛇的结构
    int length;
    int[] snakeX = new int[600];//蛇的X坐标
    int[] snakeY = new int[500];//蛇的y坐标
    //初始方向
    String fx;
    //食物的坐标
    int foodx;
    int foody;
    Random random = new Random();
    //游戏当前的状态
    boolean isStart=false;
    boolean isFail= false;
    //定时器
    Timer timer = new Timer(100,this);
    int score;


    public GamePanel(){
        init();
        //获得焦点和键盘事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    public void init(){
        length = 3;
        snakeX[0]=100;snakeY[0]=100;
        snakeX[1]=75;snakeY[1]=100;
        snakeX[2]=50;snakeY[2]=100;
        fx="R";
        //食物随机分布界面
        foodx = 25+25*random.nextInt(34);
        foody = 75+25*random.nextInt(24);
        score=0;
    }




    //绘制面板
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);//清屏
        this.setBackground(Color.BLACK);
        Data.header.paintIcon(this,g,25,11);//画到当前面板当前画笔头部广告栏
        g.fillRect(25,75,850,600); //默认的游戏界面

        //画积分
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,10));
        g.drawString("length"+length,750,35);
        g.drawString("score"+score,750,50);
        if(fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        else if(fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        else if(fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        for(int i=1; i<length;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        Data.food.paintIcon(this,g,foodx,foody);

        if(isStart==false){
            g.setColor(Color.WHITE);
            g.setFont(new Font(Font.SERIF,Font.BOLD,40));
            g.drawString("Start Game",300,300);
        }
        if(isFail){
            g.setColor(Color.WHITE);
            g.setFont(new Font(Font.SERIF,Font.BOLD,40));
            g.drawString("Start Again",300,300);
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
    //键盘监听事件
    @Override
    public void keyPressed(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        if(KeyCode==KeyEvent.VK_SPACE){
            if(isFail){
                //重新开始
                isFail = false;
                init();
            }
            else{
            isStart=!isStart;
            repaint();}
        }
        //小蛇移动
        if(KeyCode==KeyEvent.VK_UP){
            fx = "U";
        }
        else if(KeyCode==KeyEvent.VK_RIGHT){
            fx = "R";
        }
        else if(KeyCode==KeyEvent.VK_DOWN){
            fx = "D";
        }
        else if(KeyCode==KeyEvent.VK_LEFT){
            fx = "L";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //事件监听 通过固定时间来刷新
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart && isFail==false){
            //吃食物
            score++;
            if(snakeX[0]==foodx&&snakeY[0]==foody){
                length++;
                //再次随机食物
                foodx = 25+25*random.nextInt(34);
                foody = 75+25*random.nextInt(24);
            }
            //移动
            for(int i=length-1;i>0;i--){
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            //走向
            if(fx.equals("R")){
                snakeX[0]=snakeX[0]+25;
            //边界判断
                if(snakeX[0]>850){
                    snakeX[0]=25;
            }}

            else if(fx.equals("L")){
                snakeX[0]=snakeX[0]-25;
                if(snakeX[0]<25){
                    snakeX[0]=850;
                }
            }
            else if(fx.equals("U")){
                snakeY[0]=snakeY[0]-25;
                if (snakeY[0]<75){
                    snakeY[0]=650;
                }
            }
            else if(fx.equals("D")){
                snakeY[0]=snakeY[0]+25;
                if (snakeY[0]>650){
                    snakeY[0]=75;
                }
            }
            //失败判定
            for(int i=1;i<length;i++){
                if(snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]){
                    isFail=true;
                }
            }
            repaint();
        }
        timer.start();
    }
}
