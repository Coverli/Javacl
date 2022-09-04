package com.Advance.Swing.Other.JProgressBar;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class progressBar extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		progressBar frame = new progressBar();
		frame.setVisible(true);
	}
	
	public progressBar() {
		super();
		getContentPane().setLayout(new GridBagLayout());
		setTitle("ʹ�ý�����");
		setBounds(100, 100, 500, 375);
		setBounds(100, 100, 266, 132);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel label = new JLabel();
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("", Font.BOLD, 16));
		label.setText("��ӭʹ�������������ܣ�");
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridx = 0;
		getContentPane().add(label, gridBagConstraints);
		
		final JProgressBar progressBar = new JProgressBar();// ��������������
		progressBar.setStringPainted(true);// ������ʾ��ʾ��Ϣ
		progressBar.setIndeterminate(true);// ���ò��ò�ȷ��������
		progressBar.setString("����������......");// ������ʾ��Ϣ
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_1.gridy = 1;
		gridBagConstraints_1.gridx = 0;
		getContentPane().add(progressBar, gridBagConstraints_1);
		
		final JButton button = new JButton();
		button.setText("���");
		button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_2.gridy = 2;
		gridBagConstraints_2.gridx = 1;
		getContentPane().add(button, gridBagConstraints_2);
		new Progress(progressBar, button).start();// �����߳�ģ��һ��������������
	}
	
	class Progress extends Thread {// �����߳�ģ��һ��������������
		private final int[] progressValue = { 6, 18, 27, 39, 51, 66, 81,
				100 };// ģ��������ɰٷֱ�
		private JProgressBar progressBar;// ����������
		private JButton button;// ��ɰ�ť����
		
		public Progress(JProgressBar progressBar, JButton button) {
			this.progressBar = progressBar;
			this.button = button;
		}
		
		@Override
		public void run() {
			// ͨ��ѭ������������ɰٷֱ�
			for (int i = 0; i < progressValue.length; i++) {
				try {
					Thread.sleep(1000);// ���߳�����1��
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				progressBar.setValue(progressValue[i]);// ����������ɰٷֱ�
			}
			progressBar.setIndeterminate(false);// ���ò���ȷ��������
			progressBar.setString("������ɣ�");// ������ʾ��Ϣ
			button.setEnabled(true);// ���ð�ť����
		}
	}
}
