package edu.uw.tacoma.piggy.model.dao;

import java.util.List;

import edu.uw.tacoma.piggy.model.entity.MemberEntity;
import edu.uw.tacoma.piggy.model.entity.MemberRoleEntity;
import edu.uw.tacoma.piggy.model.entity.ProjectEntity;
import edu.uw.tacoma.piggy.model.entity.RoleEntity;
import edu.uw.tacoma.piggy.model.entity.UserEntity;

public class SampleQuery
{
	public static void main(String[] args)
	{
		System.out.println("\n=============> 1. List all users");
		
		List<UserEntity> list1 = UserDAO.listUser();

		for (int i = 0; i < list1.size(); i++)
		{
			UserEntity user = list1.get(i);
			System.out.println(user.getFirstName() + " " + user.getLastName());
		}

		System.out.println("=============> 2. Print the user with the first name 'Cuong'");

		List<UserEntity> list2 = UserDAO.listUser("where FirstName = 'Cuong'");
		UserEntity cuong = list2.get(0);
		System.out.println(cuong.getFirstName() + " " + cuong.getLastName());

		System.out.println("=============> 3. Print the projects that 'Cuong' is working on");

		List<MemberEntity> listMem = MemberDAO.listMember("where MemberID = " + cuong.getUserID());
//		for (int i = 0; i < listMem.size(); i++)
//		{
//			System.out.println(listMem.get(i));
//		}

		List<ProjectEntity> cuongProjects = ProjectDAO.listProject("where ProjectID = " + listMem.get(0).getProjectID());
		for (int i = 0; i < cuongProjects.size(); i++)
		{
			ProjectEntity CuongProject = cuongProjects.get(i);
			System.out.println(CuongProject.getProjectName());
		}

		System.out.println("=============> 4. What is the role of 'Cuong' in that project");

		List<MemberRoleEntity> listRole = MemberRoleDAO.listMemberRole("where MemberID = " + listMem.get(0).getMemberID());
		List<RoleEntity> role = RoleDAO.listRole("where RoleID = " + listRole.get(0).getRoleID());
		for (int i = 0; i < listRole.size(); i++)
		{
			System.out.println(role.get(i).getRoleName());
		}

		System.out.println("=============> 5. Who is PM in the project that 'Cuong' working on");

		List<MemberEntity> list = MemberDAO.listMember("where ProjectID = " + listMem.get(0).getProjectID());

		List<RoleEntity> listrole = RoleDAO.listRole("where RoleName='Project Manager'");
		RoleEntity PM = listrole.get(0);
		
		List<MemberRoleEntity> listRoleEnt = MemberRoleDAO.listMemberRole("where RoleID = " + PM.getRoleID());
		// List<MemberEntity> member = MemberDAO.listMember("where MemberID = "
		// + listRoleEnt.get(0).getMemberID());
		MemberEntity member = new MemberEntity();
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getMemberID().equals(listRoleEnt.get(0).getMemberID()))
			{
				member = list.get(i);
			}
		}

		// List<UserEntity> userPM = UserDAO.listUser("where UserID = " +
		// member.get(0).getUserID());
		List<UserEntity> userPM = UserDAO.listUser("where UserID = " + member.getUserID());
		UserEntity kirt = userPM.get(0);
		System.out.println(kirt.getFirstName() + " " + kirt.getLastName());
	}
}
