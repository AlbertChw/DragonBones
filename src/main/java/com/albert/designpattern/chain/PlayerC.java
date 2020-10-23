package com.albert.dragonbones.designpattern.chain;

/**
 * 具体处理者，传花人
 */
public class PlayerC extends Player {

    //构造方法,传入下一个传花人
    public PlayerC(Player successor) {
        this.setSuccessor(successor);
    }


    //传花的过程
    @Override
    public void handle(int i) {
        if (i==3){
            System.out.println("PlayerC 喝酒！");
        }else {
            System.out.println("PlayerC 向下传花！");
            next(i);
        }

    }
}