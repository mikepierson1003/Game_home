package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameGUI extends JFrame implements ActionListener {

	public JTextArea area;
	private JPanel panel;
	private JLabel label;
	private JTextField text;
	private JButton button;

	public GameGUI() {
		buildWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String s = text.getText();
		Game.processCommand(s);
	}

	private void buildWindow() {
		setTitle("Undure Pressure");
		setLayout(new BorderLayout());
		
		area = new JTextArea();
		panel = new JPanel(new GridLayout(3,1));
		label = new JLabel("What would you like to do?");
		text = new JTextField();
		button = new JButton("Execute");
		
		button.addActionListener(this);
		
		//I want to add a way to have the button respond to the Enter key
		
		
		
		
		add(area, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		panel.add(label);
		panel.add(text);
		panel.add(button);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null); // Center window
		setVisible(true); // Make window appear
	}

}
