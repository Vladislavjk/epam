package by.training.task07.service.factory;

import by.training.task07.bean.TextComponent;
import by.training.task07.dao.DaoException;
import by.training.task07.dao.Reader;
import by.training.task07.service.ServiceException;
import by.training.task07.service.parser.Handler;
import by.training.task07.service.parser.impl.ParagraphParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextFactory {
    private static final Logger logger = LogManager.getLogger(TextFactory.class);
    private static TextFactory factory;
    public static final Reader reader = new Reader();
    public static final Handler handler = new ParagraphParser();

    private TextFactory() {

    }

    public static TextFactory getInstance() {
        if(factory == null) {
            factory = new TextFactory();
            logger.info("Factory created");
        }
        return factory;
    }

    public TextComponent createComposite(String fileName) throws ServiceException {
        logger.info("Creating composite from file {}.", fileName);
        try {
            String data = reader.read(fileName);
            return handler.handleRequest(data);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
