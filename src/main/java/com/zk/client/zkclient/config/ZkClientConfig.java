package com.zk.client.zkclient.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZkClientConfig {
	
	@Value("${zk.connect-string}")
	private String connectString;
	
	@Value("${zk.path}")
	private String path;
	
	@Value("${zk.data-string}")
	private String data;
	
	@Value("${zk.session-timeout}")
	private Integer sessionTimeout = 2000;
	
	@Autowired
	private DefaultWatcher watcher;
	
	private ZooKeeper zooKeeper;
	
	@PostConstruct
	public void register() throws Exception, InterruptedException {
		this.zooKeeper = new ZooKeeper(connectString, sessionTimeout, watcher);
		List<String> znoodTree = listZnoodTree(path);
		for (String znoodPath : znoodTree) {
			Stat exists = zooKeeper.exists(znoodPath, false);
			if (exists == null) {
				zooKeeper.create(znoodPath, new byte[0], Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
		}
		zooKeeper.setData(path, data.getBytes(), -1);
	}
	
	private List<String> listZnoodTree(String path) {
		String[] yuan = path.split("/");
		List<String> tree = new ArrayList<String>();
		String pt = "";
		for(int i = 1 ; i < yuan.length; i++) {
			String y = "/" + yuan[i];
			pt = pt + y;
			tree.add(pt);
		}
		return tree;
	}
	
}
