package net.itransformers.resourcemanager.xmlResourceManager;

import net.itransformers.resourcemanager.ResourceManager;
import net.itransformers.resourcemanager.ResourceManagerFactory;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by vasko on 9/30/2016.
 */
public class XmlResourceManagerFactory implements ResourceManagerFactory {
    Logger logger = Logger.getLogger(XmlResourceManagerFactory.class);
    String resourceRelativePath;

    public XmlResourceManagerFactory(String resourceRelativePath) {
        this.resourceRelativePath = resourceRelativePath;
    }

    @Override
    public ResourceManager createResourceManager(String type, Map<String, String> properties) {
        String projectPath = properties.get("projectPath");
        if (projectPath == null) {
            throw new IllegalArgumentException("Missing projectPath parameter");
        }
        FileBasedResourceManager fileBasedResourceManager = new FileBasedResourceManager(projectPath + File.separator+resourceRelativePath);
        try {
            fileBasedResourceManager.load();
        } catch (IOException | JAXBException e ) {
            logger.error(e.getMessage(), e);
        }
        return fileBasedResourceManager;
    }
}
