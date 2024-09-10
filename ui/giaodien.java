package GiaoDien;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.net.URL;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.util.Vector;
import java.math.*;

public class giaodien extends JFrame {
	static int row = -1;
	static String[] cols = {"Order", "ID", "Name","Price", "Type", "Brand"};
	static DefaultTableModel model = new DefaultTableModel(cols, 0);

	static Vector<Clothes> list = Connect.ClothesAll();
	static Vector<Menu> menuList = Connect.ListMenu();
	static String[] menuName = new String[menuList.size()];

	static Vector<Brand> brandList = Connect.ListBrand();
	static String[] brandName = new String[brandList.size()];

	static Vector<Integer> searchNumber = new Vector<>();

	private static final long serialVersionUID = 1L;
	private JTextField txt_Search;
	private JPanel contentPane;
	private JTextField textField_NAME;
	private JTextField textField_PRICE;
	private JTextField textField_BRAND;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comboBoxManage();
					giaodien frame = new giaodien();
					frame.setVisible(true);
					showList();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public giaodien() {
		setBackground(new Color(250, 240, 230));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);

		// Set Icon => JFrame
		URL urlIcon = giaodien.class.getResource("icon/icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		this.setIconImage(img);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu Menu_HOME = new JMenu("HOME");
		Menu_HOME.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		Menu_HOME.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon1.png"))));
		menuBar.add(Menu_HOME);

		JMenu Menu_SHOP = new JMenu("SHOP");
		Menu_SHOP.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		Menu_SHOP.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon2.png"))));
		menuBar.add(Menu_SHOP);

		JMenuItem Item_T_SHIRTS = new JMenuItem("T-SHIRTS");
		Item_T_SHIRTS.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Item_T_SHIRTS.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon3.png"))));
		Menu_SHOP.add(Item_T_SHIRTS);

		JMenuItem Item_SHIRTS = new JMenuItem("SHIRTS");
		Item_SHIRTS.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Item_SHIRTS.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon4.png"))));
		Menu_SHOP.add(Item_SHIRTS);

		JMenuItem Item_SHORTS = new JMenuItem("SHORTS");
		Item_SHORTS.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Item_SHORTS.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon5.png"))));
		Menu_SHOP.add(Item_SHORTS);

		JMenuItem Item_JACKET = new JMenuItem("JACKET");
		Item_JACKET.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Item_JACKET.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon6.png"))));
		Menu_SHOP.add(Item_JACKET);

		JMenu Menu_ACCESSORIES = new JMenu("ACCESSORIES");
		Menu_ACCESSORIES.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Menu_SHOP.add(Menu_ACCESSORIES);

		JMenuItem Item_GLASSES = new JMenuItem("GLASSES");
		Item_GLASSES.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Item_GLASSES.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon10.png"))));
		Menu_ACCESSORIES.add(Item_GLASSES);

		JMenuItem Item_RING = new JMenuItem("RING");
		Item_RING.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Item_RING.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon11.png"))));
		Menu_ACCESSORIES.add(Item_RING);

		JMenuItem Item_BELT = new JMenuItem("BELT");
		Item_BELT.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Item_BELT.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon12.png"))));
		Menu_ACCESSORIES.add(Item_BELT);

		JMenuItem Item_SCARF = new JMenuItem("SCARF");
		Item_SCARF.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Item_SCARF.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon13.png"))));
		Menu_ACCESSORIES.add(Item_SCARF);

		JMenuItem Item_HAT = new JMenuItem("HAT");
		Item_HAT.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Item_HAT.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon14.png"))));
		Menu_ACCESSORIES.add(Item_HAT);

		JMenuItem Item_PANTS = new JMenuItem("PANTS");
		Item_PANTS.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		Item_PANTS.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon9.png"))));
		Menu_SHOP.add(Item_PANTS);

		txt_Search = new JTextField();
		txt_Search.setFont(new Font("Comic Sans MS",Font.PLAIN,25));
		txt_Search.setBorder(new MatteBorder(0,1,1,0,Color.BLACK));
		txt_Search.setBackground(Color.WHITE);
		txt_Search.setForeground(Color.CYAN);
		txt_Search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchNumber.clear();
				String keyword = txt_Search.getText();
				filterAndShowList(keyword);
			}
		});
		menuBar.add(txt_Search);

		JMenu Menu_SEARCH = new JMenu("SEARCH");
		Menu_SEARCH.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		Menu_SEARCH.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon15.png"))));
		menuBar.add(Menu_SEARCH);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel Label_NAME = new JLabel("NAME");
		Label_NAME.setBounds(500, 180, 93, 44);
		Label_NAME.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_NAME);

		JLabel Label_BRAND = new JLabel("BRAND");
		Label_BRAND.setBounds(500, 247, 104, 44);
		Label_BRAND.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_BRAND);

		JLabel Label_PRICE = new JLabel("PRICE");
		Label_PRICE.setBounds(500, 320, 93, 44);
		Label_PRICE.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(Label_PRICE);

		textField_NAME = new JTextField();
		textField_NAME.setBounds(650, 180, 252, 44);
		textField_NAME.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_NAME.setColumns(10);
		contentPane.add(textField_NAME);

		textField_PRICE = new JTextField();
		textField_PRICE.setBounds(650, 320, 252, 44);
		textField_PRICE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_PRICE.setColumns(10);
		contentPane.add(textField_PRICE);

		textField_BRAND = new JTextField();
		textField_BRAND.setBounds(650, 247, 252, 44);
		textField_BRAND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_BRAND.setColumns(10);
		contentPane.add(textField_BRAND);

		JButton btn_ADD = new JButton("ADD");
		btn_ADD.setBackground(new Color(250, 235, 215));
		btn_ADD.setBounds(83, 470, 162, 57);
		btn_ADD.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_ADD.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon17.png"))));
		btn_ADD.addActionListener((ActionEvent e) -> {
			add addFrame = new add();
			addFrame.setVisible(true);
		});
		contentPane.add(btn_ADD);

		JButton btn_BUY = new JButton("BUY");
		btn_BUY.setBackground(new Color(250, 235, 215));
		btn_BUY.setBounds(83, 537, 162, 57);
		btn_BUY.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_BUY.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon18.png"))));
		btn_BUY.addActionListener((ActionEvent e) -> {
			if (row >= 0)
				if (!(searchNumber.isEmpty())) {
					Vector<Size> size = Connect.Size(list.get(searchNumber.get(row)));
					buy buyFrame = new buy(list.get(searchNumber.get(row)), size);
					buyFrame.setVisible(true);
				} else {
					Vector<Size> size = Connect.Size(list.get(row));
					buy buyFrame = new buy(list.get(row), size);
					buyFrame.setVisible(true);
				}
				else {
					showErrorDialog("Please select clothes");
				}
		});
		contentPane.add(btn_BUY);

		JButton btn_EDIT = new JButton("EDIT");
		btn_EDIT.setBackground(new Color(250, 235, 215));
		btn_EDIT.setBounds(83, 604, 162, 57);
		btn_EDIT.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btn_EDIT.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(giaodien.class.getResource("icon/icon19.png"))));
		btn_EDIT.addActionListener((ActionEvent e) -> {
			if (row >= 0)
				if (!(searchNumber.isEmpty())) {
					Vector<Size> size = Connect.Size(list.get(searchNumber.get(row)));
					edit editFrame = new edit(list.get(searchNumber.get(row)), size);
					editFrame.setVisible(true);
				} else {
					Vector<Size> size = Connect.Size(list.get(row));
					edit editFrame = new edit(list.get(row), size);
					editFrame.setVisible(true);
				}
			else {
				showErrorDialog("Please select clothes");
			}
		});
		contentPane.add(btn_EDIT);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 470, 698, 191);
		contentPane.add(scrollPane);

		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				row = table.getSelectedRow();
				updateFieldsFromTable(row, model, textField_NAME, textField_PRICE, textField_BRAND);
			}
		});

		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				row = table.getSelectedRow();
				updateFieldsFromTable(row, model, textField_NAME, textField_PRICE, textField_BRAND);
			}
		});

		JPanel panel_NEN = new JPanel();
		panel_NEN.setBounds(0, 0, 1031, 143);
		panel_NEN.setBackground(new Color(210, 180, 140));
		contentPane.add(panel_NEN);
		panel_NEN.setLayout(null);

		JLabel Label_TENSHOP = new JLabel("VERGENCY");
		Label_TENSHOP.setFont(new Font("Vladimir Script", Font.BOLD, 60));
		Label_TENSHOP.setBounds(330, 10, 359, 80);
		panel_NEN.add(Label_TENSHOP);

		JLabel Label_LOICAMON = new JLabel("Satisfy You - Happy Us");
		Label_LOICAMON.setFont(new Font("Vladimir Script", Font.PLAIN, 30));
		Label_LOICAMON.setBounds(362, 78, 288, 62);
		panel_NEN.add(Label_LOICAMON);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(137, 152, 344, 307);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Acer\\OneDrive\\Hình ảnh\\Cuộn phim (1)\\anh1.png"));
		contentPane.add(lblNewLabel);
	}

	private static void updateFieldsFromTable(int row,
											  DefaultTableModel model,
											  JTextField idText,
											  JTextField nameText,
											  JTextField brandText) {
		idText.setText(model.getValueAt(row, 1).toString());
		nameText.setText(model.getValueAt(row, 2).toString());
		brandText.setText(model.getValueAt(row, 4).toString());
	}

	public static void showList() {
		list = Connect.ClothesAll();

		model.setRowCount(0);
		int i = 0;
		for (Clothes clothes : list) {
			i++;
			model.addRow(new Object[] {
					i,
					clothes.getClothesID(),
					clothes.getClothesNAME(),
					clothes.getClothesPRICE(),
					menuName[clothes.getMenuID()-1],
					brandName[clothes.getBrandID()-1]
			});
		}
	}

	private static void comboBoxManage() {
		for (int i = 0; i < menuList.size(); i++) {
			Menu menu = menuList.get(i);
			menuName[i] = menu.getMennuNAME();
		}
		for (int i = 0; i < brandList.size(); i++) {
			Brand brand = brandList.get(i);
			brandName[i] = brand.getBrandNAME();
		}
	}

	private static void filterAndShowList(String keyword) {
		list = Connect.ClothesAll();

		model.setRowCount(0);
		int i = 0;
		for (Clothes clothes : list) {
			i++;
			String id = String.valueOf(clothes.getClothesID());
			String name = clothes.getClothesNAME();
			String price = String.valueOf(clothes.getClothesPRICE());
			int type = clothes.getMenuID();
			int brand = clothes.getBrandID();

			if (id.toUpperCase().contains(keyword.toUpperCase()) ||
					name.toUpperCase().contains(keyword.toUpperCase()) ||
					price.contains(keyword) ||
					menuName[type-1].toUpperCase().contains(keyword.toUpperCase()) ||
					brandName[brand-1].toUpperCase().contains(keyword.toUpperCase())) {
				model.addRow(new Object[]{
						i,
						clothes.getClothesID(),
						clothes.getClothesNAME(),
						clothes.getClothesPRICE(),
						clothes.getMenuID(),
						clothes.getBrandID()
				});
				searchNumber.add(i-1);
			}
		}
	}

	private static void showErrorDialog(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
