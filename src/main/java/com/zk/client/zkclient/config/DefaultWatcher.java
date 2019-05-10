package com.zk.client.zkclient.config;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.stereotype.Service;

@Service
public class DefaultWatcher implements Watcher {

	@Override
	public void process(WatchedEvent event) {
		System.out.println(event);
	}

}
