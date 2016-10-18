package de.tsystems.jschool.sample.domain;

import java.text.MessageFormat;

import org.apache.log4j.Logger;


public abstract class BaseEntity {
	
	private final Logger log = Logger.getLogger(BaseEntity.class);
	
	protected void writeInfoLogAboutMe(String className, String... fields ){

		log.info(MessageFormat.format("ClassName: {0}", className));
		for (String field : fields) {
			log.info(MessageFormat.format("Value: {0}", field));
		}
	}
	
	protected void writeDebugLogAboutMe(String className, String... fields ){

		log.debug(MessageFormat.format("ClassName: {0}", className));
		for (String field : fields) {
			log.debug(MessageFormat.format("Value: {0}", field));
		}
	}
}
