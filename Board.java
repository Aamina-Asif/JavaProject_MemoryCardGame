import java.awt.*;  //for grid layout and Color
import java.awt.event.*;  //for event handling
import javax.swing.*;  //GUI (Frame, timer, JTextField, JLabel, ProgressBar, ImageIcon, Icon)

import java.util.ArrayList;
import java.util.List;
import java.util.Collections; //for shuffle function

public class Board{
	
	    List<Card> cards = new ArrayList<Card>();
    	Card selectedCard;
    	Card c1;
    	Card c2;
    
    	JFrame frame;
    	Timer mainTimer, flipTimer;
    	JTextField ct1 = new JTextField("0"); // display cards turn count
    	JTextField mc1 = new JTextField("0"); // display matched cards count
    	JTextField rc1 = new JTextField("24"); // display remaining cards count
    	JTextField sc1 = new JTextField("00"); // display score count
    	int count=0, remaining = 24, matched = 0, score=0;
    	JProgressBar pb = new JProgressBar(SwingConstants.VERTICAL, 0, 75);
    	Icon in = new ImageIcon("E:\\images\\icon.PNG") ;

    
    	public Board(){
    		mainTimer = new Timer(980, new ActionListener()  // anonymous inner class method
    	{
        	public void actionPerformed(ActionEvent ae)
        	{
        		if(pb.getValue()<75)
        		{  pb.setValue(pb.getValue()+1);  }
        		else
        		{   JOptionPane.showMessageDialog(frame, "Time's UP, YOU LOOSE!");
        			System.exit(0);  }
        	}
    	});
    	mainTimer.start();
    	
    	JFrame frame=new JFrame("Memory Card Match");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel(new GridLayout(4,6));
		JLabel ct = new JLabel("No. of Cards Turned: "); // cards turn count
    	ct.setBounds(75,660,122,50);
    	JLabel mc = new JLabel("Matched Cards: "); // matched cards count
    	mc.setBounds(356,660,115,50);
    	JLabel rc = new JLabel("Remaining Cards: "); // remaining cards count
    	rc.setBounds(601,660,115,50);
    	JLabel sc = new JLabel("Score: "); // score count
        sc.setBounds(859,660,115,50);
        
        List<String> pathList = new ArrayList<String>();
        List<String> id = new ArrayList<String>();
    	
        for(int i=11; i<=22; i++) {   
        	pathList.add("E:\\images\\"+i+".PNG");  }
        // bcoz we are extracting id from image path which is of String type
		for(int i=0; i<pathList.size(); i++)
		{	id.add(pathList.get(i).substring(10, 12));
			id.add(pathList.get(i).substring(10, 12));  }
		Collections.shuffle(id);
		
        for (String ID : id)
        {
            Card c = new Card(ID);
            c.setIcon(in);
            c.addActionListener(new ActionListener(){ 
            	public void actionPerformed(ActionEvent ae)
                {  selectedCard = c;
                   flipCard();  }
            });
            cards.add(c);
        }
        for (Card c : cards) //enhanced for loop for adding buttons in panel
        {
            panel.add(c);
        }
        
        //set up the flip card timer
        flipTimer = new Timer(500, new ActionListener(){
        	public void actionPerformed(ActionEvent ae)
            { checkCards(); }
        });
        flipTimer.setRepeats(false); //If flag is false , instructs the Timer to send only one action event to its listeners.

       
        ct1.setBounds(199,673,25,25);
        ct1.setEditable(false);
        ct1.setHorizontalAlignment(JTextField.CENTER);
		ct1.setBackground(Color.white);
        mc1.setBounds(449,673,25,25);
        mc1.setEditable(false);
        mc1.setHorizontalAlignment(JTextField.CENTER);
		mc1.setBackground(Color.white);
		rc1.setBounds(706,673,25,25);
        rc1.setEditable(false);
		rc1.setHorizontalAlignment(JTextField.CENTER);
		rc1.setBackground(Color.white);
		sc1.setBounds(900,673,25,25);
		sc1.setEditable(false);
		sc1.setHorizontalAlignment(JTextField.CENTER);
		sc1.setBackground(Color.white);
        frame.add(panel);
        pb.setForeground(Color.lightGray);
        pb.setBackground(Color.DARK_GRAY);
        pb.setBounds(988,5,30,645);
        pb.setString(" T.I.M.E.R");
        pb.setStringPainted(true);
        frame.add(pb);
        frame.add(ct);
        frame.add(ct1);
        frame.add(mc);
        frame.add(mc1);
        frame.add(rc);
        frame.add(rc1);
        frame.add(sc);
        frame.add(sc1);
		panel.setBounds(0,0,983,655);
		frame.setSize(1041,750);
		frame.setLayout(null);
		frame.setVisible(true);
    }

