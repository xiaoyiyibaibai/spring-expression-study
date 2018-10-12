package com.pow.study.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * @author power
 * @date 2018/10/11 下午5:15
 */
public class LogicalOperators {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();

        // evaluates to false
        boolean boolValue1 = parser.parseExpression("true and false").getValue(simpleEvaluationContext, Boolean.class);
        System.out.println(boolValue1);

        // evaluates to false
        boolean boolValue2 = parser.parseExpression("!true").getValue(simpleEvaluationContext, Boolean.class);
        System.out.println(boolValue2);

        // evaluates to true
        boolean boolValue3 = parser.parseExpression("true or false").getValue(simpleEvaluationContext, Boolean.class);
        System.out.println(boolValue3);
    }
}
