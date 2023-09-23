package com.webfirmframework.web.launcher;


import java.util.List;

import com.webfirmframework.ui.page.model.DocumentModel;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

/**
 * This is required by GraalVM native image
 * buildArgs:- --features=com.webfirmframework.web.launcher.GraalVMRuntimeReflectionRegistrationFeature
 */
public class GraalVMRuntimeReflectionRegistrationFeature implements Feature {


    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access) {
        try {

            //include the classes for GraalVM runtime reflection
            var classes = List.of(
                    DocumentModel.class);

            for (var eachClass : classes) {
                for (var each : eachClass.getDeclaredFields()) {
                    RuntimeReflection.register(each);
                }
                for (var each : eachClass.getDeclaredMethods()) {
                    RuntimeReflection.register(each);
                }
                for (var each : eachClass.getDeclaredConstructors()) {
                    RuntimeReflection.register(each);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
