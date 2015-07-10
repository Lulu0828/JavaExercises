package com.xylu.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//对map、list、set分别进行遍历

public class Traverse {

	public static void main(String[] args) {

		// map遍历
		Map<String, Object> map = new HashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		System.out.println("map遍历：");
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		// list遍历
		List<Object> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println();
		System.out.println("list遍历：");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();

		// set遍历
		Set<Object> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		System.out.println();
		System.out.println("set遍历：");
		Iterator<Object> i = set.iterator();
		while (i.hasNext()) {
			Object o = i.next();
			System.out.println(o);
		}

	}

}
