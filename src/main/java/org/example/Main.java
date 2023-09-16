package org.example;

import java.util.ArrayList;

import static org.example.HelperClass.*;

public class Main {

	static class User{

		String name;
		int levelAccess;

		User(String name, int levelAccess){

			this.name = name;
			this.levelAccess = levelAccess;

		}

		User(){}

	}

	static class File{

		int levelAccess;

		File(int levelAccess){
			this.levelAccess = levelAccess;
		}

	}


	public static void main(String[] args) {

		File file = new File(2);
		File file1 = new File(0);
		File file2 = new File(2);
		File file3 = new File(1);
		File[] fileList = {file, file1, file2, file3};

		User bob = new User("bob", 0);
		User maks = new User("maks", 1);
		User dima = new User("dima", 2);

		ArrayList<User> userList = new ArrayList<>();
		userList.add(bob); userList.add(maks); userList.add(dima);

		int status = 0;
		User nowUser = null;

		while (true) {


			if(status == 0) {

				nowUser = authorization(userList);
				status = 1;

			} else if(status == 1) {

				printMenu(nowUser, fileList);
				nowUser = reader(nowUser, fileList);

				if(nowUser == null){
					status = 0;
				}

			}
		}

	}
}