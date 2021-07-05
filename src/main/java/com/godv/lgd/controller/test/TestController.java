package com.godv.lgd.controller.test;

import com.godv.lgd.pool.GodvThreadPool;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @program: lgd
 * @description: 测试Controller
 * @author: GodV
 * @create: 2021-05-18 11:48
 **/

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final GodvThreadPool godvThreadPool;

    @GetMapping("/paraller")
    public void paraller() {
        List<Integer> integers = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        List<CompletableFuture<Integer>> collect = integers.stream().map(e ->
                CompletableFuture.supplyAsync(() -> getInt(), godvThreadPool.getThreadPoolExecutor())).collect(Collectors.toList());

        List<Integer> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        int total = collect1.parallelStream().mapToInt(e -> e).sum();
        System.out.println(total);
    }

    public Integer getInt() {
        System.out.println(Thread.currentThread().getName());
        return 5;
    }

    @GetMapping("gcTest")
    public void gcTest() throws IOException {
        new Thread(()->{
            cas();
        }).start();
        new Thread(()->{
            cas();
        }).start();
//        new Thread(()->{
//            cas();
//        }).start();
//        new Thread(()->{
//            cas();
//        }).start();
        System.in.read();
    }

    public void cas(){
        while (true) {
            Byte[] bytes = new Byte[1024 * 1024];
        }
    }
}
