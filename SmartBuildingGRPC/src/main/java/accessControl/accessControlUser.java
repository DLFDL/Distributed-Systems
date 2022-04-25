package accessControl;

import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class accessControlUser {

	private static accessControlGrpc.accessControlBlockingStub blockingStub;
	private static accessControlGrpc.accessControlStub asyncStub;

	public static void main(String[] args) throws InterruptedException {
		
		// jmDNS service discovery on the client side doesn't seem to work at all on macOS
		// the built-in zero-configuration networking service Bonjour in macOS is always running and is getting the packets
		// jmDNS assumes that it is the only daemon running on the machine listening on that port
		// because the code it's using deliberately binds to 0.0.0.0, no exception is thrown about the port being in use
		
		/**
		ServiceInfo serviceInfo;
		String service_type = "_accessControl._tcp.local";
		// now retrieve the service info - all we are supplying is the service type
		serviceInfo = ServiceDiscovery.runjmDNS(service_type);
		// use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = serviceInfo.getHostAddresses()[0];
		*/
		
		// build a channel - a channel connects the user to the server
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build(); //(host, port)
		
		// create a stubs, pass the channel to the stubs
		// stub is local representation of remote object (service)
		blockingStub = accessControlGrpc.newBlockingStub(channel);
		asyncStub = accessControlGrpc.newStub(channel);

		login();
		authorization();
		logout();
		
		try {
			channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	// login
	public static void login() {
		// create request messages
		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("Daniel").setPassword("Java").build();
		// call the service and get a response back
		// use catch the exception in a try-catch block and also access the Status object from the exception
		try {
			LoginResponse response = blockingStub.login(loginRequest);
		    System.out.println("Success Response from server: " + response.getResponseMessage()
		    + " with authentication code " + response.getResponseCode() + "\n");
		} catch (Exception e) {
		    Status status = Status.fromThrowable(e);
		    System.out.println(status.getCode() + " : " + status.getDescription());
		}
	}

	
	// authorisation
	 public static void authorization() { 
		// create request messages
		AuthorizationRequest authorizationRequest = AuthorizationRequest.newBuilder().setName("Daniel").build(); 
		// for incoming message implement a StreamObserver then pass the StreamObserver to the gRPC library
		StreamObserver<AuthorizationResponse> responseObserver = new StreamObserver<AuthorizationResponse>() {

			@Override
			public void onNext(AuthorizationResponse response) {
				System.out.println("The authorization security level received from the server is: " + response.getResponseCode());		
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("\nStreaming is now completed, thank you.");
			}};

			// use catch the exception in a try-catch block and also access the Status object from the exception
			try {
				asyncStub.authorization(authorizationRequest, responseObserver);
			} catch (Exception e) {
			    Status status = Status.fromThrowable(e);
			    System.out.println(status.getCode() + " : " + status.getDescription());
			}
		
			try {
				Thread.sleep(5000);
				} catch (InterruptedException e) {
			e.printStackTrace();
			}	
	}
	 
	  
	// logout
	public static void logout() {
		// create request messages
		LogoutRequest logoutRequest = LogoutRequest.newBuilder().setUsername("Daniel").build();
		// call the service and get a response back
		// use catch the exception in a try-catch block and also access the Status object from the exception
		try {
			LogoutResponse response = blockingStub.logout(logoutRequest);
		    System.out.println("\nSuccess Response from server: " + response.getResponseMessage()
		    + " with authentication code " + response.getResponseCode());
		} catch (Exception e) {
		    Status status = Status.fromThrowable(e);
		    System.out.println(status.getCode() + " : " + status.getDescription());
		}
	}		
}
