package com.Advance.Swing.Other.JSplitPane;

import java.awt.*;

import javax.swing.*;
public class splitPane extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String args[]) {
		splitPane frame = new splitPane();
		frame.setVisible(true);
	}
	public splitPane() {
		super();
		setTitle("�ָ����");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����һ��ˮƽ����ķָ����
		final JSplitPane hSplitPane = new JSplitPane();
		// �ָ������Ŀ��Ϊ40����
		hSplitPane.setDividerLocation(40);
		// ��ӵ�ָ������
		getContentPane().add(hSplitPane, BorderLayout.CENTER);
		// ��ˮƽ���������һ����ǩ���
		hSplitPane.setLeftComponent(new JLabel("      1"));
		// ����һ����ֱ����ķָ����
		final JSplitPane vSplitPane = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT);
		// �ָ����Ϸ��ĸ߶�Ϊ30����
		vSplitPane.setDividerLocation(30);
		vSplitPane.setDividerSize(8);// �ָ����Ŀ��Ϊ8����
		vSplitPane.setOneTouchExpandable(true);// �ṩUIС����
		// �ڵ����ָ���λ��ʱ�����ػ淽ʽΪ��������
		vSplitPane.setContinuousLayout(true);
		hSplitPane.setRightComponent(vSplitPane);// ��ӵ�ˮƽ�����Ҳ�
		// �ڴ�ֱ����Ϸ����һ����ǩ���
		vSplitPane.setLeftComponent(new JLabel("      2"));
		// �ڴ�ֱ����·����һ����ǩ���
		vSplitPane.setRightComponent(new JLabel("      3"));
	}
}
