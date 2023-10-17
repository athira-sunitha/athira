package com.Athira.kelexam;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class WrapCellRenderer extends JTextArea implements TableCellRenderer {

	public WrapCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
    }
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		setText(value.toString());
        setFont(new Font("Times New Roman", Font.PLAIN, 15));
        if (isSelected)
        {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        }
        else
        {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }
        setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
		
		  if (table.getRowHeight(row)< getPreferredSize().height) {
		  table.setRowHeight(row, getPreferredSize().height); }
		 
        return this;
	}

}
