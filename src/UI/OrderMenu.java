package UI;

import iceCream.Decorator;
import iceCream.Flavor;
import iceCream.IceCream;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class OrderMenu extends JFrame {
	static int numOfFlavor = 0;
	static int numOfDecorator = 0;
	static int maxHeight;
	static GridLayout layoutStyle;
	static JTextField totalSum = new JTextField(20);
	static JPanel flavorPanel = new JPanel();
	static JPanel decoratorPanel = new JPanel();
	static JPanel adminPanel = new JPanel();
	static IceCream orderItem = new Flavor();
	static boolean isFlaSelected = false;
	
	public OrderMenu(String name) {
		super(name);
		this.setResizable(true);
	}
	
	public static void setPanelSize() {
		maxHeight = Math.max(Math.max(numOfFlavor, numOfDecorator)+1, 4);
	}
	
	public static void setLayout() {
		layoutStyle = new GridLayout(maxHeight, 0);
	}
	
	public void placePanel(final Container container) {
		/* Ice Cream Flavor */
		final JLabel flaLbl = new JLabel("Ice Cream Flavor");
		/* Ice Cream Decorator */
		final JLabel decLbl = new JLabel("Ice Cream Decorator");
		/* Admin Panel */
		final JButton newIceCreamBtn = new JButton("New Ice Cream");
		final JButton sysAdminBtn = new JButton("System Administrator");
		final JLabel totalLbl = new JLabel("Total: ");
		Object[] AdminList = new Object[] {newIceCreamBtn, sysAdminBtn, totalLbl, totalSum};
		totalSum.setText(Double.toString(orderItem.getPrice())); 
		
		flavorPanel.add(flaLbl);
		decoratorPanel.add(decLbl);
		
		for (int a=0; a<4; a++) {
			adminPanel.add((Component) AdminList[a]);
		}
		
		newIceCreamBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderItem = new Flavor();
				orderItem = new Decorator(orderItem);
				isFlaSelected = false;
				orderItem.setInfo("", 0.0);
				totalSum.setText(Double.toString(orderItem.getPrice())); 
			}
		});
		
		sysAdminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemAdminMenu.sysAdminMenu();
			}
		});
		
		addNewButton("Flavor", "Chocolate", 20.0);
		addNewButton("Flavor", "Vanilla", 20.0);
		addNewButton("Decorator", "M&M", 5.0);
		addNewButton("Decorator", "Strawberry", 4.0);
		
		container.add(flavorPanel);
		container.add(decoratorPanel);
		container.add(adminPanel);
		
	}
	
	public static void addNewButton(final String btnType, final String btnName, final double btnPrice) {
		JButton btnName1 = new JButton();
		btnName1.setText("[" + btnName + ", $" + btnPrice + "]");
		if (btnType == "Flavor") {
			flavorPanel.add(btnName1);
			numOfFlavor += 1;
		} else {
			decoratorPanel.add(btnName1);
			numOfDecorator += 1;
		}
		
		flavorPanel.revalidate();
		decoratorPanel.revalidate();
		setPanelSize();
		setLayout();
		flavorPanel.setLayout(layoutStyle);
		decoratorPanel.setLayout(layoutStyle);
		adminPanel.setLayout(layoutStyle);
		
		btnName1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnType == "Flavor") {
					orderItem = new Flavor();
					orderItem.setInfo(btnName, btnPrice);
					isFlaSelected = true;
				} else {
					if (isFlaSelected == false) {
				        JOptionPane.showMessageDialog(null, "Please select flavor first.");
					} else {
						orderItem = new Decorator(orderItem);
						orderItem.setInfo(btnName, btnPrice);
					}
				}
				totalSum.setText(Double.toString(orderItem.getPrice()));
			}
		});
		
	}
	
	private static void createAndShowMenu() {
		OrderMenu menu = new OrderMenu("Patrick Ice Cream Shop");
		menu.setLayout(new GridLayout(0,3));
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.placePanel(menu.getContentPane());
		menu.pack();
		menu.setLocation(300, 300);
		menu.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowMenu();
			}
		});
	}
}
