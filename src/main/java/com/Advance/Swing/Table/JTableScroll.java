package com.Advance.Swing.Table;

import java.awt.*;
import javax.swing.*;

public class JTableScroll extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		JTableScroll frame = new JTableScroll();
		frame.setVisible(true);
	}
	
	public JTableScroll() {
		super();
		setTitle("�������Թ����ı��");
		setBounds(100, 100, 240, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] columnNames = { "A", "B" }; // ��������������
		// ��������������
		String[][] tableValues = { { "A1", "B1" }, { "A2", "B2" },
				{ "A3", "B3" }, { "A4", "B4" }, { "A5", "B5" } };
		// ����ָ�����������ݵı��
		JTable table = new JTable(tableValues, columnNames);
		// ������ʾ���Ĺ������
		JScrollPane scrollPane = new JScrollPane(table);
		// �����������ӵ��߽粼�ֵ��м�
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
