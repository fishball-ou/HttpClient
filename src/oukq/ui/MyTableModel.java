package oukq.ui;

import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/*
 * @author chenpeng
 * @email��ceponline@yahoo.com.cn
 * @version 0.1
 */
public class MyTableModel extends DefaultTableModel {
	/** */
	/**
*
*/
	private static final long serialVersionUID = 1L;
	private static final ColumnContext[] columnArray = {
			new ColumnContext("ID", Integer.class, false),
			new ColumnContext("名称", String.class, false),
			new ColumnContext("进度", Integer.class, false) };
	private final Map<Integer, SwingWorker> swmap = new HashMap<Integer, SwingWorker>();
	private int number = 0;

	public void addTest(Test t, SwingWorker worker) {
		Object[] obj = { new Integer(number), t.getName(), t.getProgress() };
		super.addRow(obj);
		swmap.put(number, worker);
		number++;
	}

	public synchronized SwingWorker getSwingWorker(int identifier) {
		Integer key = (Integer) getValueAt(identifier, 0);
		return swmap.get(key);
	}

	public Test getTest(int identifier) {
		return new Test((String) getValueAt(identifier, 1),
				(Integer) getValueAt(identifier, 2));
	}

	public boolean isCellEditable(int row, int col) {
		return columnArray[col].isEditable;
	}

	public Class<?> getColumnClass(int modelIndex) {
		return columnArray[modelIndex].columnClass;
	}

	public int getColumnCount() {
		return columnArray.length;
	}

	public String getColumnName(int modelIndex) {
		return columnArray[modelIndex].columnName;
	}

	private static class ColumnContext {
		public final String columnName;
		public final Class columnClass;
		public final boolean isEditable;

		public ColumnContext(String columnName, Class columnClass,
				boolean isEditable) {
			this.columnName = columnName;
			this.columnClass = columnClass;
			this.isEditable = isEditable;
		}
	}
}


