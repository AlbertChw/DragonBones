package com.albert.designpattern.chain;

/**
 * 抽象处理者
 */
public abstract class Player {

    //具体的传花人
    private Player successor;

    //传入下一个具体的传花人
    protected void setSuccessor(Player successor) {
        this.successor = successor;
    }

    //传递的过程
    public abstract void handle(int i);

    //传递給下一个
    public void next(int index) {
        if (successor != null) {
            successor.handle(index);
        } else {
            System.out.println("游戏结束！");
        }
    }

}