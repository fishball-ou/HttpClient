package oukq.ui;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class ProgressRenderer extends DefaultTableCellRenderer {
	/** */
	/**
*
*/
	private static final long serialVersionUID = 1L;
	private final JProgressBar b = new JProgressBar(0, 100);

	public ProgressRenderer() {
		super();
		setOpaque(true);
		b.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Integer i = (Integer) value;
		String text = "完成";
		if (i < 0) {
			//删除

			text = "取消完毕";
		} else if (i < 100) {
			b.setValue(i);
			return b;
		}
		super.getTableCellRendererComponent(table, text, isSelected, hasFocus,
				row, column);
		return this;
	}
}