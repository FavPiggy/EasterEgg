package edu.uw.tacoma.piggy.view.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.uw.tacoma.piggy.model.dao.MemberDAO;
import edu.uw.tacoma.piggy.model.entity.MemberEntity;

@SuppressWarnings("serial")
public class MemberTable
extends JTable
{
	private List<MemberEntity> entities;
	
	private DefaultTableModel model;
	private Object[] data;
	
	public MemberTable()
	{
		data = new Object[] { "MemberID", "ProjectID", "UserID", "DateJoined" };
		model = new DefaultTableModel(data, 0);
		
		setModel(model);
	}
	
	public void insert(MemberEntity entity)
	{
		MemberDAO.insert(entity);
		clearData();
		loadData();
	}
	
	public void update(MemberEntity entity)
	{
		MemberDAO.update(entity);
		clearData();
		loadData();
	}
	
	public void delete(MemberEntity entity)
	{
		MemberDAO.delete(entity);
		clearData();
		loadData();
	}
	
	public MemberEntity getData(int row)
	{
		return entities.get(row);
	}
	
	public void loadData()
	{
		entities = MemberDAO.listMember();
		for (MemberEntity entity : entities)
			addRow(entity);
	}
	
	public void clearData()
	{
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}
	
	private void addRow(MemberEntity entity)
	{
		data[0] = entity.getMemberID();
		data[1] = entity.getProjectID();
		data[2] = entity.getUserID();
		data[3] = entity.getDateJoined();
		model.addRow(data);
	}
	
	@Override
	public boolean isCellEditable(int row, int column)
	{  
        return false;  
    }
}