    public void flipCard(){
        if (c1 == null && c2 == null){
            c1 = selectedCard;
            if(c1.getId().matches("11"))
            	c1.setIcon(new ImageIcon("E:\\images\\11.PNG"));
            else if(c1.getId().matches("12"))
            	c1.setIcon(new ImageIcon("E:\\images\\12.PNG"));
            else if(c1.getId().matches("13"))
            	c1.setIcon(new ImageIcon("E:\\images\\13.PNG"));
            else if(c1.getId().matches("14"))
            	c1.setIcon(new ImageIcon("E:\\images\\14.PNG"));
            else if(c1.getId().matches("15"))
            	c1.setIcon(new ImageIcon("E:\\images\\15.PNG"));
            else if(c1.getId().matches("16"))
            	c1.setIcon(new ImageIcon("E:\\images\\16.PNG"));
            else if(c1.getId().matches("17"))
            	c1.setIcon(new ImageIcon("E:\\images\\17.PNG"));
            else if(c1.getId().matches("18"))
            	c1.setIcon(new ImageIcon("E:\\images\\18.PNG"));
            else if(c1.getId().matches("19"))
            	c1.setIcon(new ImageIcon("E:\\images\\19.PNG"));
            else if(c1.getId().matches("20"))
            	c1.setIcon(new ImageIcon("E:\\images\\20.PNG"));
            else if(c1.getId().matches("21"))
            	c1.setIcon(new ImageIcon("E:\\images\\21.PNG"));
            else if(c1.getId().matches("22"))
            	c1.setIcon(new ImageIcon("E:\\images\\22.PNG"));
        }

        if (c1 != null && c1 != selectedCard && c2 == null)
        {
            c2 = selectedCard;
            if(c2.getId().matches("11"))
            	c2.setIcon(new ImageIcon("E:\\images\\11.PNG"));
            else if(c2.getId().matches("12"))
            	c2.setIcon(new ImageIcon("E:\\images\\12.PNG"));
            else if(c2.getId().matches("13"))
            	c2.setIcon(new ImageIcon("E:\\images\\13.PNG"));
            else if(c2.getId().matches("14"))
            	c2.setIcon(new ImageIcon("E:\\images\\14.PNG"));
            else if(c2.getId().matches("15"))
            	c2.setIcon(new ImageIcon("E:\\images\\15.PNG"));
            else if(c2.getId().matches("16"))
            	c2.setIcon(new ImageIcon("E:\\images\\16.PNG"));
            else if(c2.getId().matches("17"))
            	c2.setIcon(new ImageIcon("E:\\images\\17.PNG"));
            else if(c2.getId().matches("18"))
            	c2.setIcon(new ImageIcon("E:\\images\\18.PNG"));
            else if(c2.getId().matches("19"))
            	c2.setIcon(new ImageIcon("E:\\images\\19.PNG"));
            else if(c2.getId().matches("20"))
            	c2.setIcon(new ImageIcon("E:\\images\\20.PNG"));
            else if(c2.getId().matches("21"))
            	c2.setIcon(new ImageIcon("E:\\images\\21.PNG"));
            else if(c2.getId().matches("22"))
            	c2.setIcon(new ImageIcon("E:\\images\\22.PNG"));
            flipTimer.start();
        }
        count++;
        ct1.setText(String.valueOf(count));
    }
    
    public void checkCards(){
        if (c1.getId().matches(c2.getId())){
            c1.setEnabled(false); 
            c2.setEnabled(false);
            matched = matched+2;
            remaining = remaining-2;
            score = score+10;
            mc1.setText(String.valueOf(matched));
            rc1.setText(String.valueOf(remaining));
            sc1.setText(String.valueOf(score));
            if (isGameWon()){
            	mainTimer.stop();
                JOptionPane.showMessageDialog(frame, "Congratulations, YOU WON!");
                System.exit(0);
            }
        }
        else
        {
        	c1.setIcon(in); 
        	c2.setIcon(in);
        }
        c1 = null; 
        c2 = null;
    }

    public boolean isGameWon(){
    	if(matched==24 && remaining==0)
    		return true;
    	else 
    		return false;
    }
    
    public static void main(String[] args){
    	new Board();
    }   
}