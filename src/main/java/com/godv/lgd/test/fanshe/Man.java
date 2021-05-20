package com.godv.lgd.test.fanshe;

/**
 * @program: lgd
 * @description: 男人
 * @author: GodV
 * @create: 2021-05-20 09:21
 **/

public class Man implements People{
    @Override
    public void sayHello() {
        System.out.println("hello,我是男人");
    }

    @Override
    public void sayBye() {
        System.out.println("byebye,我是男人");
    }


}
