import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LoginWindows extends JFrame implements ActionListener{
	
	JLabel jl1,jl2;
	JTextField jtf;
	JPasswordField jpf;
	JButton jb1,jb2;
	JPanel jp1,jp2,jp3;
	
	LoginWindows(){
		super("登录界面");
		jl1=new JLabel("用户名:");
		jtf=new JTextField("黄凯锋");
		jl2=new JLabel("密码:");
		jpf=new JPasswordField("07160710");
		
		jb1=new JButton("登录");
		jb2=new JButton("取消");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
	}
	public void init(){
		this.setSize(380, 270);
		this.setLocation(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 1));
		jp1.add(jl1);
		jp1.add(jtf);
		
		jp2.add(jl2);
		jp2.add(jpf);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		
	}

	public static void main(String[] args) {
		LoginWindows loginwindows=new LoginWindows();
		loginwindows.init();

	}
	@Override
	public void actionPerformed(ActionEvent ee) {
		// TODO Auto-generated method stub
		if(ee.getSource().equals(jb1)){
			String username=jtf.getText();
			String password=jpf.getText();
			if(username.equals("黄凯锋")&&password.equals("07160710")){
				//JOptionPane.showMessageDialog(this,"登录成功","提示",JOptionPane.INFORMATION_MESSAGE);
				LoginWindows.this.setVisible(false);
				ERS_Block game=new ERS_Block(null);
			}else{
				JOptionPane.showMessageDialog(this,"登录失败","警告",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(ee.getSource().equals(jb2)){
			System.exit(0);
		}
		
	}

}
