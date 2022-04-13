package accessControl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class accessControlUser {

	private static accessControlGrpc.accessControlBlockingStub blockingStub;
	private static accessControlGrpc.accessControlStub asyncStub;

	public static void main(String[] args) {
		
		// build a channel - a channel connects the client to the server
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		
		// create a stubs, pass the channel to the stubs
		// stub is local representation of remote object (service)
		blockingStub = accessControlGrpc.newBlockingStub(channel);
		asyncStub = accessControlGrpc.newStub(channel);

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

	
	//Update
	 public static void authorization() { 
		// create request messages
		AuthorizationRequest authorizationRequest = AuthorizationRequest.newBuilder().setName("Daniel").build(); 
		// client streaming code
		// for incoming message implement a StreamObserver then pass the StreamObserver to the gRPC library
		StreamObserver<AuthorizationResponse> responseObserver = new StreamObserver<AuthorizationResponse>() {

			@Override
			public void onNext(AuthorizationResponse msg) {
				System.out.println("Receiving code " + msg.getResponseCode());		
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("Stream is completed ...");
			}
		};

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
		System.out.println("Response from Server: " + response);
	}		
}
