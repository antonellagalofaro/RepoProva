package api.share.training.model.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Logging {

	Logger logger;
	
	public Logging() {
		super();
		this.logger = LoggerFactory.getLogger(Logging.class);
	}
	
	
	public void forward(String level, String requestId, String sessionId, String actor, String X_TenantId, String entityId, String method, String uri, String msg, String payload) {
		
		String log = this.message(requestId, sessionId, actor, X_TenantId, entityId, method, uri, msg, payload);
		
		switch(level) {
			case "INFO": {
							this.logger.info( log );
						} break;
						
			case "ERROR": {
							this.logger.error( log );
						} break;
			
			case "DEBUG": {
							this.logger.debug( log );
						} break;
						
			case "WARN": {
							this.logger.warn( log );
						} break;
		
		}

	}
	
	private String message(String requestId, String sessionId, String actor, String X_TenantId, String entityId, String method, String uri, String msg, String payload) {
		return "["+requestId+"] ["+sessionId+"] ["+actor+"] ["+X_TenantId+"] ["+entityId+"] [book-management] ["+method+"] ["+uri+"] ["+msg+"] ["+payload+"]";
		
	}

}
