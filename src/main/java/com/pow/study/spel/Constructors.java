package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author power
 * @date 2018/10/11 下午5:47
 */
public class Constructors {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();
        EvaluationContext standardEvaluationContext = new StandardEvaluationContext();

        //result : Albert Einstein
        Inventor inventor1 = parser.parseExpression("new com.pow.study.spel.inventor.Inventor('Albert Einstein', 'Germany')").getValue(standardEvaluationContext, Inventor.class);
        System.out.println(inventor1.getName());

        //Exception in thread "main" org.springframework.expression.spel.SpelEvaluationException: EL1002E: Constructor call: No suitable constructor found on type com.pow.study.spel.inventor.Inventor for arguments (java.lang.String,java.lang.String)
        Inventor inventor2 = parser.parseExpression("new com.pow.study.spel.inventor.Inventor('Alice Miller', 'America')").getValue(simpleEvaluationContext, Inventor.class);
        System.out.println(inventor2.getName());
    }
}
