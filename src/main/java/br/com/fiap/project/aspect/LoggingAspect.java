package br.com.fiap.project.aspect;

import br.com.fiap.project.service.LogNotificacoesService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    /*
    Este LoggingAspect será utilizado para que toda vez que for utilizado um create, delete ou update.
    Seja criado um registro no banco dizendo, qual a data/hora e operação feita
     */
    @Autowired
    private LogNotificacoesService logNotificacoesService;

    @After("execution(* br.com.fiap.project.controller.*.create*(..))")
    public void logAfterCreate(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        logNotificacoesService.createLog("CREATE", className);
    }

    @After("execution(* br.com.fiap.project.controller.*.update*(..))")
    public void logAfterUpdate(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        logNotificacoesService.createLog("UPDATE", className);
    }

    @After("execution(* br.com.fiap.project.controller.*.delete*(..))")
    public void logAfterDelete(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        logNotificacoesService.createLog("DELETE", className);
    }
}
