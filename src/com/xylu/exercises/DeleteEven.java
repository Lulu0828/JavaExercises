package com.xylu.exercises;

import java.util.ArrayList;
import java.util.List;

public class DeleteEven {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			list.add(i + 1);
			System.out.println(list.get(i));
		}

		// 删除list中的偶数
		System.out.println();
		System.out.println("删除偶数后的list：");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				list.remove(i);
				i--;
				continue;
			}
			System.out.println(list.get(i));
		}
		
	}

}
