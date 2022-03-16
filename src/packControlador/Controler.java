package packControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnB1)){
			System.out.println("Click1!");
		}
		if (e.getSource().equals(btnB2)){
			System.out.println("Click2!");
		}
	}
}