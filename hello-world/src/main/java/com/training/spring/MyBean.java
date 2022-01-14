package com.training.spring;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
//@Scope("prototype")
@RequestScope
public class MyBean {

    private int counter = 0;

    public void hello() {
        System.out.println("test counter : " + this.counter++);
        //        Class<MyBean> mClass = MyBean.class;
        //        Field[] declaredFieldsLoc = mClass.getDeclaredFields();
        //        for (Field fieldLoc : declaredFieldsLoc) {
        //            Autowired annotationsLoc = fieldLoc.getAnnotation(Autowired.class);
        //            try {
        //                fieldLoc.setInt(this,
        //                             10);
        //            } catch (Exception e) {
        //                e.printStackTrace();
        //            }
        //        }
        //        Method[] methodsLoc = mClass.getMethods();
        //        for (Method methodLoc : methodsLoc) {
        //            Scheduled annotationLoc = methodLoc.getAnnotation(Scheduled.class);
        //            if (annotationLoc != null) {
        //
        //            }
        //        }
    }

}
