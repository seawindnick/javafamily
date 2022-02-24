package com.study.basic;

/**
 * <Description>
 *
 * @author hushiye
 * @since 10/30/21 21:09
 */
public class ChaoQingCai extends PengRen {
    @Override
    protected void chengcai() {
        System.out.println("盛到盘子里面");
    }

    @Override
    protected void chaocai() {
        System.out.println("大火炒");
    }

    @Override
    protected void fangyou() {
        System.out.println("放大量油");
    }
}
