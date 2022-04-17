package airConditionControl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class airConditionControlUser {

	private static airConditionControlGrpc.airConditionControlBlockingStub blockingStub;
	private static airConditionControlGrpc.airConditionControlStub asyncStub;

	public static void main(String[] args) throws InterruptedException {
		
		// JmDNS service discovery on the client side doesn't seem to work at all on macOS
		/**
		ServiceInfo serviceInfo;
		String service_type = "_airConditionControl._tcp.local";
		// now retrieve the service info - all we are supplying is the service type
		serviceInfo = ServiceDiscovery.runjmDNS(service_type);
		// use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = serviceInfo.getHostAddresses()[0];
		*/
		
		// build a channel - a channel connects the user to the server
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build(); //(host, port)

		// create a stubs, pass the channel to the stubs
		// stub is local representation of remote object (service)
		blockingStub = airConditionControlGrpc.newBlockingStub(channel);
		asyncStub = airConditionControlGrpc.newStub(channel);

		login();
		update();
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
	
	
	// update
	public static void update() throws InterruptedException {
		// client streaming code
		// for incoming message implement a StreamObserver then pass the StreamObserver to the gRPC library
		StreamObserver<UpdateResponse> responseObserver = new StreamObserver<UpdateResponse>() {

			@Override
			public void onNext(UpdateResponse response) {
				System.out.println("The updated code send by the server is: " + response.getResponseCode());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {	
				System.out.println("Streaming is now completed, thank you.");
			}
		};
		
			// gRPC library returns a StreamObserver to requestObserver, use for sending outgoing messages
			StreamObserver<UpdateRequest> requestObserver = asyncStub.update(responseObserver);
			try {
				requestObserver.onNext(UpdateRequest.newBuilder().setRequestCode(11).build());
				Thread.sleep(2000);
				requestObserver.onNext(UpdateRequest.newBuilder().setRequestCode(22).build());
				Thread.sleep(2000);
				requestObserver.onNext(UpdateRequest.newBuilder().setRequestCode(33).build());
				Thread.sleep(2000);
				requestObserver.onNext(UpdateRequest.newBuilder().setRequestCode(44).build());
				Thread.sleep(2000);
				
				// mark the end of requests
	 			requestObserver.onCompleted();
	 			
				System.out.println("\nThe server now has sent all messages.");
				Thread.sleep(2000);

	 			Thread.sleep(5000);
			} catch (RuntimeException e) {
				requestObserver.onError(e);
		        throw e;
			} catch (InterruptedException e) {
				e.printStackTrace();
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
		LogoutResponse response = blockingStub.logout(logoutRequest);
		System.out.println("\nResponse from server: " + response);
	}	
}
