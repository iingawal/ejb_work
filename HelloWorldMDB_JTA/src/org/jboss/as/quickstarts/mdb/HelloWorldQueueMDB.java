package org.jboss.as.quickstarts.mdb;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@MessageDriven(name="HelloWorldQueueMDB",activationConfig={
		@ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destination",propertyValue="queue/HELLOWORLDMDBQueue"),
		@ActivationConfigProperty(propertyName="ackknowledgeMode",propertyValue="Auto-acknowledge"),
		@ActivationConfigProperty(propertyName="transactionTimeout",propertyValue="30")
})
public class HelloWorldQueueMDB implements MessageListener{

	private final static Logger log = Logger.getLogger(HelloWorldQueueMDB.class.toString());
	@Override
	public void onMessage(Message rcvMessage)  {
		// TODO Auto-generated method stub
	
		TextMessage msg = null;
		try {
			if (rcvMessage instanceof TextMessage) {
				msg = (TextMessage) rcvMessage;
				log.info("Received Message from queue :"+msg.getText());
				
			}
			else {
				log.warning("Message of wrong type"+ rcvMessage.getClass().getName());
			}
			
			InitialContext ctx = new InitialContext();
			com.test.TxTimeout remote = (com.test.TxTimeout) ctx.lookup("java:global/TestTxTimeoutEJB/TxTimeoutBean!com.test.TxTimeout");
			System.out.println(remote.welcomeMsg("Henry"));
			
		} catch (JMSException | NamingException e) {
			e.printStackTrace();
		}
		
		
	}

	
	
}
