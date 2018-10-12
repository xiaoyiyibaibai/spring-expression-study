package com.pow.study.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * @author power
 * @date 2018/10/11 下午7:47
 */
public class Elvis {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();

        String name = "Elvis Presley";
        simpleEvaluationContext.setVariable("name", name);

        //Elvis Presley
        String string = parser.parseExpression("#name?:'Unknown'").getValue(simpleEvaluationContext, String.class);
        System.out.println(string);
    }
}
