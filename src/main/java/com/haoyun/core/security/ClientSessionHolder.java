package com.haoyun.core.security;

public class ClientSessionHolder {

	static ThreadLocal<ClientSession> clientSessionList = new ThreadLocal<ClientSession>();

	public static void setClientSession(ClientSession clientSession) {
		clientSessionList.set(clientSession);
	}

	public static ClientSession getClientSession() {
		return (ClientSession) clientSessionList.get();
	}

}
