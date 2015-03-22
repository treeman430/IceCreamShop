package posSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class OrderMenu extends JFrame {
	static int numOfFlavor = 0;
	static int numOfDecorator = 0;
	static int maxHeight;
	static GridLayout layoutStyle;
	static String displayDesc;
	static double displayTotal;
	static JTextField totalSum = new JTextField(20);
	static JPanel flavorPanel = new JPanel();
	static JPanel decoratorPanel = new JPanel();
	static JPanel adminPanel = new JPanel();
	static IceCream temp = new Flavor();
	static IceCream orderFlavorItem = new Flavor();
	static IceCream orderDecoratorItem = new Decorator(orderFlavorItem);
	
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
		/* Ice Cream Decoratorm */
		final JLabel decLbl = new JLabel("Ice Cream Decorator");
		/* Admin Panel */
		final JButton newIceCreamBtn = new JButton("New Ice Cream");
		final JButton sysAdminBtn = new JButton("System Administrator");
		final JLabel totalLbl = new JLabel("Total: ");
		Object[] AdminList = new Object[] {newIceCreamBtn, sysAdminBtn, totalLbl, totalSum};
		totalSum.setText(Double.toString(displayTotal)); 
		
		flavorPanel.add(flaLbl);
		decoratorPanel.add(decLbl);
		
		for (int a=0; a<4; a++) {
			adminPanel.add((Component) AdminList[a]);
		}
		
		newIceCreamBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IceCream orderFlavorItem = new Flavor();
				temp = orderFlavorItem;
				@SuppressWarnings("unused")
				IceCream orderDecoratorItem = new Decorator(orderFlavorItem);
				displayTotal = 0.0;
				totalSum.setText(Double.toString(displayTotal));
			}
		});
		
		sysAdminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sysAdminUI.sysAdminMenu();
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
					IceCream orderFlavorItem = new Flavor();
					orderFlavorItem.setInfo(btnName, btnPrice);
					temp = orderFlavorItem;
					displayDesc = orderFlavorItem.getDescription();
					displayTotal = orderFlavorItem.getPrice();
					totalSum.setText(Double.toString(displayTotal));
				} else {
					IceCream orderDecoratorItem = new Decorator(temp);
					orderDecoratorItem.setInfo(btnName, btnPrice);
					temp = orderDecoratorItem;
					displayDesc = orderDecoratorItem.getDescription();
					displayTotal = orderDecoratorItem.getPrice();
					totalSum.setText(Double.toString(displayTotal));
				}
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
