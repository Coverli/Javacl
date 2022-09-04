package com.Advance.Swing.Table;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class tableWithTitle extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		try {
			tableWithTitle frame = new tableWithTitle();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public tableWithTitle() {
		super();
		setTitle("提供行标题栏的表格");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Vector<String> columnNameV = new Vector<>();
		columnNameV.add("日期");
		for (int i = 1; i < 21; i++) {
			columnNameV.add("商品" + i);
		}
		Vector<Vector<Object>> tableValueV = new Vector<>();
		for (int row = 1; row < 31; row++) {
			Vector<Object> rowV = new Vector<>();
			rowV.add(row);
			for (int col = 0; col < 20; col++) {
				rowV.add((int) (Math.random() * 1000));
			}
			tableValueV.add(rowV);
		}
		final MFixedColumnTable panel = new MFixedColumnTable(columnNameV,
				tableValueV, 1);
		getContentPane().add(panel, BorderLayout.CENTER);
	}
	
}
