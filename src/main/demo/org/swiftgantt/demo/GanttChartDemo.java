/*
 * Demo of the SwiftGantt
 * TODO
 * Created on 2008-12-28, 12:35:56
 */
package org.swiftgantt.demo;

import org.swiftgantt.demo.tab.ScheduleTab;
import org.swiftgantt.model.Task;
import org.swiftgantt.model.TaskTreeModel;
import org.swiftgantt.ui.TimeUnit;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 *
 * @author Anthenthat Happened
 */
public class GanttChartDemo extends javax.swing.JFrame {
	private static final long serialVersionUID = -2642571955243624522L;

	private org.swiftgantt.demo.tab.ScheduleTab scheduleTab;

	/** Creates new form Main */
	public GanttChartDemo() {
		initComponents();
		this.setTitle(this.getTitle());

		// Init for schedule tab
		scheduleTab = new ScheduleTab(this.ganttChartDemoComp);
		propertiesPane.addTab("Schedule", scheduleTab);
		propertiesPane.setMnemonicAt(0, KeyEvent.VK_1);

		// Configuration.
		System.out.println("[DEMO] Set new Config to the ScrollableGanttChart");
		ganttChartDemoComp.getConfig();

//		this.ganttChartDemoComp.initDailyModel();
//		TaskTreeModel taskTreeModel = this.ganttChartDemoComp.getGanttModel().getTaskTreeModel();
//		scheduleTab.setTaskTreeModel(taskTreeModel);

		// Init the Gantt Chart component
//		pnlContent.setLayout(new GridLayout());
//		pnlContent.add(ganttChartDemoComp, null);
//
//		List<Task> tasks = this.ganttChartDemoComp.getModel().getTasksByBFS();
//		if (tasks != null && tasks.size() > 2) {
//			this.ganttChartDemoComp.setSelectedTasks(tasks.get(0), tasks.get(2));
//		}
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		propertiesPane = new javax.swing.JTabbedPane();
		ganttChartDemoComp = new org.swiftgantt.demo.GanttChartDemoComponent();
		pnlContent = new javax.swing.JPanel();
		jSeparator1 = new javax.swing.JSeparator();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Demo for the SwiftGantt Java Swing component");

		org.jdesktop.layout.GroupLayout pnlContentLayout = new org.jdesktop.layout.GroupLayout(pnlContent);
		pnlContent.setLayout(pnlContentLayout);
		pnlContentLayout.setHorizontalGroup(pnlContentLayout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(0, 805, Short.MAX_VALUE));
		pnlContentLayout.setVerticalGroup(pnlContentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(0, 192, Short.MAX_VALUE));

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
						.add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup().addContainerGap()
								.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
										.add(org.jdesktop.layout.GroupLayout.LEADING, jSeparator1,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
										.add(org.jdesktop.layout.GroupLayout.LEADING, pnlContent,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.add(org.jdesktop.layout.GroupLayout.LEADING, propertiesPane,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE))
								.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
						.add(layout.createSequentialGroup().addContainerGap()
								.add(propertiesPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 313,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
								.add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 5,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(7, 7, 7)
								.add(pnlContent, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		if (args.length > 0) {
			Enum.valueOf(TimeUnit.class, args[0]);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GanttChartDemo().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private org.swiftgantt.demo.GanttChartDemoComponent ganttChartDemoComp;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JPanel pnlContent;
	private javax.swing.JTabbedPane propertiesPane;
	// End of variables declaration//GEN-END:variables
}
