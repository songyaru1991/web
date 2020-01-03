package com.netmarch.web.common.thymeleaf;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;


/**
 * 自定义角色权限验证标签
 * auth
 */
@Component
public class AuthDialect extends AbstractProcessorDialect {

    private  static final String PREFIX="Dialect";

    public AuthDialect() {
        super(PREFIX, "auth", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(final String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new AuthElementTagProcessor(dialectPrefix));
        return processors;
    }


}
