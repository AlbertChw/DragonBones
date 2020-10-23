package com.albert.dragonbones.designpattern.strategy;

/**
 * A计划
 */
public class APlan extends StrategyForPlan {
    @Override
    public void plan() {
        System.out.println("执行A计划");
    }
}