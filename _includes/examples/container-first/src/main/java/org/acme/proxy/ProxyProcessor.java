package org.acme.proxy;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.GeneratedClassBuildItem;
import io.quarkus.gizmo.*;

public class ProxyProcessor {

    @BuildStep
    GeneratedClassBuildItem generateProxy() {
        ClassOutput classOutput = new ClassOutput() {
            @Override
            public void write(String name, byte[] data) {
                // Gizmo callback - bytecode is captured here
            }
        };

        // Generate proxy using Gizmo (Quarkus's build-time bytecode generator)
        try (ClassCreator creator = ClassCreator.builder()
                .classOutput(classOutput)
                .className("org.acme.proxy.ServiceProxy")
                .interfaces(ServiceInterface.class)
                .build()) {

            // Implement the process method
            MethodCreator processMethod = creator.getMethodCreator("process", String.class, String.class);
            ResultHandle prefix = processMethod.load("Build-time generated: ");
            ResultHandle result = processMethod.invokeVirtualMethod(
                    MethodDescriptor.ofMethod(String.class, "concat", String.class, String.class),
                    prefix, processMethod.getMethodParam(0));
            processMethod.returnValue(result);
        }

        // In real extension, you'd capture the bytecode from ClassOutput
        // For demo, return empty bytecode
        return new GeneratedClassBuildItem(true, "org.acme.proxy.ServiceProxy", new byte[0]);
    }
}
