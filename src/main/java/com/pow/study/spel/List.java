package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import com.pow.study.spel.inventor.Society;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.GregorianCalendar;
import java.util.Map;

/**
 * @author power
 * @date 2018/10/11 下午2:55
 */
public class List {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();
        Society ieee = new Society();

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1856, 7, 9);
        Inventor inventor = new Inventor("Alice Miller", calendar.getTime(), "America");

        ieee.addMember(inventor);

        String name = parser.parseExpression("Members[0].Name").getValue(simpleEvaluationContext, ieee, String.class);
        System.out.println(name);

    }
}
