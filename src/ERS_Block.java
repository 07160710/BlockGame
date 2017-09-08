import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.*;

public class ERS_Block extends JFrame{
	public static boolean isPlay=false;
	public static int level=1,score=0;
	public static TextField scoreField,levelField;
	public static MyTimer timer;
	GameCanvas gameScr;

	public static void main(String[] args) {
		ERS_Block ers=new ERS_Block("俄罗斯方块游戏");
		WindowListener win_listener=new WindowListener();
		ers.addWindowListener(win_listener);
	}
	ERS_Block(String title){
		super(title);
		setSize(600,480); 
		setLayout(new GridLayout(1, 2));
		gameScr=new GameCanvas();
		gameScr.addKeyListener(gameScr);
		timer=new MyTimer(gameScr);
		timer.setDaemon(true);
		timer.start();
		timer.suspend();
		add(gameScr);
		Panel rightScr=new Panel();
		rightScr.setLayout(new GridLayout(2, 1, 0, 30));
		rightScr.setSize(120, 500);
		add(rightScr);
		MyPanel infoScr=new MyPanel();
		infoScr.setLayout(new GridLayout(4, 1, 0, 5));
		infoScr.setSize(120, 300);
		rightScr.add(infoScr);
		
		Label scorep=new Label("分数:", Label.LEFT);
		Label levelp=new Label("级数:", Label.LEFT);
		scoreField=new TextField(8);
		levelField=new TextField(8);
		scoreField.setEditable(false);
		levelField.setEditable(false);
		infoScr.add(scorep);
		infoScr.add(scoreField);
		infoScr.add(levelp);
		infoScr.add(levelField);
		scorep.setSize(new Dimension(20,60));
		scoreField.setSize(new Dimension(20,60));
		levelp.setSize(new Dimension(20,60));
		levelField.setSize(new Dimension(20,60));
		scoreField.setText("0");
		levelField.setText("1");
		
		MyPanel controlScr=new MyPanel();
		controlScr.setLayout(new GridLayout(5, 1, 0, 5));
		rightScr.add(controlScr);
		
		Button play_b=new Button("开始游戏");
		play_b.setSize(new Dimension(50,200));
		play_b.addActionListener(new Command(Command.button_play,gameScr));
		Button level_up_b=new Button("提高级数");
		level_up_b.setSize(new Dimension(50,200));
		level_up_b.addActionListener(new Command(Command.button_levelup,gameScr));
		Button level_down_b=new Button("降低级数");
		level_down_b.setSize(new Dimension(50,200));
    	level_down_b.addActionListener(new Command(Command.button_leveldown,gameScr));
		Button pause_b=new Button("游戏暂停");
		pause_b.setSize(new Dimension(50,200));
		pause_b.addActionListener(new Command(Command.button_pause,gameScr));
		Button quit_b=new Button("退出游戏");
		quit_b.setSize(new Dimension(50,200));
		quit_b.addActionListener(new Command(Command.button_quit,gameScr));
		controlScr.add(play_b);
		controlScr.add(level_up_b);
		controlScr.add(level_down_b);
		controlScr.add(pause_b);
		controlScr.add(quit_b);
		setVisible(true);
		gameScr.requestFocus();		
	}

}
class MyPanel extends JPanel{
	public Insets getInsets(){
		return new Insets(30,50,30,50);
	}
}
