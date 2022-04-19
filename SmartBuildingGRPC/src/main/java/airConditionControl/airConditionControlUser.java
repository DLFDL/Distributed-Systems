package airConditionControl;

import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class airConditionControlUser {

	private static airConditionControlGrpc.airConditionControlBlockingStub blockingStub;
	private static airConditionControlGrpc.airConditionControlStub asyncStub;

	public static void main(String[] args) throws InterruptedException {
		
		// jmDNS service discovery on the client side doesn't seem to work at all on macOS
		// the built-in zero-configuration networking service Bonjour in macOS is always running and is getting the packets
		// jmDNS assumes that it is the only daemon running on the machine listening on that port
		// because the code it's using deliberately binds to 0.0.0.0, no exception is thrown about the port being in use
		
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
				System.out.println("\nStreaming is now completed, thank you.");
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
	 			Thread.sleep(2000);
	 			
				System.out.println("\nThe server now has sent all messages.");
				

	 			Thread.sleep(2000);
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
