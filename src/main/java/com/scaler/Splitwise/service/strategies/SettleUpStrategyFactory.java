package com.scaler.Splitwise.service.strategies;

public class SettleUpStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategy(SettleUpStrategies strategyName){
        return new HeapBasedSettleUpStrategy();
    }
}
