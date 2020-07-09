package lifeGame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class UI extends JFrame{
	public boolean stop = false;
	private JButton startGameBtn = new JButton("开始游戏");
	private JButton pauseGameBtn = new JButton("暂停游戏");
	private JLabel durationPromtLabel = new JLabel("动画间隔设置(s为单位),默认是5秒");
	private JTextField durationTextField = new JTextField();
	private JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
    private JPanel gridPanel = new JPanel();
    private JTextField[][] textMatrix;
    
    /**
     * 动画默认间隔5s
     */
    private static final int DEFAULT_DURATION = 5;

    //动画间隔
    private int duration = DEFAULT_DURATION;
    
    public UI() {
    	setTitle("生命游戏");
    	startGameBtn.addActionListener(new StartGameActioner());
    	pauseGameBtn.addActionListener(new pauseGameActioner());
    	
    	buttonPanel.add(startGameBtn);
    	buttonPanel.add(pauseGameBtn);
    	buttonPanel.add(durationPromtLabel);
    	buttonPanel.add(durationTextField);
    	buttonPanel.setBackground(Color.white);
    	
    	getContentPane().add("North",buttonPanel);
    	
    	this.setSize(900,1000);
    	this.setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	initGridLayout();
    	showMatrix();
    	gridPanel.updateUI();
    }
    private void showMatrix(){

        int[][] matrix = Logic.map.world;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    textMatrix[y][x].setBackground(Color.BLACK);
                } else {
                    textMatrix[y][x].setBackground(Color.WHITE);
                }
            }
        }
    }
    
    private void initGridLayout() {
        int rows = Logic.map.HEIGHT;
        int cols = Logic.map.WIDTH;
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(rows, cols));
        textMatrix = new JTextField[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x		 < cols; x++) {
                JTextField text = new JTextField();
                textMatrix[y][x] = text;
                gridPanel.add(text);
            }
        }
        add("Center", gridPanel);
    }
    
    private class StartGameActioner implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent e) {
        	try {
                duration = Integer.parseInt(durationTextField.getText().trim());
            } catch (NumberFormatException e1) {
                duration = DEFAULT_DURATION;
            }
        	Logic.init();
        	stop=true;
        	startGameBtn.setText("重新开始");
    		stop=false;
			new Thread(new Timer()).start();
        }
    }
    
    private class pauseGameActioner implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(stop){
    			stop=false;
    			new Thread(new Timer()).start();
    			pauseGameBtn.setText("暂停游戏");
    		}
    		else{
    			stop=true;
    			pauseGameBtn.setText("继续游戏");
    		}
    	}
    }
    public class Timer extends Thread {
	    @Override
	    public void run() {
	        while (!stop) {
	            Logic.nextWorld();
	            showMatrix();
	            try {
	                TimeUnit.SECONDS.sleep(duration);
	            } catch (InterruptedException ex) {
	                ex.printStackTrace();
	            }
	        }

	    }
    }
    
}
