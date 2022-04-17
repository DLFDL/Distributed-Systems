package airConditionControl;

import java.io.IOException;

import airConditionControl.airConditionControlGrpc.airConditionControlImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class airConditionControlServer extends airConditionControlImplBase{

	// extend abstract base class for implementation
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		airConditionControlServer airconditioncontrolserver = new airConditionControlServer();

		//service information	
		int port = 50053;
		String service_type = "_airConditionControl._tcp.local";
		String service_name = "gRPC airConditionControlServer";
		ServiceRegistration serviceregistration = new ServiceRegistration();
		serviceregistration.run(port, service_type, service_name);

		try {
			Server server = ServerBuilder.forPort(port)
					.addService(airconditioncontrolserver)
					.build()
					.start();

			System.out.println("\ngRPC accessControl server started successfully");
		    server.awaitTermination();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	// login
	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
		// find out what was sent by the user
		String username = request.getUsername();
		String password = request.getPassword();

		// now build response
		LoginResponse.Builder response = LoginResponse.newBuilder();
		System.out.println("\nLogged in user is " + username + ", and password is " + password);
		
		// return success response
		if (username.equals("Daniel") && password.equals("Java")) {
			response.setResponseCode(1).setResponseMessage(username + " successfully logged in");
		} else {
			// return unsuccessful response
			response.setResponseCode(99).setResponseMessage(username + " sorry login failed");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
	
	
	// update
	// method for client streaming
	// as we are the server we are going to get a stream of massages coming in from the client
	// for those incoming massages we need to implement a StreamObserver
	// and then we pass it back to the GRPC library
	@Override
	public StreamObserver<UpdateRequest> update(StreamObserver<UpdateResponse> responseObserver) {
		return new StreamObserver<UpdateRequest> () {

			@Override
			public void onNext(UpdateRequest request) {
				System.out.println("Request code send by the user is: "+ request.getRequestCode());
				UpdateResponse updateresponse = UpdateResponse.newBuilder().setResponseCode(request.getRequestCode()).build();				
				responseObserver.onNext(updateresponse);			
			}

			@Override
			public void onError(Throwable t) {				
				t.printStackTrace();	
			}

			@Override
			public void onCompleted() {
				// now build response
				System.out.println("\nThe user now has sent all messages.");
				UpdateResponse.Builder response = UpdateResponse.newBuilder();
				System.out.println("\nStreaming is now completed, thank you.");
				
				responseObserver.onNext(response.build());
				responseObserver.onCompleted();
			}};
	}
	
	
	// logout
	@Override
	public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) {
		// find out what was sent by the user
		String username = request.getUsername();
		
		// now build response
		LogoutResponse.Builder response = LogoutResponse.newBuilder();
		System.out.println("\nLogged out user is " + username);

		// return success response
		if (username.equals("Daniel")) {
			response.setResponseCode(1).setResponseMessage(username + " successfully logged out");
		} else {
			// return unsuccessful response
			response.setResponseCode(99).setResponseMessage(username + " sorry logout failed, user not found");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
}
