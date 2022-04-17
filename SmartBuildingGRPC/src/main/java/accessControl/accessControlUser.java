package accessControl;

import javax.jmdns.ServiceInfo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class accessControlUser {

	private static accessControlGrpc.accessControlBlockingStub blockingStub;
	private static accessControlGrpc.accessControlStub asyncStub;

	public static void main(String[] args) {
		
		// JmDNS service discovery on the client side doesn't seem to work at all on macOS
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
	}

	
	// login
	public static void login() {
		// create request messages
		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("Daniel").setPassword("Java").build();
		// call the service and get a response back
		LoginResponse response = blockingStub.login(loginRequest);
		System.out.println("Response from Server: " + response);
	}

	
	//Update
	 public static void authorization() { 
		// create request messages
		AuthorizationRequest authorizationRequest = AuthorizationRequest.newBuilder().setName("Daniel").build(); 
		// client streaming code
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

			asyncStub.authorization(authorizationRequest, responseObserver);
			
		
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
		LogoutResponse response = blockingStub.logout(logoutRequest);
		System.out.println("\nResponse from Server: " + response);
	}		
}
