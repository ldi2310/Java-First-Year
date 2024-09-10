package GiaoDien;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import java.awt.Color;
import java.awt.Panel;
import java.util.Iterator;
import java.util.Vector;

public class edit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_NAME;
	private JTextField textField_ID;

	static Vector brandlist = Connect.ListBrand();
	static String[] brandnameComboBox = new String[brandlist.size()];
	static String[] brandID = new String[brandlist.size()];
	static Iterator<Brand> iteratorBRAND = brandlist.iterator();

	static Vector menulist = Connect.ListMenu();
	static String[] menunameComboBox = new String[menulist.size()];
	static String[] menuID = new String[menulist.size()];
	static Iterator<Menu> iteratorMENU = menulist.iterator();

	static Vector<Size> sizes = new Vector<>();
	static Vector<Integer> sizeList = new Vector<>();

	static Vector<Clothes> list = Connect.ClothesAll();


	private int menuSelection;
	private int brandSelection;

	public edit(Clothes clothes, Vector<Size> size) {
		sizes = size;
		BrandList();
		MenuList();
		readSize();
		menuSelection = clothes.getMenuID();
		brandSelection = clothes.getBrandID();

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
		Label_ID.setBounds(87, 154, 117, 51);
		Label_ID.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_ID);

		JLabel Label_BRAND = new JLabel("BRAND");
		Label_BRAND.setBounds(87, 327, 117, 51);
		Label_BRAND.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_BRAND);

		JLabel lblSize = new JLabel("SIZE :");
		lblSize.setBounds(87, 486, 84, 51);
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblSize);

		JLabel Label_PRICE = new JLabel("PRICE");
		Label_PRICE.setBounds(87, 414, 117, 51);
		Label_PRICE.setForeground(new Color(220, 20, 60));
		Label_PRICE.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_PRICE);

		textField_NAME = new JTextField(clothes.getClothesNAME());
		textField_NAME.setBounds(235, 72, 177, 51);
		textField_NAME.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(textField_NAME);
		textField_NAME.setColumns(10);

		textField_ID = new JTextField(clothes.getClothesID());
		textField_ID.setBounds(235, 154, 177, 51);
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_ID.setColumns(10);
		contentPane.add(textField_ID);

		SpinnerModel model = new SpinnerNumberModel(clothes.getClothesPRICE(), 0, 600000000, 1);
		JSpinner spinner_PRICE = new JSpinner(model);
		spinner_PRICE.setBounds(235, 414, 177, 51);
		spinner_PRICE.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(spinner_PRICE);

		JSeparator separator = new JSeparator();
		separator.setBounds(589, 339, 408, 7);
		contentPane.add(separator);

		SpinnerModel modelS = new SpinnerNumberModel(size.get(0).getSizeQUANTITY(), 0, 600000000, 1);
		JSpinner spinner_QUANTITY = new JSpinner(modelS);
		spinner_QUANTITY.setBounds(120, 554, 47, 42);
		spinner_QUANTITY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(spinner_QUANTITY);

		JLabel Label_SIZE_1 = new JLabel("S");
		Label_SIZE_1.setBounds(87, 547, 23, 51);
		Label_SIZE_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_SIZE_1);

		SpinnerModel modelM = new SpinnerNumberModel(size.get(1).getSizeQUANTITY(), 0, 600000000, 1);
		JSpinner spinner_QUANTITY_1 = new JSpinner(modelM);
		spinner_QUANTITY_1.setBounds(227, 554, 47, 42);
		spinner_QUANTITY_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(spinner_QUANTITY_1);

		JLabel Label_SIZE_1_1 = new JLabel("M");
		Label_SIZE_1_1.setBounds(194, 547, 23, 51);
		Label_SIZE_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_SIZE_1_1);

		SpinnerModel modelL = new SpinnerNumberModel(size.get(2).getSizeQUANTITY(), 0, 600000000, 1);
		JSpinner spinner_QUANTITY_2 = new JSpinner(modelL);
		spinner_QUANTITY_2.setBounds(336, 555, 47, 42);
		spinner_QUANTITY_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(spinner_QUANTITY_2);

		JLabel Label_SIZE_1_2 = new JLabel("L");
		Label_SIZE_1_2.setBounds(303, 548, 23, 51);
		Label_SIZE_1_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_SIZE_1_2);

		JButton btn_EDIT = new JButton("EDIT");
		btn_EDIT.setBounds(438, 414, 150, 51);
		btn_EDIT.setIcon(new ImageIcon("icon/icon19.png"));
		btn_EDIT.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_EDIT.setBackground(new Color(255, 250, 205));
		btn_EDIT.addActionListener((ActionEvent e) -> {
			boolean ok = true;
			int i = 0;
			if (textField_ID.getText().contains(clothes.getClothesID())) {
				i = 0;
			} else {
				i = 1;
			}
			Iterator<Clothes> iterator = list.iterator();
			while (iterator.hasNext()) {
				Clothes check = iterator.next();
				if (check.getClothesID().contains(textField_ID.getText())) {
					if (i < 1) {
						ok = false;
						i++;
					} else {
						ok = true;
						break;
					}
				} else {
					ok = false;
				}
			}
			if (ok) {
				showErrorDialog("Error: ID already exists!");
			} else {
				Clothes sql = new Clothes(textField_ID.getText(),
						textField_NAME.getText(),
						(int) model.getValue(),
						menuSelection + 1,
						brandSelection + 1);
				Connect.Edit(sql, clothes.getClothesID());
				giaodien.showList();
				dispose();
			}
		});
		contentPane.add(btn_EDIT);

		JLabel Label_ID_1 = new JLabel("TYPE");
		Label_ID_1.setBounds(87, 239, 117, 51);
		Label_ID_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_ID_1);

		JComboBox comboBox_MENU = new JComboBox(menunameComboBox);
		comboBox_MENU.setBounds(235, 239, 177, 51);
		comboBox_MENU.setSelectedItem(menunameComboBox[clothes.getMenuID()-1]);
		comboBox_MENU.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuSelection = comboBox_MENU.getSelectedIndex();
			}
		});
		contentPane.add(comboBox_MENU);

		JComboBox comboBox_BRAND = new JComboBox(brandnameComboBox);
		comboBox_BRAND.setBounds(235, 327, 177, 51);
		comboBox_BRAND.setSelectedItem(brandnameComboBox[clothes.getBrandID()-1]);
		comboBox_BRAND.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				brandSelection = comboBox_BRAND.getSelectedIndex();
			}
		});
		contentPane.add(comboBox_BRAND);

		JButton btn_EDIT_1 = new JButton("EDIT");
		btn_EDIT_1.setIcon(new ImageIcon("icon/icon19.png"));
		btn_EDIT_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_EDIT_1.setBackground(new Color(255, 250, 205));
		btn_EDIT_1.setBounds(438, 547, 150, 51);
		btn_EDIT_1.addActionListener((ActionEvent e) -> {
			if ((int) spinner_QUANTITY.getValue() == 0 &&
					(int) spinner_QUANTITY_1.getValue() == 0 &&
					(int) spinner_QUANTITY_2.getValue() == 0) {
				Object[] options = { "DELETE", "KEEP" };
				int choice = JOptionPane.showOptionDialog(null, "The product is out of stock. Do you want to keep it?", "Warning",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, options, options[0]);

				if (choice == 0) {
					Connect.DELETE(clothes);
					giaodien.showList();
				} else if (choice == 1) {
					editClothes(size, 0, 0, 0);
				}
			} else {
				editClothes(size, (int) spinner_QUANTITY.getValue(), (int) spinner_QUANTITY_1.getValue(), (int) spinner_QUANTITY_2.getValue());
			}
			dispose();
		});
		contentPane.add(btn_EDIT_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("icon/anh7.png"));
		lblNewLabel_1.setBounds(0, 0, 1095, 670);
		contentPane.add(lblNewLabel_1);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "You don't choose any option. I won't save!",
						"Warning", JOptionPane.WARNING_MESSAGE);
				dispose();
			}
		});
	}

	private static void BrandList() {
		int i = 0;
		while (iteratorBRAND.hasNext()) {
			Brand brand = iteratorBRAND.next();
			brandnameComboBox[i] = brand.getBrandNAME();
			brandID[i] = brand.getBrandID();
			i++;
		}
	}

	private static void MenuList() {
		int i = 0;
		while (iteratorMENU.hasNext()) {
			Menu menu = iteratorMENU.next();
			menunameComboBox[i] = menu.getMennuNAME();
			menuID[i] = menu.getMenuID();
			i++;
		}
	}

	private static void readSize() {
		for (Size size: sizes) {
			sizeList.add(size.getSizeQUANTITY());
		}
	}

	private static void showErrorDialog(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
	}

	private static void editClothes(Vector<Size> size,int sizeS,int sizeM, int sizeL) {
		size.get(0).setSizeQUANTITY(sizeS);
		size.get(1).setSizeQUANTITY(sizeM);
		size.get(2).setSizeQUANTITY(sizeL);
		Connect.EditSize(sizes.get(0), sizes.get(1), sizes.get(2));
		giaodien.showList();
	}
}
