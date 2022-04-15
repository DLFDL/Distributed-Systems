package lightingControl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class lightingControlUser {

	private static lightingControlGrpc.lightingControlBlockingStub blockingStub;
	private static lightingControlGrpc.lightingControlStub asyncStub;

	public static void main(String[] args) {

		// build a channel - a channel connects the client to the server
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		
		// create a stubs, pass the channel to the stubs
		// stub is local representation of remote object (service)
		blockingStub = lightingControlGrpc.newBlockingStub(channel);
		asyncStub = lightingControlGrpc.newStub(channel);

		// create request messages for use within the main method
		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("Daniel").setPassword("Java").build();
		LogoutRequest logoutRequest = LogoutRequest.newBuilder().setUsername("Daniel").build();

		// call the login RPC from within main
		LoginResponse responseIn = blockingStub.login(loginRequest);
		System.out.println("Response from server: " + responseIn);

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
		System.out.println("Response from server: " + response);
	}
	  
	
	 // intensity
	public static void setIntensity() throws InterruptedException {
		// client streaming code
		// for incoming message implement a StreamObserver then pass the StreamObserver to the gRPC library
		StreamObserver<IntensityResponse> responseObserver = new StreamObserver<IntensityResponse>() {

			@Override
			public void onNext(IntensityResponse response) {
				System.out.println( "Final response from server: " + response.getResponseMessage()+ response.getResponseCode());			
			}

			@Override
			public void onError(Throwable t) {	
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed ...");
				IntensityResponse.Builder response = IntensityResponse.newBuilder();			  
				response.setResponseMessage("streaming is now completed");				
			}
		}; 
	 
			// gRPC library returns a StreamObserver to requestObserver, use for sending outgoing messages
	 		StreamObserver<IntensityRequest> requestObserver = asyncStub.setIntensity(responseObserver);
	 		
	 		try {
	 			requestObserver.onNext(IntensityRequest.newBuilder().setRequestCode(100).build());
	 			Thread.sleep(500);
	 			requestObserver.onNext(IntensityRequest.newBuilder().setRequestCode(1000).build());
	 			Thread.sleep(500);
	 			requestObserver.onNext(IntensityRequest.newBuilder().setRequestCode(10000).build());
	 			Thread.sleep(500);
	 			requestObserver.onNext(IntensityRequest.newBuilder().setRequestCode(100000).build());
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
		System.out.println("Response from server: " + response);
	}
}
