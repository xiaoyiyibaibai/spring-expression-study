package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import com.pow.study.spel.inventor.Society;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author power
 * @date 2018/10/11 下午3:16
 */
public class MapTest {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();
        Map officers = new HashMap<String ,Inventor>();

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1856, 7, 9);
        Inventor inventor = new Inventor("Alice Miller", calendar.getTime(), "America");

        officers.put("president",inventor);
        simpleEvaluationContext.setVariable("Officers",officers);

        Inventor inventor1 = parser.parseExpression("#Officers['president']").getValue(simpleEvaluationContext, Inventor.class);
        System.out.println(inventor1.getName());
    }
}
