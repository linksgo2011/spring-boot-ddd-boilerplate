package org.domaindrivendesign.boilerplate.config;

import com.google.common.base.Optional;
import org.domaindrivendesign.boilerplate.core.ErrorCode;
import org.domaindrivendesign.boilerplate.core.model.ErrorModel;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
public class SimpleErrorCodePlugin implements OperationBuilderPlugin {

    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    @Override
    public void apply(OperationContext context) {
        Optional<ApiError> annotationOptional = context.findAnnotation(ApiError.class);

        if (!annotationOptional.isPresent()) {
            return;
        }
        ApiError annotation = annotationOptional.get();
        ErrorCode[] codes = annotation.codes();

        // Group
        HashMap<Integer, List<ErrorCode>> groupedCodes = new HashMap<>();
        for (Integer i = 0; i < codes.length; i++) {
            Integer statusCode = codes[i].getStatusCode();
            if (!groupedCodes.containsKey(statusCode)) {
                ArrayList<ErrorCode> oneGroup = new ArrayList();
                oneGroup.add(codes[i]);
                groupedCodes.put(statusCode, oneGroup);
            } else {
                groupedCodes.get(statusCode).add(codes[i]);
            }
        }

        Set<ResponseMessage> responseMessages = newHashSet();
        for (Integer statusCode : groupedCodes.keySet()) {
            List<ErrorCode> errorCodes = groupedCodes.get(statusCode);

            ModelRef errorModel = new ModelRef(ErrorModel.class.getSimpleName());
            String message = "allow code: " + Arrays.asList(errorCodes).toString();

            responseMessages.add(new ResponseMessageBuilder()
                    .code(statusCode)
                    .message(message)
                    .responseModel(errorModel)
                    .build());
        }

        context.operationBuilder().responseMessages(responseMessages);
    }
}
