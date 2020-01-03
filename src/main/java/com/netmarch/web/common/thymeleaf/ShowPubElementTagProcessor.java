package com.netmarch.web.common.thymeleaf;

import com.netmarch.web.common.utils.CkeckSession;
import com.netmarch.web.common.utils.StringTemplateUtils;
import com.netmarch.web.system.bean.LoginUser;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.context.WebEngineContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;
import org.thymeleaf.templatemode.TemplateMode;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class ShowPubElementTagProcessor extends AbstractElementTagProcessor {
    private static final String TAG_NAME = "pub";
    private static final int PRECEDENCE = 1000;

    private static Map<String,String> map = new HashMap<>();


    static{
        map.put("USERNAME","<span>[USERNAME]</span>");
    }

    ShowPubElementTagProcessor(final String dialectPrefix) {
        super(
                TemplateMode.HTML,
                dialectPrefix,
                TAG_NAME,
                true,
                null,
                false,
                PRECEDENCE);
    }

    @Override
    protected void doProcess(
            final ITemplateContext context, final IProcessableElementTag tag,
            final IElementTagStructureHandler structureHandler) {
        final IEngineConfiguration configuration = context.getConfiguration();
        final IStandardExpressionParser parser =
                StandardExpressions.getExpressionParser(configuration);
        HttpSession sessoin  = ((WebEngineContext)context).getSession();
        final IStandardExpression typeExpression = parser.parseExpression(context, tag.getAttributeValue("type"));
        final String type = typeExpression.execute(context).toString();

        final IModelFactory modelFactory = context.getModelFactory();
        final IModel model = modelFactory.createModel();
        Map<String, String> data = new HashMap<String, String>();
        LoginUser user = CkeckSession.GET_USER_SESSION(sessoin);
        data.put("USERNAME",user.getName());
        model.addModel(modelFactory.parse(context.getTemplateData(), StringTemplateUtils.render(map.get(type),data)));
        structureHandler.replaceWith(model, false);
    }
}
