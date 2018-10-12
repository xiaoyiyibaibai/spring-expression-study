package com.pow.study.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.DataBindingPropertyAccessor;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author power
 * @date 2018/10/11 上午11:31
 */
public class LiteralExpressions {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();
        EvaluationContext standardEvaluationContext = new StandardEvaluationContext();

        // evals to "Hello World"
        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue(simpleEvaluationContext);
        System.out.println(helloWorld);

        double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue(simpleEvaluationContext);
        System.out.println(avogadrosNumber);

        // evals to 2147483647
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue(simpleEvaluationContext);
        System.out.println(maxValue);

        boolean trueValue = (Boolean) parser.parseExpression("true").getValue(simpleEvaluationContext);
        System.out.println(trueValue);

        Object nullValue = parser.parseExpression("null").getValue(simpleEvaluationContext);
        System.out.println(nullValue);
    }
}
