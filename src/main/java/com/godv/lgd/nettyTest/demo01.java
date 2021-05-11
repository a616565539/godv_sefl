package com.godv.lgd.nettyTest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;

public class demo01 {

    public static void main(String[] args) {

        new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
    }
}
