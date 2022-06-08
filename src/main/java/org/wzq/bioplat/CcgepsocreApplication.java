package org.wzq.bioplat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication()
public class CcgepsocreApplication {

    public static void main(String[] args) {
        ApplicationContext ap=SpringApplication.run(CcgepsocreApplication.class, args);
//        String[] beans = ap.getBeanDefinitionNames();
//
//        Arrays.sort(beans);
//
//        for (String bean : beans)
//
//        {
//            System.out.println(bean + " of Type :: " + ap.getBean(bean).getClass());
//        }
//        BeanFactory
    }

}
