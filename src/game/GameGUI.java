package game;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.awt.*;
import java.awt.event.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameGUI extends JFrame implements KeyListener, ActionListener {

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
		text.setText("");
	}

	private void buildWindow() {
		setTitle("Undure Pressure");
		setLayout(new BorderLayout());

		area = new JTextArea();
		panel = new JPanel(new GridLayout(3, 1));
		label = new JLabel("What would you like to do?");
		text = new JTextField();
		button = new JButton("Execute");

		button.addActionListener(this);
		text.addKeyListener(this);

		JScrollPane pane = new JScrollPane(area); // scroll bar
		DefaultCaret caret = (DefaultCaret) area.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		add(pane, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		panel.add(label);
		panel.add(text);
		panel.add(button);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null); // Center window
		setVisible(true); // Make window appear

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == '\n') {
			String s = text.getText();
			Game.processCommand(s);
			text.setText("");
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
