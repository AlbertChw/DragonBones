package com.albert.designpattern.chain;

/**
 * 击鼓者
 * 测试类
 */
public class DrumBeater {

    public static void main(String args[]) {
        //创建一个链
        PlayerD playerD = new PlayerD(null);
        PlayerC playerC = new PlayerC(playerD);
        PlayerB playerB = new PlayerB(playerC);
        PlayerA playerA = new PlayerA(playerB);

        //击鼓三次下停下来
        playerA.handle(3);

    }
}