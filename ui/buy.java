package GiaoDien;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Canvas;
import java.awt.TextArea;
import java.awt.ScrollPane;
import java.awt.Component;
import java.awt.Label;
import java.util.Vector;

public class buy extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_NAME;
	private JTextField textField_ID;
	private JTextField textField_BRAND;
	private JTextField textField_PRICE;

	static String[] sizeComboBox = {"S", "M", "L"};
	static Vector<Size> sizes = new Vector<>();
	static Vector<Integer> sizeList = new Vector<>();

	static SpinnerModel model;
	static JSpinner spinner_QUANTITY;

	static int selection = 0;

	public buy(Clothes clothes, Vector<Size> size) {
		readSize(clothes);
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 1109, 707);
		
		// Set Icon => JFrame
		URL urlIcon = buy.class.getResource("icon/icon21.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		this.setIconImage(img);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(589, 72, 408, 248);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("icon/anh4.png"));
		lblNewLabel.setBounds(0, 10, 447, 250);
		panel.add(lblNewLabel);
		
		JLabel Label_NAME = new JLabel(clothes.getClothesNAME());
		Label_NAME.setBackground(new Color(250, 240, 230));
		Label_NAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		Label_NAME.setBounds(87, 72, 350, 51);
		contentPane.add(Label_NAME);
		
		JLabel Label_ID = new JLabel("ID: " + clothes.getClothesID());
		Label_ID.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Label_ID.setBounds(87, 161, 200, 51);
		contentPane.add(Label_ID);
		
		JLabel Label_BRAND = new JLabel("BRAND:" + clothes.getBrandID());
		Label_BRAND.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Label_BRAND.setBounds(87, 251, 200, 51);
		contentPane.add(Label_BRAND);
		
		JLabel Label_PRICE = new JLabel("PRICE: " + clothes.getClothesPRICE());
		Label_PRICE.setForeground(new Color(220, 20, 60));
		Label_PRICE.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Label_PRICE.setBounds(87, 339, 200, 51);
		contentPane.add(Label_PRICE);

		JLabel Label_SIZE = new JLabel("SIZE");
		Label_SIZE.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Label_SIZE.setBounds(87, 427, 117, 51);
		contentPane.add(Label_SIZE);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(589, 339, 408, 7);
		contentPane.add(separator);
		
		JLabel Label_QUANTITY = new JLabel("QUANTITY");
		Label_QUANTITY.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Label_QUANTITY.setBounds(87, 509, 142, 51);
		contentPane.add(Label_QUANTITY);

		if (size.get(0).getSizeQUANTITY() == 0) {
			model = new SpinnerNumberModel(0, 0, 0, 1);
		} else {
			model = new SpinnerNumberModel(1, 1, (int) size.get(0).getSizeQUANTITY(), 1);
		}
		spinner_QUANTITY = new JSpinner(model);
		spinner_QUANTITY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_QUANTITY.setBounds(235, 511, 82, 51);
		contentPane.add(spinner_QUANTITY);
		
		JComboBox comboBox_SIZE = new JComboBox(sizeComboBox);
		comboBox_SIZE.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_SIZE.setBounds(235, 427, 177, 51);
		contentPane.add(comboBox_SIZE);

		comboBox_SIZE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selection = comboBox_SIZE.getSelectedIndex();

				int maxQuantity = (int) size.get(selection).getSizeQUANTITY();

				if (maxQuantity > 0) {
					SpinnerNumberModel spinnerModel = (SpinnerNumberModel) spinner_QUANTITY.getModel();
					spinnerModel.setMaximum(maxQuantity);
					int currentValue;
					if ((int) spinnerModel.getValue() == 0) {
						currentValue = 1;
					} else {
						currentValue = (int) spinnerModel.getValue();
					}
					spinnerModel.setValue(Math.min(currentValue, maxQuantity));
					spinner_QUANTITY.setEnabled(maxQuantity > 0);
				}
			}
		});

		JButton btn_BUY = new JButton("BUY");
		btn_BUY.setBackground(new Color(255, 239, 213));
		btn_BUY.setBounds(738, 356, 142, 57);
		btn_BUY.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_BUY.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(buy.class.getResource("icon/icon18.png"))));
		btn_BUY.addActionListener((ActionEvent e) -> {
			switch (selection) {
				case 0:
					int editNumberS = sizes.get(0).getSizeQUANTITY();
					sizes.get(0).setSizeQUANTITY(editNumberS - (int) spinner_QUANTITY.getValue());
					Connect.Buy(sizes.get(0),sizes.get(1),sizes.get(2));
					break;
				case 1:
					int editNumberM = sizes.get(1).getSizeQUANTITY();
					sizes.get(1).setSizeQUANTITY(editNumberM - (int) spinner_QUANTITY.getValue());
					Connect.Buy(sizes.get(0),sizes.get(1),sizes.get(2));
					break;
				case 2:
					int editNumberL = sizes.get(2).getSizeQUANTITY();
					sizes.get(2).setSizeQUANTITY(editNumberL - (int) spinner_QUANTITY.getValue());
					Connect.Buy(sizes.get(0),sizes.get(1),sizes.get(2));
					break;
				default:
					System.out.println("co cac dau ma case");
			}
			showBuyDialog("Quy khach da mua hang thanh cong");
			dispose();
		});
		contentPane.add(btn_BUY);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("icon/anh7.png"));
		lblNewLabel_1.setBounds(0, 0, 1095, 670);
		contentPane.add(lblNewLabel_1);
	}

	private static void readSize(Clothes clothes) {
		sizes = Connect.Size(clothes);
		for (Size size: sizes) {
			sizeList.add(size.getSizeQUANTITY());
		}
	}

	private static void showBuyDialog(String buyMessage) {
		JOptionPane.showMessageDialog(null, buyMessage, "Buy Complete", JOptionPane.INFORMATION_MESSAGE);
	}
}
