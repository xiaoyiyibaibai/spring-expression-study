package com.pow.study.spel;

import com.pow.study.spel.inventor.Inventor;
import com.pow.study.spel.inventor.PlaceOfBirth;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author power
 * @date 2018/10/11 下午12:15
 */
public class Properties {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1856, 7, 9);
        Inventor inventor = new Inventor("Alice Miller", calendar.getTime(), "America");
        PlaceOfBirth placeOfBirth = new PlaceOfBirth("NewYork", "America");
        inventor.setPlaceOfBirth(placeOfBirth);

        EvaluationContext simpleEvaluationContext = SimpleEvaluationContext.forReadWriteDataBinding().withRootObject(inventor).build();

        int year = (Integer) parser.parseExpression("birthdate.Year + 100").getValue(simpleEvaluationContext);
        System.out.println(year);

        String city = (String) parser.parseExpression("placeOfBirth.city").getValue(simpleEvaluationContext);
        System.out.println(city);
    }
}
