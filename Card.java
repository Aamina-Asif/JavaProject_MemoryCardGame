import javax.swing.*;
public class Card extends JButton {
	
	private String id;

    public Card(String id) {
	    this.id=id;
    }
    
    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
}
