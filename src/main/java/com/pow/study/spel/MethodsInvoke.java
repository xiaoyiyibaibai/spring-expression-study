package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import com.pow.study.spel.inventor.Society;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.GregorianCalendar;

/**
 * @author power
 * @date 2018/10/11 下午4:29
 */
public class MethodsInvoke {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        //EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().withInstanceMethods().build();

        Society ieee = new Society();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1856, 7, 9);
        Inventor inventor = new Inventor("Alice Miller", calendar.getTime(), "America");
        ieee.addMember(inventor);

        boolean isMember = parser.parseExpression("isMember('Alice Miller')").getValue(simpleEvaluationContext,ieee,Boolean.class);
        System.out.println(isMember);

        String subStr = (String) parser.parseExpression("'abc'.substring(1,3)").getValue(simpleEvaluationContext);
        System.out.println(subStr);

        //Exception in thread "main" org.springframework.expression.spel.SpelEvaluationException: EL1004E: Method call: Method staticMethod() cannot be found on com.pow.study.spel.inventor.Society type
        String invokeStr = (String) parser.parseExpression("staticMethod()").getValue(simpleEvaluationContext, ieee);
        System.out.println(invokeStr);
    }
}
