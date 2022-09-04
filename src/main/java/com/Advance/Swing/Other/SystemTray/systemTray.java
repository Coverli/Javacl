package com.Advance.Swing.Other.SystemTray;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;

public class systemTray extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		systemTray frame = new systemTray();
		frame.setVisible(true);
		try {
			frame.addIconToTray();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public systemTray() {
		super();
		setTitle("ʹ��ϵͳ����");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel label = new JLabel();
		label.setForeground(new Color(0, 128, 0));
		label.setFont(new Font("", Font.BOLD, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("��鿴ϵͳ�����еı仯��");
		getContentPane().add(label, BorderLayout.CENTER);
		//
	}
	
	public void addIconToTray() throws AWTException {
		if (SystemTray.isSupported()) {// �ж�ϵͳ�Ƿ�֧��ϵͳ���̹���
			URL resource = this.getClass().getResource("/img.JPG");// ���ͼƬ·��
			ImageIcon icon = new ImageIcon(resource);// ����ͼƬ����
			PopupMenu popupMenu = new PopupMenu();// ���������˵�����
			MenuItem item = new MenuItem("�˳�");// �������˳����˵���Ŀ����
			// Ϊ�˵���Ŀ��Ӷ���������
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// �˳�ϵͳ
				}
			});
			popupMenu.add(item);// �����˳����˵���Ŀ��ӵ������˵���
			TrayIcon trayIcon = new TrayIcon(icon.getImage(), "ʹ��ϵͳ����",
					popupMenu);// ��������ͼƬ����
			// ���ϵͳ���̶���
			SystemTray systemTray = SystemTray.getSystemTray();
			systemTray.add(trayIcon);// ������ͼƬ��ӵ�ϵͳ������
		}
	}
	
}
