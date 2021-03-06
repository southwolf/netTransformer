package net.itransformers.xmlParameterFactory;


import net.itransformers.parameterfactoryapi.ParameterFactoryException;
import net.itransformers.parameterfactoryapi.ParameterFactoryManagerFactory;
import net.itransformers.parameterfactoryapi.ParameterFactoryManger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by niau on 1/10/17.
 */
public class XmlParameterManagerFactory implements ParameterFactoryManagerFactory {
    Map<String,String> properties;
    public XmlParameterManagerFactory(){

    }

    public XmlParameterManagerFactory(String xmlParameterFactoryFile,String xmlParameterFactoryTypesFile ) {
        properties = new HashMap<String, String>();
        properties.put("xmlParameterFactoryFile",xmlParameterFactoryFile);
        properties.put("xmlParameterFactoryTypesFile",xmlParameterFactoryTypesFile);
    }

    @Override
    public ParameterFactoryManger createParameterFactorysManager(Map<String, String> props) {
        String  projectPath = props.get("projectPath");
        if (projectPath==null){
            throw new ParameterFactoryException("Project path not specified!");
        }
        String  xmlParameterFactoryFile = properties.get("xmlParameterFactoryFile");
        String  xmlParameterFactoryTypesFile = properties.get("xmlParameterFactoryTypesFile");

        return new XmlParameterFactoryManager(new File(projectPath,xmlParameterFactoryFile),new File(projectPath,xmlParameterFactoryTypesFile));
    }
}
