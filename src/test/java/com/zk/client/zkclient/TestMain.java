package com.zk.client.zkclient;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestMain {

	@Test
	public void test() throws Exception {
		InetAddress[] allByName = InetAddress.getAllByName("localhost");
		for (InetAddress inetAddress : allByName) {
			System.out.println(inetAddress);
		}
	}
	
	@Test
	public void listPaths() {
		String path = "/a/b/c";
		String[] yuan = path.split("/");
		for (String string : yuan) {
			System.out.println(string);
		}
		List<String> listSubTreeBFS = new ArrayList<String>();
		String pt = "";
		for(int i = 1 ; i < yuan.length; i++) {
			String y = "/" + yuan[i];
			pt = pt + y;
			listSubTreeBFS.add(pt);
		}
		System.out.println(listSubTreeBFS);
	}
}
