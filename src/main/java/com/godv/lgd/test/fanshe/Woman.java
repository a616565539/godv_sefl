package com.godv.lgd.test.fanshe;

/**
 * @program: lgd
 * @description: 女人
 * @author: GodV
 * @create: 2021-05-20 09:22
 **/

public class Woman implements People{
    @Override
    public void sayHello() {
        System.out.println("hello,我是女人");
    }

    @Override
    public void sayBye() {
        System.out.println("byebye,我是女人");
    }
}
