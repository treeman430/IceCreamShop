package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class SystemAdminMenu extends JFrame {
	
	public SystemAdminMenu(String name) {
		super(name);
		this.setResizable(true);
	}
	
	public void addNewButton(String btnType, String btnName, double btnPrice) {
		OrderMenu.addNewButton(btnType, btnName, btnPrice);		
	}
	
	public void placePanel(final Container pane) {
		final JPanel sysAdminPanel = new JPanel();
		final String btnTypeOption[] = {"Flavor", "Decorator"};
		
		JLabel btnTypeLbl = new JLabel("New Ingredient Type: ");
		final JComboBox<?> btnTypeCB = new JComboBox<Object>(btnTypeOption);
		JLabel btnNameLbl = new JLabel("Name of New Ingredient: ");
		final JTextField btnNameIn = new JTextField();
		JLabel btnPriceLbl = new JLabel("Price of New Ingredient: ");
		final JTextField btnPriceIn = new JTextField();
		final JButton addBtn = new JButton("Confirm");
		
		sysAdminPanel.add(btnTypeLbl);
		sysAdminPanel.add(btnTypeCB);
		sysAdminPanel.add(btnNameLbl);
		sysAdminPanel.add(btnNameIn);
		sysAdminPanel.add(btnPriceLbl);
		sysAdminPanel.add(btnPriceIn);
		sysAdminPanel.add(addBtn);
		sysAdminPanel.setLayout(new GridLayout(0,2));
		sysAdminPanel.setVisible(true);
		pane.add(sysAdminPanel);
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String btnType;
				final String btnName;
				final double btnPrice;
				
				btnType = (String) btnTypeCB.getSelectedItem();
				btnName = btnNameIn.getText();
				btnPrice = Double.parseDouble(btnPriceIn.getText());
				
				addNewButton(btnType, btnName, btnPrice);
				
				dispose();
			}
		});
	}
	
	static void sysAdminMenu() {
		SystemAdminMenu menu = new SystemAdminMenu("System Administrator");
		menu.setLayout(new GridLayout(0,1));
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.placePanel(menu.getContentPane());
		menu.setLocation(300, 300);
		menu.pack();
		menu.setVisible(true);
	}
}
