package com.pow.study.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;

/**
 * @author power
 * @date 2018/10/11 下午3:39
 */
public class InlineLists {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();

        java.util.List numbers = (java.util.List) parser.parseExpression("{1,2,3,4,5}").getValue(simpleEvaluationContext);
        System.out.println(numbers.get(3)+"~");

        java.util.List listOfLists = (java.util.List) parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(simpleEvaluationContext);
        System.out.println(((List)listOfLists.get(1)).get(1));
    }
}
