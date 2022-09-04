package com.Advance.Swing.Other.CustomMenu;

import static java.awt.event.InputEvent.*;
import static java.awt.event.KeyEvent.*;

import java.awt.event.*;
import java.net.*;

import javax.swing.*;

public class CustomMenu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final ButtonGroup buttonGroup = new ButtonGroup();
	
	public static void main(String args[]) {
		CustomMenu frame = new CustomMenu();
		frame.setVisible(true);
	}
	
	public CustomMenu() {
		super();
		setBounds(100, 100, 500, 375);
		setTitle("���Ƹ��Ի��˵�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		final JMenu fileMenu = new JMenu("�ļ���F��");// �������ļ����˵�
		fileMenu.setMnemonic('F');// ���ÿ�ݼ�
		menuBar.add(fileMenu);// ��ӵ��˵���
		final JMenuItem newItem = new JMenuItem("�½���N��");// �����˵���
		newItem.setMnemonic('N');// ���ÿ�ݼ�
		// ���ü�����Ϊ��Ctrl+N��
		newItem.setAccelerator(KeyStroke.getKeyStroke(VK_N, CTRL_MASK));
		newItem.addActionListener(new ItemListener());// ��Ӷ���������
		fileMenu.add(newItem);// ��ӵ����ļ����˵�
		final JMenu openMenu = new JMenu("�򿪣�O��");// �������򿪡��Ӳ˵�
		openMenu.setMnemonic('O');// ���ÿ�ݼ�
		fileMenu.add(openMenu);// ��ӵ����ļ����˵�
		// �����Ӳ˵���
		final JMenuItem openNewItem = new JMenuItem("δ�򿪹��ģ�N��");
		openNewItem.setMnemonic('N');// ���ÿ�ݼ�
		// ���ü�����Ϊ��Ctrl+Alt+N��
		openNewItem.setAccelerator(KeyStroke.getKeyStroke(VK_N, CTRL_MASK
				| ALT_MASK));
		openNewItem.addActionListener(new ItemListener());// ��Ӷ���������
		openMenu.add(openNewItem);// ��ӵ����򿪡��Ӳ˵�
		// �����Ӳ˵���
		final JMenuItem openClosedItem = new JMenuItem("�մ򿪹��ģ�C��");
		openClosedItem.setMnemonic('C');// ���ÿ�ݼ�
		// ���ü�����
		openClosedItem.setAccelerator(KeyStroke.getKeyStroke(VK_C,
				CTRL_MASK | ALT_MASK));
		openClosedItem.setEnabled(false);// ���ò˵���
		// ��Ӷ���������
		openClosedItem.addActionListener(new ItemListener());
		openMenu.add(openClosedItem);// ��ӵ����򿪡��Ӳ˵�
		fileMenu.addSeparator();// ��ӷָ���
		
		final JMenuItem saveItem = new JMenuItem();
		saveItem.setText("���棨S��");
		saveItem.setMnemonic('S');
		saveItem.setAccelerator(KeyStroke.getKeyStroke(VK_S, CTRL_MASK));
		saveItem.addActionListener(new ItemListener());
		fileMenu.add(saveItem);
		
		fileMenu.addSeparator();
		
		final JMenuItem exitItem = new JMenuItem();
		exitItem.setText("�˳���E��");
		exitItem.setMnemonic('E');
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK));
		exitItem.addActionListener(new ItemListener());
		fileMenu.add(exitItem);
		
		final JMenu editMenu = new JMenu();
		editMenu.setText("�༭��E��");
		editMenu.setMnemonic('E');
		menuBar.add(editMenu);
		
		URL resource = this.getClass().getResource("/img.JPG");
		ImageIcon icon = new ImageIcon(resource);
		
		final JMenuItem cutItem = new JMenuItem();
		cutItem.setIcon(icon);
		cutItem.setText("���У�T��");
		cutItem.setMnemonic('T');
		cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
				InputEvent.CTRL_MASK));
		cutItem.addActionListener(new ItemListener());
		editMenu.add(cutItem);
		
		final JMenuItem copyItem = new JMenuItem();
		copyItem.setIcon(icon);
		copyItem.setText("���ƣ�C��");
		copyItem.setMnemonic('C');
		copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_MASK));
		copyItem.addActionListener(new ItemListener());
		editMenu.add(copyItem);
		
		final JMenuItem pastItem = new JMenuItem();
		pastItem.setIcon(icon);
		pastItem.setText("ճ����P��");
		pastItem.setMnemonic('P');
		pastItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				InputEvent.CTRL_MASK));
		pastItem.addActionListener(new ItemListener());
		editMenu.add(pastItem);
		
		editMenu.addSeparator();
		editMenu.insertSeparator(2);
		
		final JMenu fontMenu = new JMenu("���壨F��");// ���������塱�Ӳ˵�
		fontMenu.setIcon(icon);// ���ò˵�ͼ��
		fontMenu.setMnemonic('F');// ���ÿ�ݼ�
		editMenu.add(fontMenu);// ��ӵ����༭���˵�
		final JCheckBoxMenuItem bCheckBoxItem = new JCheckBoxMenuItem(
				"�Ӵ֣�B��");// ������ѡ��˵���
		bCheckBoxItem.setMnemonic('B');// ���ÿ�ݼ�
		bCheckBoxItem.setAccelerator(KeyStroke.getKeyStroke(VK_B,
				CTRL_MASK | ALT_MASK)); // ���ü�����Ϊ��Ctrl+Alt+B��
		bCheckBoxItem.addActionListener(new ItemListener()); // ��Ӷ���������
		fontMenu.add(bCheckBoxItem);// ��ӵ������塱�Ӳ˵�
		final JCheckBoxMenuItem iCheckBoxItem = new JCheckBoxMenuItem(
				"б�壨I��");// ������ѡ��˵���
		iCheckBoxItem.setMnemonic('I');// ���ÿ�ݼ�
		iCheckBoxItem.setAccelerator(KeyStroke.getKeyStroke(VK_I,
				CTRL_MASK | ALT_MASK)); // ���ü�����Ϊ��Ctrl+Alt+I��
		iCheckBoxItem.addActionListener(new ItemListener()); // ��Ӷ���������
		fontMenu.add(iCheckBoxItem);// ��ӵ������塱�Ӳ˵�
		
		editMenu.addSeparator();
		
		final JMenu attributeMenu = new JMenu("���ԣ�A��");// ���������ԡ��Ӳ˵�
		attributeMenu.setIcon(icon);// ���ò˵�ͼ��
		attributeMenu.setMnemonic('A');// ���ÿ�ݼ�
		editMenu.add(attributeMenu);// ��ӵ����༭���˵�
		final JRadioButtonMenuItem rRadioButtonItem = new JRadioButtonMenuItem(
				"ֻ����R��");// ������ѡ��ť�˵���
		rRadioButtonItem.setMnemonic('R');// ���ÿ�ݼ�
		rRadioButtonItem.setAccelerator(KeyStroke.getKeyStroke(VK_R,
				CTRL_MASK | ALT_MASK));// ���ü�����Ϊ��Ctrl+Alt+R��
		buttonGroup.add(rRadioButtonItem);// ��ӵ���ť��
		rRadioButtonItem.setSelected(true);// ����Ϊ��ѡ��
		rRadioButtonItem.addActionListener(new ItemListener());// ��Ӷ���������
		attributeMenu.add(rRadioButtonItem);// ��ӵ������ԡ��Ӳ˵�
		final JRadioButtonMenuItem eRadioButtonItem = new JRadioButtonMenuItem(
				"�༭��E��");// ������ѡ��ť�˵���
		eRadioButtonItem.setMnemonic('E');// ���ÿ�ݼ�
		eRadioButtonItem.setAccelerator(KeyStroke.getKeyStroke(VK_E,
				CTRL_MASK | ALT_MASK));// ���ü�����Ϊ��Ctrl+Alt+E��
		buttonGroup.add(eRadioButtonItem);// ��ӵ���ť��
		eRadioButtonItem.addActionListener(new ItemListener());// ��Ӷ���������
		attributeMenu.add(eRadioButtonItem);// ��ӵ������ԡ��Ӳ˵�
		
		final JMenu helpMenu = new JMenu("������H��", false);
		helpMenu.setText("������H��");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
		
		final JMenuItem aboutItem = new JMenuItem();
		aboutItem.setText("���ڣ�A��");
		aboutItem.setMnemonic('A');
		aboutItem.addActionListener(new ItemListener());
		helpMenu.add(aboutItem);
		//
	}
	
	private class ItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem menuItem = (JMenuItem) e.getSource();
			System.out.println("���������ǲ˵��" + menuItem.getText());
		}
	}
	
}
