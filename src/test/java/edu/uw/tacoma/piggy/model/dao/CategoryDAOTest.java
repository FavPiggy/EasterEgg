package edu.uw.tacoma.piggy.model.dao;

import java.util.List;

import edu.uw.tacoma.piggy.model.entity.MemberEntity;
import edu.uw.tacoma.piggy.model.entity.MemberRoleEntity;
import edu.uw.tacoma.piggy.model.entity.ProjectEntity;
import edu.uw.tacoma.piggy.model.entity.RoleEntity;
import edu.uw.tacoma.piggy.model.entity.UserEntity;

public class CategoryDAOTest
{
	public static void main(String[] args)
	{

		List<UserEntity> list1 = UserDAO.listUser();		
		
		for(int i = 0; i < list1.size();i++) {
			System.out.println(list1.get(i));
		}
		
		System.out.println("==========");
		
		List<UserEntity> list2 = UserDAO.listUser("where FirstName = 'Cuong'");
		System.out.println(list2.get(0));
		UserEntity cuong = list2.get(0);
		
		System.out.println("==========");
		
		List<MemberEntity> listMem = MemberDAO.listMember("where MemberID = " + cuong.getUserID());
		for(int i = 0; i < listMem.size(); i++) {
			System.out.println(listMem.get(i));
		}
		
		List<ProjectEntity> cuongPro = ProjectDAO.listProject("where ProjectID = " + listMem.get(0).getProjectID());
		for(int i = 0; i < cuongPro.size(); i++) {
			System.out.println(cuongPro.get(i));
		}
		
		System.out.println("==========");
		
		List<MemberRoleEntity> listRole = MemberRoleDAO.listMemberRole("where MemberID = " + listMem.get(0).getMemberID());
		List<RoleEntity> role = RoleDAO.listRole("where RoleID = " + listRole.get(0).getRoleID());
		for(int i = 0; i < listRole.size(); i++) {
			System.out.println(role.get(i).getRoleName());
		}
		
		System.out.println("=============");
		
		
		List<MemberEntity> list = MemberDAO.listMember("where ProjectID = " + listMem.get(0).getProjectID());

		List<MemberRoleEntity> listRoleEnt = MemberRoleDAO.listMemberRole("where RoleID = 0");
		//List<MemberEntity> member  = MemberDAO.listMember("where MemberID = " + listRoleEnt.get(0).getMemberID());
		MemberEntity member = new MemberEntity();
		for(int i = 0; i <list.size(); i++) {
			if(list.get(i).getMemberID().equals(listRoleEnt.get(0).getMemberID())) {
				member = list.get(i);
			}
		}
		
	//	List<UserEntity> userPM = UserDAO.listUser("where UserID = " + member.get(0).getUserID());
		List<UserEntity> userPM = UserDAO.listUser("where UserID = " + member.getUserID());
		System.out.println(userPM.get(0).getFirstName() + userPM.get(0).getLastName() );
	}
		
}
