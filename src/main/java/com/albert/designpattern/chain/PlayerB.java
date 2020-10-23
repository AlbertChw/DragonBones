package com.albert.designpattern.chain;

/**
 * 具体处理者，传花人
 */
public class PlayerB extends Player {

    //构造方法,传入下一个传花人
    public PlayerB(Player successor) {
        this.setSuccessor(successor);
    }


    //传花的过程
    @Override
    public void handle(int i) {
        if (i==2){
            System.out.println("PlayerB 喝酒！");
        }else {
            System.out.println("PlayerB 向下传花！");
            next(i);
        }

    }
}