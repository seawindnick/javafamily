package com.study.basic;

/**
 * <Description>
 *
 * @author hushiye
 * @since 10/30/21 21:07
 */
public class ShuiZhuYu extends PengRen {
    @Override
    protected void chengcai() {
        System.out.println("盛到一个大盆里面");
    }

    @Override
    protected void chaocai() {
        System.out.println("加水，煮");
    }

    @Override
    protected void fangyou() {
        System.out.println("放少量油");
    }
}
