package com.albert.designpattern.strategy;

/**
 * C计划
 */
public class CPlan extends StrategyForPlan {
    @Override
    public void plan() {
        System.out.println("执行C计划");
    }
}