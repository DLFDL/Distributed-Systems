package airConditionControl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class airConditionControlUser {

	private static airConditionControlGrpc.airConditionControlBlockingStub blockingStub;
	private static airConditionControlGrpc.airConditionControlStub asyncStub;

	public static void main(String[] args) {
		
		// build a channel - a channel connects the client to the server
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();

		// create a stubs, pass the channel to the stubs
		// stub is local representation of remote object (service)
		blockingStub = airConditionControlGrpc.newBlockingStub(channel);
		asyncStub = airConditionControlGrpc.newStub(channel);

		// create Request messages for use within the main method
		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("Daniel").setPassword("Java").build();
		LogoutRequest logoutRequest = LogoutRequest.newBuilder().setUsername("Daniel").build();

		// call the login RPC from within main
		LoginResponse responseIn = blockingStub.login(loginRequest);
		System.out.println("Response from Server: " + responseIn);
		
		// call the logout RPC from within main
		LogoutResponse responseOut = blockingStub.logout(logoutRequest);
		System.out.println("Response from server: " + responseOut);
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
				System.out.println("Final response from server: " + response.getResponseCode() + response.getResponseMessage());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed ...");
				UpdateResponse.Builder response = UpdateResponse.newBuilder();
				response.setResponseMessage("stream is now completed ");				
			}
		};
		
			// gRPC library returns a StreamObserver to requestObserver, use for sending outgoing messages
			StreamObserver<UpdateRequest> requestObserver = asyncStub.update(responseObserver);
			try {
				requestObserver.onNext(UpdateRequest.newBuilder().setRequestMessage("1").build());
				Thread.sleep(500);
				requestObserver.onNext(UpdateRequest.newBuilder().setRequestMessage("2").build());
				Thread.sleep(500);
				requestObserver.onNext(UpdateRequest.newBuilder().setRequestMessage("3").build());
				Thread.sleep(500);
				requestObserver.onNext(UpdateRequest.newBuilder().setRequestMessage("4").build());
				Thread.sleep(500);
				
				System.out.println("User has now sent all masseges");
			
				// mark the end of requests
				requestObserver.onCompleted();

			
				Thread.sleep(5000);
			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	// logout
	public static void logout() {
		// create request messages
		LogoutRequest logoutRequest = LogoutRequest.newBuilder().setUsername("Daniel").build();
		// call the service and get a response back
		LogoutResponse response = blockingStub.logout(logoutRequest);
		System.out.println("Response from Server: " + response);
	}	
}
