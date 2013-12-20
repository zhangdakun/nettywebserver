package com.cn.my.webserver;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class WebSocketServer {
    private final int port;

    public WebSocketServer(int port) {
        this.port = port;
    }

    public void run() {
        // Configure the server.
        ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));

        // Set up the event pipeline factory.
        bootstrap.setPipelineFactory(new WebSocketServerPipelineFactory());

        // Bind and start to accept incoming connections.
        InetSocketAddress sAddress = new InetSocketAddress(port);
        System.out.println(sAddress.getHostName());
        System.out.println(sAddress.getAddress().getHostAddress());
        bootstrap.bind(sAddress);

        System.out.println("Web socket server started at port " + port + '.');
        System.out.println("Open your browser and navigate to http://localhost:" + port + '/');
        
        System.out.println(sAddress);
        System.out.println(sAddress.getHostName());
        System.out.println(sAddress.getAddress().getHostAddress());
        
    }
}
