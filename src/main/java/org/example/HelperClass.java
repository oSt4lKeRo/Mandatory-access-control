package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.SortedMap;

import org.example.Main.*;

public class HelperClass {

	public static User authorization(ArrayList<User> userList) {

		while (true) {

			System.out.print("Введите логин пользователя: ");
			Scanner scanner = new Scanner(System.in);
			String name = "";
			try {
				name = scanner.nextLine();
			} catch (Exception e) {
				System.err.println("Допущена ошибка");
			}

			for (int i = 0; i < userList.size(); i++) {

				if (userList.get(i).name.equals(name)) {

					return userList.get(i);

				}

			}

			System.out.println("Пользователь не найден");

		}
	}

	public static boolean checlAccess(User user, File file){

		if(user.levelAccess >= file.levelAccess){
			return true;
		} else {
			return false;
		}
	}


	public static User reader(User user, File[] fileList){

		System.out.print("Ваш выбор: ");
		Scanner scanner = new Scanner(System.in);
		String result = scanner.nextLine();
		System.out.println();

		if(result.equals("quit")) {

			System.out.println("Вы успешно вышли из аккаунта\n");
			return null;

		} else {

			switch (result) {

				case ("0"):
					if (checlAccess(user, fileList[0])) {
						System.out.println("Операция выполнена успешно");
					} else {
						System.out.println("Доступ запрещен");
					}
					break;
				case ("1"):
					if (checlAccess(user, fileList[1])) {
						System.out.println("Операция выполнена успешно");
					} else {
						System.out.println("Доступ запрещен");
					}
					break;
				case ("2"):
					if (checlAccess(user, fileList[2])) {
						System.out.println("Операция выполнена успешно");
					} else {
						System.out.println("Доступ запрещен");
					}
					break;
				case ("3"):
					if (checlAccess(user, fileList[3])) {
						System.out.println("Операция выполнена успешно");
					} else {
						System.out.println("Доступ запрещен");
					}
					break;
			}
			System.out.println();
			return user;
		}
	}


	public static void printMenu(User user, File[] fileList){

		System.out.println("Вам доступны: ");
		for(int i = 0; i < fileList.length; i++){

			if(checlAccess(user, fileList[i])){

				System.out.println("Обект " + i);

			}

		}
		System.out.println("Для выхода введите: quit\n");

	}

}
