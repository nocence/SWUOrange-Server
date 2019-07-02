package com.swuorange.data;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;

public interface ActiveMQData {
	public static final Destination desrination = new ActiveMQQueue("swu");
}
