package airConditionControl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class ServiceRegistration {
	public void run(int port, String service_type, String service_name) {

		//get a jMDNS instance
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());			
			
			//service information							
			int service_port = port;
			String service_desc = "test integration of jmDNS with gRPC";				
			
			// create ServiceInfo
			// use the factory method to create the object			
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_desc);			
			
			// register the service			
			jmdns.registerService(serviceInfo);
			
			System.out.printf("jmDNS: registering service with type: %s and name: %s on port %d ", service_type, service_name, service_port);
			
			// sleep for 10 seconds
			Thread.sleep(10000);
			System.out.println("\njmDNS: Service Registered");
			// unregister the services
			//jmdns.unregisterAllServices();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}