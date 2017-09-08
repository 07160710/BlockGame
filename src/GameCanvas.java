import java.awt.*;
import java.awt.event.*;

public class GameCanvas extends Canvas implements KeyListener{
	final int unitSize=30;
	int rowNum;
	int columnNum;
	int maxAllowRowNum;
	int blockInitRow;
	int blockInitCol;
	int [][] scrArr;
	Block b;
	GameCanvas(){
		rowNum=15;
		columnNum=10;
		maxAllowRowNum=rowNum-2;
		b=new Block(this);
		blockInitRow=rowNum-1;
		blockInitCol=columnNum/2-2;
		scrArr=new int [32][32];
	}
	void initScr(){ 
		for(int i=0;i<rowNum;i++){
			for(int j=0;j<columnNum;j++){
				scrArr[i][j]=0;
			}
		}
		b.reset();
		repaint();
	}
	public void paint(Graphics g){
		for(int i=0;i<rowNum;i++){
			for(int j=0;j<columnNum;j++){
				drawUnit(i,j,scrArr[i][j]);
			}
		}
	}
	public void drawUnit(int row,int col,int type){
		scrArr[row][col]=type;
		Graphics g=getGraphics();
		switch(type){
		case 0:g.setColor(Color.black);break;
		case 1:g.setColor(Color.blue);break;
		case 2:g.setColor(Color.magenta);break;
		}
		g.fill3DRect(col*unitSize, getSize().height-(row+1)*unitSize, unitSize, unitSize, true);
		g.dispose();
	}
	public Block getBlock(){
		return b;
	}
	public int getScrArrXY(int row,int col){
		if(row<0||row>=rowNum||col<0||col>=columnNum){
			return(-1);
		}else{
			return(scrArr[row][col]);
		}
	}
	public int getInitRow(){
		return(blockInitRow);
	}
	public int getInitCol(){
		return(blockInitCol);
	}
	void deleteFullLine(){
		int full_line_num=0;
		int k=0;
		for(int i=0;i<rowNum;i++){
			boolean isfull=true;
			L1:for(int j=0;j<columnNum;j++)
				if(scrArr[i][j]==0){
					k++;
					isfull=false;
					break L1;
				}
			if(isfull)
				full_line_num++;
			if(k!=0&&k-1!=i&&!isfull)
				for(int j=0;j<columnNum;j++){
					if(scrArr[i][j]==0)
						drawUnit(k-1,j,0);
					else
						drawUnit(k-1,j,2);
					scrArr[k-1][j]=scrArr[i][j];
				}
		}
		for(int i=k-1;i<rowNum;i++){
			for(int j=0;j<columnNum;j++){
				drawUnit(i,j,0);
				scrArr[i][j]=0;
			}
		}
		ERS_Block.score+=full_line_num;
		ERS_Block.scoreField.setText(""+ERS_Block.score);
	}
	boolean isGameEnd(){
		for(int col=0;col<columnNum;col++){
			if(scrArr[maxAllowRowNum][col]!=0)
				return true;
		}
		return false;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(!ERS_Block.isPlay)
			return;
		switch(e.getKeyCode()){
		case KeyEvent.VK_DOWN:b.fallDown();break;
		case KeyEvent.VK_LEFT:b.leftMove();break;
		case KeyEvent.VK_RIGHT:b.rightMove();break;
		case KeyEvent.VK_SPACE:b.leftTurn();break;
		}
		
	}

}
