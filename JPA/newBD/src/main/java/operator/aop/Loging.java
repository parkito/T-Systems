package operator.aop;

/**
 * Created by Artyom Karnov on 9/30/16.
 * artyom-karnov@yandex.ru
 **/

import operator.entities.User;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//import org.apache.logging.log4j.Logger;

@Aspect
public class Loging {
    private static final Logger logger = Logger.getLogger(Loging.class);


    @Pointcut("execution(* operator.services.api.create*(*))")
    public void createEntityPointcut() {
    }

    @Pointcut("execution(* operator.services.api.get*(..))")
    public void getEntityPointcut() {
    }

    @Pointcut("execution(* operator.services.api.update*(*))")
    public void updateEntityPointcut() {
    }

    @Pointcut("execution(* operator.services.api.delete*(*))")
    public void deleteEntityPointcut() {
    }


    @Before("createEntityPointcut()")
    public void loggingBeforeCreateActionAdvice(JoinPoint joinPoint) {
        logger.info(String.format("A method: {%s} is invoking, arguments: {%s}",
                joinPoint.toString(), Arrays.toString(joinPoint.getArgs())));
    }

    @After("createEntityPointcut()")
    public void loggingAfterCreateActionAdvice(JoinPoint joinPoint) {
        logger.info(String.format("Entity %s is created", Arrays.toString(joinPoint.getArgs())));
    }

    @Before("getEntityPointcut()")
    public void loggingBeforeGetActionAdvice(JoinPoint joinPoint) {
        logger.info(String.format("A method: {%s} is invoking, arguments: {%s}",
                joinPoint.toString(), Arrays.toString(joinPoint.getArgs())));
    }

    @AfterReturning(pointcut = "getEntityPointcut()", returning = "user")
    public void loggingAfterGetActionAdvice(User user) {
        logger.info(String.format("Entity %s has been found", user));
    }

    @Before("updateEntityPointcut()")
    public void loggingBeforeUpdateActionAdvice(JoinPoint joinPoint) {
        logger.info(String.format("A method: {%s} is invoking, arguments: {%s}",
                joinPoint.toString(), Arrays.toString(joinPoint.getArgs())));
    }

    @After("updateEntityPointcut()")
    public void loggingAfterUpdateActionAdvice(JoinPoint joinPoint) {
        logger.info(String.format("Entity %s is updated", Arrays.toString(joinPoint.getArgs())));
    }

    @Before("deleteEntityPointcut()")
    public void loggingBeforeDeleteActionAdvice(JoinPoint joinPoint) {
        logger.info(String.format("A method: {%s} is invoking, arguments: {%s}",
                joinPoint.toString(), Arrays.toString(joinPoint.getArgs())));
    }

    @After("deleteEntityPointcut()")
    public void loggingAfterDeleteActionAdvice(JoinPoint joinPoint) {
        logger.info(String.format("Entity %s is deleted", Arrays.toString(joinPoint.getArgs())));
    }

    @AfterThrowing(value = "execution(* operator.services.*(..))", throwing = "ex")
    public void logExceptions(JoinPoint joinPoint, Exception ex) {
        logger.error(String.format("Exception was thrown at the method: %s with message {%s}",
                joinPoint.toString(), ex.getMessage()));
        logger.error("The stack trace is below");
        for (StackTraceElement b : ex.getStackTrace()) {
            logger.error("at " + b);
        }
    }


}
