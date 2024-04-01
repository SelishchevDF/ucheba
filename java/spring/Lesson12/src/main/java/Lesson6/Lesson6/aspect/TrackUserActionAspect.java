package Lesson6.Lesson6.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TrackUserActionAspect {

    @Around("@annotation(Lesson6.Lesson6.aspect.TrackUserAction)")
    public Object trackUserAction(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceed = joinPoint.proceed();

        System.out.println("method name: " + joinPoint.getSignature().toString() + " params: " + Arrays.toString(joinPoint.getArgs()));

        return proceed;
    }

}
