package com.study.basic;

/**
 * <Description>
 *
 * @author hushiye
 * @since 10/30/21 21:06
 */
public abstract class PengRen {

    public void zuofan(){
        fangyou();
        chaocai();
        chengcai();
    }

    protected abstract void chengcai();

    protected abstract void chaocai();

    protected abstract void fangyou();
}
