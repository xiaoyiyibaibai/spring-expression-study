package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author power
 * @date 2018/10/11 下午6:03
 */
public class Variables {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().build();

        Inventor inventor = new Inventor("Alice Miller", "America");
        simpleEvaluationContext.setVariable("newName", "Nikola Tesla");

        //Nikola Tesla
        parser.parseExpression("Name = #newName").getValue(simpleEvaluationContext, inventor);
        System.out.println(inventor.getName());

        //com.pow.study.spel.inventor.Inventor
        Object object = parser.parseExpression("#root").getValue(simpleEvaluationContext,inventor);
        System.out.println(object.getClass().getName());

        List<Integer> primes = new ArrayList<Integer>();
        primes.addAll(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41));
        simpleEvaluationContext.setVariable("primes", primes);
        //11, 13, 17, 19, 23, 29, 31, 37, 41]
        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression("#primes.?[#this>10]").getValue(simpleEvaluationContext);
        System.out.println(primesGreaterThanTen);
    }
}
