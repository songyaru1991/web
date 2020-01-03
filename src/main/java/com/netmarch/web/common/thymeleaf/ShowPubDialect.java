package com.netmarch.web.common.thymeleaf;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

@Component
public class ShowPubDialect extends AbstractProcessorDialect {
    private static final String DIALECT_NAME = "show dialect";

    public ShowPubDialect() {
        super(DIALECT_NAME, "show", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(final String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new ShowPubElementTagProcessor(dialectPrefix));
        return processors;
    }
}
