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
import java.util.Vector;
import java.util.Iterator;

public class add extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_NAME;
	private JTextField textField_ID;
	private JTextField textField_PRICE;
	private JTextField textField;

	static Vector list = Connect.ClothesAll();

	static Vector brandlist = Connect.ListBrand();
	static String[] brandnameComboBox = new String[brandlist.size()];
	static String[] brandID = new String[brandlist.size()];

	static Vector menulist = Connect.ListMenu();
	static String[] menunameComboBox = new String[menulist.size()];
	static String[] menuID = new String[menulist.size()];

	static int menuSelection = 0;
	static int brandSelection = 0;

	public add() {
		BrandList();
		MenuList();

		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 1109, 707);

		// Set Icon => JFrame
		URL urlIcon = add.class.getResource("icon/icon21.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		this.setIconImage(img);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_NAME = new JTextField();
		textField_NAME.setBounds(235, 72, 177, 51);
		textField_NAME.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(textField_NAME);
		textField_NAME.setColumns(10);

		textField_ID = new JTextField();
		textField_ID.setBounds(235, 158, 177, 51);
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_ID.setColumns(10);
		contentPane.add(textField_ID);

		Panel panel = new Panel();
		panel.setBounds(589, 72, 408, 248);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("icon/anh4.png"));
		lblNewLabel.setBounds(0, 10, 447, 250);
		panel.add(lblNewLabel);

		JLabel Label_NAME = new JLabel("NAME");
		Label_NAME.setBounds(87, 72, 117, 51);
		Label_NAME.setBackground(new Color(250, 240, 230));
		Label_NAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		contentPane.add(Label_NAME);

		JLabel Label_ID = new JLabel("ID");
		Label_ID.setBounds(87, 158, 117, 51);
		Label_ID.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_ID);

		JLabel Label_BRAND = new JLabel("BRAND");
		Label_BRAND.setBounds(87, 328, 117, 51);
		Label_BRAND.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_BRAND);

		JComboBox comboBox_BRAND = new JComboBox(brandnameComboBox);
		comboBox_BRAND.setBounds(235, 328, 177, 51);
		comboBox_BRAND.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				brandSelection = comboBox_BRAND.getSelectedIndex();
			}
		});
		contentPane.add(comboBox_BRAND);

		JLabel Label_TYPE = new JLabel("TYPE");
		Label_TYPE.setFont(new Font("Tahoma", Font.PLAIN, 26));
		Label_TYPE.setBounds(87, 242, 117, 51);
		contentPane.add(Label_TYPE);

		JComboBox comboBox_Menu = new JComboBox(menunameComboBox);
		comboBox_Menu.setBounds(235, 242, 177, 51);
		comboBox_Menu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuSelection = comboBox_Menu.getSelectedIndex();
			}
		});
		contentPane.add(comboBox_Menu);

		JLabel lblSize = new JLabel("SIZE :");
		lblSize.setBounds(87, 488, 84, 51);
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblSize);

		JLabel Label_PRICE = new JLabel("PRICE");
		Label_PRICE.setBounds(87, 417, 117, 51);
		Label_PRICE.setForeground(new Color(220, 20, 60));
		Label_PRICE.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_PRICE);

		textField_PRICE = new JTextField();
		textField_PRICE.setBounds(235, 417, 177, 51);
		textField_PRICE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_PRICE.setColumns(10);
		contentPane.add(textField_PRICE);

		JSeparator separator = new JSeparator();
		separator.setBounds(589, 339, 408, 7);
		contentPane.add(separator);

		SpinnerModel modelS = new SpinnerNumberModel(1, 1, 999, 1);
		JSpinner spinner_QUANTITY_S = new JSpinner(modelS);
		spinner_QUANTITY_S.setBounds(120, 556, 47, 42);
		spinner_QUANTITY_S.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(spinner_QUANTITY_S);

		JLabel Label_SIZE_1 = new JLabel("S");
		Label_SIZE_1.setBounds(87, 549, 23, 51);
		Label_SIZE_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_SIZE_1);

		SpinnerModel modelM = new SpinnerNumberModel(1, 1, 999, 1);
		JSpinner spinner_QUANTITY_M = new JSpinner(modelM);
		spinner_QUANTITY_M.setBounds(252, 556, 47, 42);
		spinner_QUANTITY_M.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(spinner_QUANTITY_M);

		JLabel Label_SIZE_1_1 = new JLabel("M");
		Label_SIZE_1_1.setBounds(219, 549, 23, 51);
		Label_SIZE_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_SIZE_1_1);

		SpinnerModel modelL = new SpinnerNumberModel(1, 1, 999, 1);
		JSpinner spinner_QUANTITY_L = new JSpinner(modelL);
		spinner_QUANTITY_L.setBounds(377, 556, 47, 42);
		spinner_QUANTITY_L.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(spinner_QUANTITY_L);

		JLabel Label_SIZE_1_2 = new JLabel("L");
		Label_SIZE_1_2.setBounds(344, 549, 23, 51);
		Label_SIZE_1_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_SIZE_1_2);

		JButton btn_ADD = new JButton("ADD");
		btn_ADD.setBounds(624, 356, 142, 57);
		btn_ADD.setBackground(new Color(255, 239, 213));
		btn_ADD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_ADD.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(add.class.getResource("icon/icon22.png"))));

		btn_ADD.addActionListener((ActionEvent e) -> {
			boolean ok = false;
			if (!list.isEmpty()) {
				Iterator<Clothes> iterator = list.iterator();
				while (iterator.hasNext()) {
					Clothes clothes = iterator.next();
					System.out.println(clothes.getClothesID());
					if (clothes.getClothesID().contains(textField_ID.getText())) {
						ok = false;
						showErrorDialog("Error: ID already exists!");
						break;
					} else {
						ok = true;
					}
				}
			} else {
				ok = true;
			}
			if (ok) {
				Clothes clothes = new Clothes(textField_ID.getText(),
						textField_NAME.getText(),
						Integer.parseInt(textField_PRICE.getText()),
						menuSelection+1,
						brandSelection+1);
				Size sizeS = new Size("S", textField_ID.getText(), (int) spinner_QUANTITY_S.getValue());
				Size sizeM = new Size("M", textField_ID.getText(), (int) spinner_QUANTITY_M.getValue());
				Size sizeL = new Size("L", textField_ID.getText(), (int) spinner_QUANTITY_L.getValue());
				Connect.Add(clothes, sizeS, sizeM, sizeL);
			}
			giaodien.showList();
			dispose();
		});
		contentPane.add(btn_ADD);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("icon/anh7.png"));
		lblNewLabel_1.setBounds(0, 0, 1095, 670);
		contentPane.add(lblNewLabel_1);

	}

	private static void showErrorDialog(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
	}

	private static void BrandList() {
		Iterator<Brand> iterator = brandlist.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Brand brand = iterator.next();
			brandnameComboBox[i] = brand.getBrandNAME();
			brandID[i] = brand.getBrandID();
			i++;
		}
	}

	private static void MenuList() {
		Iterator<Menu> iterator = menulist.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Menu menu = iterator.next();
			menunameComboBox[i] = menu.getMennuNAME();
			menuID[i] = menu.getMenuID();
			i++;
		}
	}
}
