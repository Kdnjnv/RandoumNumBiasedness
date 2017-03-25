import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.Scrollbar;

public class RandomCheck {

	private JFrame frame;
	private JTextField textField;
	private TextArea textArea_1 = new TextArea("Numbers will be shown here");
	private TextArea textArea_2,textArea_3,textArea_4,textArea_5;
	int count=-1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomCheck window = new RandomCheck();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RandomCheck() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 240, 245));
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Max freq of random number");
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.BLUE);
		frame.setTitle("Random Frequency");
		JButton gen = new JButton("Generate");
		gen.setBackground(Color.BLUE);
		gen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num;
				int ans=0,max;
				++count;
				int[] finalrand = new int[10000];
				int[] arr = new int[10000];
				for(int i=0;i<10000;i++){
					finalrand[i]=0;
				}
				for(int i=0;i<1000;++i){
					//outer loop runs 1000 times to find most frequency number 1000 times
					max=0;
					for(int j=1000;j<10000;++j){
						arr[j]=0;
					}
					for(int j=0;j<100000;++j){
						num=(int)(Math.random()*10000);
						while(num<1000) num=(int)(Math.random()*10000);
						++arr[num];
						if(arr[num]>max) max=arr[num];
					}
					//System.out.println(max);
					int cd=10;
					while(cd>0){
					for(int j=9999;j>999;--j){
						 if(cd==0) break;
						  if(arr[j]==max){
						  --cd;
							  finalrand[j]+=arr[j];
							  if(finalrand[j]>ans) ans=finalrand[j];
							  //System.out.print("max"+max);
						  }
					}	--max;
					}
				}
				//System.out.println("hye");
				int c=0;
				String s="";
				//System.out.println("dd"+ans+"\n");
				while(c<10){
					for(int j=9999;j>999;--j){
						if(c==10) break;
						if(finalrand[j]==ans){
							 s+=Integer.toString(j) + "\n";++c;
							//System.out.println(ans+" "); 
						}
					}
					--ans;
					//System.out.print("in while\n");
				}
				//System.out.print("after while");
				Font font=new Font("courier",Font.BOLD, 18);
				textArea_1.setFont(font);
				textArea_2.setFont(font);
				textArea_3.setFont(font);
				textArea_4.setFont(font);
				textArea_5.setFont(font);
				textField.setFont(font);
				textField.setText(Integer.toString(ans));
				if(count%5==0) textArea_1.setText(s);
				else if(count%5==1) textArea_2.setText(s);
				else if(count%5==2) textArea_3.setText(s);
				else if(count%5==3) textArea_4.setText(s);
				else if(count%5==4) textArea_5.setText(s);
				//System.out.println("after while");
				
			}
		});
		gen.setForeground(Color.RED);
		gen.setFont(new Font("Tahoma", Font.BOLD, 30));
		gen.setBounds(400, 19, 207, 92);
		frame.getContentPane().add(gen);
		
		textField = new JTextField();
		textField.setBackground(Color.PINK);
		textField.setBounds(122, 122, 170, 42);
		frame.getContentPane().add(textField);
		textField.setColumns(1);
		
		JLabel lblNewLabel = new JLabel("MaxFreq");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(24, 125, 86, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numbers");
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(12, 247, 107, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		textArea_1.setBounds(122, 169, 172, 250);
		frame.getContentPane().add(textArea_1);
		textArea_2=new TextArea("");
		textArea_2.setBounds(300, 169, 150, 250);
		frame.getContentPane().add(textArea_2);
		textArea_3=new TextArea("");
		textArea_3.setBounds(460, 169, 150, 250);
		frame.getContentPane().add(textArea_3);
		textArea_4=new TextArea("");
		textArea_4.setBounds(620, 169, 150, 250);
		frame.getContentPane().add(textArea_4);
		textArea_5=new TextArea("");
		textArea_5.setBounds(780, 169, 150, 250);
		frame.getContentPane().add(textArea_5);
		
		textArea_1.setBackground(new Color(173, 216, 230));
		textArea_2.setBackground(new Color(173, 216, 230));
		textArea_3.setBackground(new Color(173, 216, 230));
		textArea_4.setBackground(new Color(173, 216, 230));
		textArea_5.setBackground(new Color(173, 216, 230));
	}
}