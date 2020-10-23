package com.albert.designpattern.chain;

/**
 * 具体处理者，传花人
 */
public class PlayerA extends Player {

    //构造方法,传入下一个传花人
    public PlayerA(Player successor) {
        this.setSuccessor(successor);
    }


    //传花的过程
    @Override
    public void handle(int i) {
        if (i==1){
            System.out.println("PlayerA 喝酒！");
        }else {
            System.out.println("PlayerA 向下传花！");
            next(i);
        }

    }
}
