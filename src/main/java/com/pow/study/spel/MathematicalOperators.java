package com.pow.study.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * @author power
 * @date 2018/10/11 下午5:18
 */
public class MathematicalOperators {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();

        // Addition
        int add = parser.parseExpression("2 + 2").getValue(simpleEvaluationContext, Integer.class);
        System.out.println(add);

        // Subtraction
        int sub = parser.parseExpression("7 - 2").getValue(simpleEvaluationContext, Integer.class);
        System.out.println(sub);

        // Multiplication
        int mul = parser.parseExpression("6 * 3").getValue(simpleEvaluationContext, Integer.class);
        System.out.println(mul);

        // Division
        int div = parser.parseExpression("6 / 3").getValue(simpleEvaluationContext, Integer.class);
        System.out.println(div);

        // Modulus
        int mod = parser.parseExpression("6 % 3").getValue(simpleEvaluationContext, Integer.class);
        System.out.println(mod);

        // Operator precedence
        int result = parser.parseExpression("(3 + 5) / 2").getValue(simpleEvaluationContext, Integer.class);
        System.out.println(result);
    }
}
