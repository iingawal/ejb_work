package test.standalone.ejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.ing.ejb.ejbtestcase.TestClusterInf;
import org.jboss.ejb.client.ContextSelector;
import org.jboss.ejb.client.EJBClientConfiguration;
import org.jboss.ejb.client.EJBClientContext;
import org.jboss.ejb.client.PropertiesBasedEJBClientConfiguration;
import org.jboss.ejb.client.remoting.ConfigBasedEJBClientContextSelector;

public class MainClient {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub


        Properties p = new Properties();
        p.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
        p.put("remote.connections", "one");
        p.put("remote.connection.one.port", "8080");
        p.put("remote.connection.one.host", "localhost");
        p.put("remote.connection.one.username", "user");
        p.put("remote.connection.one.password", "password");

        p.put("remote.clusters", "ejb");
        p.put("remote.cluster.ejb.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false"); 
        p.put("remote.cluster.ejb.username", "user");
        p.put("remote.cluster.ejb.password", "password");
        
        EJBClientConfiguration cc = new PropertiesBasedEJBClientConfiguration(p);
        ContextSelector<EJBClientContext> selector = new ConfigBasedEJBClientContextSelector(cc);
        EJBClientContext.setSelector(selector);

        Properties props = new Properties();
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        InitialContext context = new InitialContext(props);

        final String rcal = "ejb:/ejbtestcase/TestClusterBean!org.ing.ejb.ejbtestcase.TestClusterInf";
        final TestClusterInf remote = (TestClusterInf) context.lookup(rcal);
        final String result = remote.sayHello(9);

        System.out.println("sayHello succeed: " + result);
		
	}

}
