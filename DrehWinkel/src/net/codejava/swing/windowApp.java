package net.codejava.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class windowApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private controller ctrl;
	

	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2; 
	
	private JPanel panel;
	
	private JButton validateButton;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	
	
	private JCheckBox chckbxNewCheckBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowApp frame = new windowApp();
					frame.setTitle("Rotation Matrix Application | Author: Jochem Punt MIB , SoSe2021");
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void setTextArea1(String pText) {
		textArea.setText(pText);
	}
	
	public void setTextArea2(String pText) {
		textArea_1.setText(pText);
	}
	
	public void setTextArea3(String pText) {
		textArea_2.setText(pText);
	}
	
	public String getTextArea1() {
		return textArea.getText();
	}
	
	public String getTextArea2() {
		return textArea_1.getText();
	}
	
	public void setColorT(Color c) {
		textArea.setBackground(c);;
	}
	
	public void setColorT2(Color c) {
		textArea_1.setBackground(c);;
	}
	
	public void setPanelColor(Color c) {
		panel.setBackground(c);
	}
	
	
	public windowApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 599);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		
		ctrl = new controller(this); // bidirektionale assoziation --> der controller muss die gui ansprechen können sowie die gui den controller
		
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(256, 136, 252, 70);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{5, 5, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 0;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 1;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 1;
		panel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 1;
		panel.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 0, 5);
		gbc_textField_6.fill = GridBagConstraints.BOTH;
		gbc_textField_6.gridx = 0;
		gbc_textField_6.gridy = 2;
		panel.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 0, 5);
		gbc_textField_7.fill = GridBagConstraints.BOTH;
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 2;
		panel.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.fill = GridBagConstraints.BOTH;
		gbc_textField_8.gridx = 2;
		gbc_textField_8.gridy = 2;
		panel.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		
		btnNewButton.setBounds(256, 217, 89, 23);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setBounds(331, 252, 52, 117);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		contentPane.add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setBackground(Color.LIGHT_GRAY);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setEditable(false);
		textArea_1.setBounds(256, 362, 338, 33);
		contentPane.add(textArea_1);
		
		
		
		
		validateButton = new JButton("Validate");
		validateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ctrl.validiere();
				
			}
		});
		validateButton.setBounds(419, 217, 89, 23);
		contentPane.add(validateButton);
		
		JLabel lblNewLabel = new JLabel("RotationMatrix");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(324, 73, 125, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("D(a,delta):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(110, 252, 99, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("delta = ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(256, 337, 52, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(")");
		lblNewLabel_3.setFont(new Font("Source Code Pro ExtraLight", Font.PLAIN, 55));
		lblNewLabel_3.setBounds(376, 208, 33, 143);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("(");
		lblNewLabel_4.setFont(new Font("Source Code Pro ExtraLight", Font.PLAIN, 55));
		lblNewLabel_4.setBounds(293, 229, 52, 101);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("a = ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(266, 276, 25, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("\u00B0");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(390, 337, 52, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Euler angles:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(110, 369, 125, 23);
		contentPane.add(lblNewLabel_7);
		
		chckbxNewCheckBox = new JCheckBox("validate if matrix is rotationmatrix ");
		
		chckbxNewCheckBox.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox.setBounds(6, 7, 302, 79);
		contentPane.add(chckbxNewCheckBox);
		
		textArea_2 = new JTextArea();
		textArea_2.setBackground(Color.LIGHT_GRAY);
		textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea_2.setEditable(false);
		textArea_2.setBounds(256, 431, 193, 101);
		contentPane.add(textArea_2);
		
		JLabel lblNewLabel_8 = new JLabel("=");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_8.setBounds(209, 451, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		
		
		
		validateButton.setVisible(false);
		
		
		
		
		
		
		
		// submit button action
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				validateButton.setVisible(false);
				
				
				double[][] matrix= {{Double.parseDouble(textField.getText()),Double.parseDouble(textField_1.getText()),Double.parseDouble(textField_2.getText())},
									{Double.parseDouble(textField_3.getText()),Double.parseDouble(textField_4.getText()),Double.parseDouble(textField_5.getText())},
									{Double.parseDouble(textField_6.getText()),Double.parseDouble(textField_7.getText()),Double.parseDouble(textField_8.getText())}
					};
				setColorT(Color.LIGHT_GRAY);
				setColorT2(Color.LIGHT_GRAY);
				
				if(chckbxNewCheckBox.isSelected()) {
					//System.out.println(chckbxNewCheckBox.isSelected());
					if(ctrl.istRotationsMatrix(matrix)) {
						setPanelColor(Color.LIGHT_GRAY);
						ctrl.setMatrixM(matrix);
						validateButton.setVisible(true);	
					}else {
						setTextArea2("Error: Matrix is not a RotationMatrix");
						setTextArea1("");
						setPanelColor(Color.red);
					}
				}else {
					
					
					setPanelColor(Color.LIGHT_GRAY);
					ctrl.setMatrixM(matrix);
					validateButton.setVisible(true);
				}
				
				
				
				
				
				
			}
		});
	}
}
