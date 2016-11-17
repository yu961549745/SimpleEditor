package test;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yangrd on 11/17/16.
 */
public class yrd extends JFrame {
	private static final long serialVersionUID = 7681677245260902664L;

	yrd() {
		initGUI();
	}

	private void initGUI() {
		// 初始字体格式
		Font font1 = new Font("宋体", Font.BOLD, 24);

		// 顶层工具栏
		JMenuBar menubar1 = new JMenuBar();

		final JTextPane textPane = new JTextPane();

		// 设置textPane的字体（初始字体）
		textPane.setFont(font1);

		// 将JPanel加入滚动Pane
		setContentPane(new JScrollPane(textPane));

		// 为顶部的工具栏添加item，只是为了测试部分功能设置的工具栏，可以删除
		menubar1 = addMenubar(menubar1);

		// 加入顶部菜单栏
		setJMenuBar(menubar1);

		/**
		 * 修改字体颜色监听，跳出颜色选择框
		 */
		menubar1.getMenu(4).getItem(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet arr = new SimpleAttributeSet();
				Color color = JColorChooser.showDialog(null, "color title",
						Color.BLACK);
				StyleConstants.setForeground(arr, color);

				textPane.setCharacterAttributes(arr, false);
			}
		});

		/**
		 * 修改字体大小
		 */
		menubar1.getMenu(0).getItem(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 由于你是直接在框内输入数字，在此处获取框内的内容就行了。比如getText（）之类的方法
				int size = 40;
				SimpleAttributeSet arr = new SimpleAttributeSet();
				StyleConstants.setFontSize(arr, size);

				textPane.setCharacterAttributes(arr, false);
			}
		});

		/**
		 * 下划线功能
		 */
		// 下划线
		menubar1.getMenu(1).getItem(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet arr = new SimpleAttributeSet();
				StyleConstants.setUnderline(arr, true);
				textPane.setCharacterAttributes(arr, false);
			}
		});

		// 取消下划线
		menubar1.getMenu(1).getItem(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet arr = new SimpleAttributeSet();
				StyleConstants.setUnderline(arr, false);
				textPane.setCharacterAttributes(arr, false);
			}
		});

		/**
		 * 三种对齐方式
		 */
		// 对齐方式-右边对齐
		menubar1.getMenu(1).getItem(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet arr = new SimpleAttributeSet();
				StyleConstants.setAlignment(arr, StyleConstants.ALIGN_RIGHT);
				textPane.setParagraphAttributes(arr, false);
			}
		});

		// 对齐方式-居中对齐
		menubar1.getMenu(1).getItem(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet arr = new SimpleAttributeSet();
				StyleConstants.setAlignment(arr, StyleConstants.ALIGN_CENTER);
				textPane.setParagraphAttributes(arr, false);
			}
		});

		// 对齐方式-左边对齐
		menubar1.getMenu(1).getItem(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet arr = new SimpleAttributeSet();
				StyleConstants.setAlignment(arr, StyleConstants.ALIGN_LEFT);
				textPane.setParagraphAttributes(arr, false);
			}
		});

		/**
		 * 设置是否加粗
		 */
		// 加粗
		menubar1.getMenu(3).getItem(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet arr = new SimpleAttributeSet();
				StyleConstants.setBold(arr, true);
				textPane.setCharacterAttributes(arr, false);
			}
		});

		// 不加粗
		menubar1.getMenu(3).getItem(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet arr = new SimpleAttributeSet();
				StyleConstants.setBold(arr, false);
				textPane.setCharacterAttributes(arr, false);
			}
		});

		/**
		 * 设置斜体和取消斜体
		 */
		// 斜体
		menubar1.getMenu(3).getItem(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet arr = new SimpleAttributeSet();
				StyleConstants.setItalic(arr, true);
				textPane.setCharacterAttributes(arr, false);
			}
		});

		// 不斜体
		menubar1.getMenu(3).getItem(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet arr = new SimpleAttributeSet();
				StyleConstants.setItalic(arr, false);
				textPane.setCharacterAttributes(arr, false);
			}
		});

		/**
		 * 插入图片
		 */
		menubar1.getMenu(4).getItem(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser f = new JFileChooser();
				f.showOpenDialog(null);
				textPane.insertIcon(new ImageIcon(f.getSelectedFile().getPath()));
			}
		});

		// 设置JFrame参数
		setTitle("TextEdit V1.0(demo)");
		setVisible(true);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * 为顶部状态栏添加内容
	 * 
	 * @param
	 */

	private JMenuBar addMenubar(JMenuBar menubar1) {

		JMenu menu1 = new JMenu("菜单1");
		JMenu menu2 = new JMenu("菜单2");
		JMenu menu3 = new JMenu("菜单3");
		JMenu menu4 = new JMenu("菜单4");
		JMenu menu5 = new JMenu("菜单5");
		JMenuItem item1 = new JMenuItem("修改字体大小");
		JMenuItem item2 = new JMenuItem("设置新字体");
		JMenuItem item3 = new JMenuItem("子菜单3");
		JMenuItem item4 = new JMenuItem("子菜单4");
		JMenuItem item5 = new JMenuItem("子菜单5");
		JMenuItem item6 = new JMenuItem("子菜单6");
		JMenuItem item7 = new JMenuItem("子菜单7");
		JMenuItem item8 = new JMenuItem("子菜单8");
		JMenuItem item9 = new JMenuItem("子菜单9");
		JMenuItem item10 = new JMenuItem("子菜单10");
		JMenuItem item11 = new JMenuItem("修改字体颜色");
		JMenuItem item12 = new JMenuItem("插入图片");

		menu1.add(item1);
		menu1.addSeparator();
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		menu2.add(item4);
		menu2.addSeparator();
		menu2.add(item5);
		menu3.add(item6);
		menu3.addSeparator();
		menu3.add(item7);
		menu4.add(item8);
		menu4.addSeparator();
		menu4.add(item9);
		menu4.addSeparator();
		menu4.add(item10);
		menu5.add(item11);
		menu5.addSeparator();
		menu5.add(item12);

		menubar1.add(menu1);
		menubar1.add(menu2);
		menubar1.add(menu3);
		menubar1.add(menu4);
		menubar1.add(menu5);

		return menubar1;
	}

	public static void main(String[] args) {

		new yrd();

	}

}
