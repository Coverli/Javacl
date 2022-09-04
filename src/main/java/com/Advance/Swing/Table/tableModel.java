package com.Advance.Swing.Table;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;

public class tableModel extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		tableModel frame = new tableModel();
		frame.setVisible(true);
	}
	
	public tableModel() {
		super();
		setTitle("���ģ������");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = { "A", "B" };// ��������������
		String[][] tableValues = { { "A1", "B1" }, { "A2", "B2" },
				{ "A3", "B3" } };// ��������������
		DefaultTableModel tableModel = new DefaultTableModel(tableValues,
				columnNames);// ����ָ����������ͱ�����ݵı��ģ��
		JTable table = new JTable(tableModel);// ����ָ�����ģ�͵ı��
		table.setRowSorter(new TableRowSorter<>(tableModel));
		scrollPane.setViewportView(table);
	}
	
}
