package com.albert.designpattern.strategy;

/**
 * 测试类，上下文类
 */
public class ContextPlan {

    private StrategyForPlan strategyForPlan;

    public ContextPlan(StrategyForPlan strategyForPlan){
        this.strategyForPlan=strategyForPlan;
    }
    public  void actionPlan(){
        strategyForPlan.plan();
    }

    public static void main(String[] args){

        //制定出三种方案
        StrategyForPlan aPlan=new APlan();
        StrategyForPlan bPlan=new BPlan();
        StrategyForPlan cPlan=new CPlan();

        System.out.println("默认执行A计划");
       //执行A计划
        ContextPlan realPlan=new ContextPlan(aPlan);
        realPlan.actionPlan();

        System.out.println("情况有变需要执行B计划");
        //情况有变需要执行B计划
        realPlan=new ContextPlan(bPlan);//替换计划
        realPlan.actionPlan();//执行计划

        System.out.println("最终将贩毒团伙一网打尽。");
    }

}