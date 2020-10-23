package com.albert.designpattern.strategy;

/**
 * B计划
 */
public class BPlan extends StrategyForPlan {
    @Override
    public void plan() {
        System.out.println("执行B计划");
    }
}
