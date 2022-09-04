package com.Advance.Swing.Tree;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.tree.*;

public class traverseTree extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultMutableTreeNode root;
	
	public static void main(String args[]) {
		traverseTree frame = new traverseTree();
		frame.setVisible(true);
	}
	
	public traverseTree() {
		super();
		setTitle("�������ڵ�");
		setBounds(100, 100, 290, 260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		root = new DefaultMutableTreeNode("ROOT");
		DefaultMutableTreeNode nodeFirstA = new DefaultMutableTreeNode(
				"FirstA");
		nodeFirstA.add(new DefaultMutableTreeNode("SecondAA"));
		nodeFirstA.add(new DefaultMutableTreeNode("SecondAB"));
		root.add(nodeFirstA);
		DefaultMutableTreeNode nodeFirstB = new DefaultMutableTreeNode(
				"FirstB");
		root.add(nodeFirstB);
		DefaultMutableTreeNode nodeFirstC = new DefaultMutableTreeNode(
				"FirstC");
		nodeFirstC.add(new DefaultMutableTreeNode("SecondCA"));
		DefaultMutableTreeNode nedeSecondCB = new DefaultMutableTreeNode(
				"SecondCB");
		nedeSecondCB.add(new DefaultMutableTreeNode("SecondCBA"));
		nedeSecondCB.add(new DefaultMutableTreeNode("SecondCBB"));
		nodeFirstC.add(nedeSecondCB);
		nodeFirstC.add(new DefaultMutableTreeNode("SecondCC"));
		root.add(nodeFirstC);
		JTree tree = new JTree(root);
		getContentPane().add(tree, BorderLayout.CENTER);
		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		getContentPane().add(panel, BorderLayout.EAST);
		final JButton button = new JButton("��ǰ������ڵ�");
		button.addActionListener(new ButtonActionListener("��ǰ�����"));
		panel.add(button);
		final JButton button_1 = new JButton("����������ڵ�");
		button_1.addActionListener(new ButtonActionListener("���������"));
		panel.add(button_1);
		final JButton button_2 = new JButton("�Թ�����ȱ���");
		button_2.addActionListener(new ButtonActionListener("�Թ�����ȱ���"));
		panel.add(button_2);
		final JButton button_3 = new JButton("��������ȱ���");
		button_3.addActionListener(new ButtonActionListener("��������ȱ���"));
		panel.add(button_3);
		final JButton button_4 = new JButton("����ֱ���ӽڵ�");
		button_4.addActionListener(new ButtonActionListener("�����ӽڵ�"));
		panel.add(button_4);
	}
	
	private class ButtonActionListener implements ActionListener {
		
		private String mode;
		
		public ButtonActionListener(String mode) {
			this.mode = mode;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Enumeration<?> enumeration;// �����ڵ�ö�ٶ���
			if (mode.equals("��ǰ�����"))
				// ��ǰ������������ڵ�
				enumeration = root.preorderEnumeration();
			else if (mode.equals("���������"))
				// ����������������ڵ�
				enumeration = root.postorderEnumeration();
			else if (mode.equals("�Թ�����ȱ���"))
				// �Թ�����ȱ����������ڵ�
				enumeration = root.breadthFirstEnumeration();
			else if (mode.equals("��������ȱ���"))
				// ��������ȱ����������ڵ�
				enumeration = root.depthFirstEnumeration();
			else
				enumeration = root.children(); // �����ýڵ���ӽڵ�
			while (enumeration.hasMoreElements()) {// �����ڵ�ö�ٶ���
				DefaultMutableTreeNode node;// ��ýڵ�
				node = (DefaultMutableTreeNode) enumeration.nextElement();
				// ���ݽڵ㼶�����ռλ��
				for (int l = 0; l < node.getLevel(); l++) {
					System.out.print("----");
				}
				System.out.println(node.getUserObject());// ����ڵ��ǩ
			}
			System.out.println();
			System.out.println();
		}
	}
	
}
