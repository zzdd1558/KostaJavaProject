package com.team.order;

import java.util.Scanner;

import com.team.util.Service;

public class Orders {
	// order page
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Service ordersInfo = new OrdersInfoService();
		ordersInfo.exec(sc);
		
		
	}

}
