package airConditionControl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import airConditionControl.airConditionControlGrpc.airConditionControlImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class airConditionControlServer extends airConditionControlImplBase{

	// extend abstract base class for implementation
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		airConditionControlServer airconditioncontrolserver = new airConditionControlServer();

		// service information	
		int port = 50053;
		String service_type = "_airConditionControl._tcp.local";
		String service_name = "gRPC airConditionControlServer";
		ServiceRegistration serviceregistration = new ServiceRegistration();
		serviceregistration.run(port, service_type, service_name);

		try {
			Server server = ServerBuilder.forPort(port)
					.addService(airconditioncontrolserver)
					.intercept(new ExceptionHandler())
					.build()
					.start();

			System.out.println("\ngRPC airConditionControl server started successfully");
			
			// register some actions which are to be performed on termination when the program meets some unexpected situation
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
		            System.err.println("Shutting down gRPC airConditionControl server");
		            try {
		               server.shutdown().awaitTermination(30,TimeUnit.SECONDS);
		            } catch (InterruptedException e) {
		               e.printStackTrace(System.err);
		            }
		         }
			});

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	// login
	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
		// find out what was sent by the user
		String username = request.getUsername();
		String password = request.getPassword();
		// we do not want to accept requests with a missing user name, so we throw exception
		if (username.isBlank()) {
		    throw new IllegalArgumentException("Missing username");
		}

		// now build response
		LoginResponse.Builder response = LoginResponse.newBuilder();
		System.out.println("\nLogged in user is " + username + ", and password is " + password + "\n");
		
		// return success response
		if (username.equals("Daniel") && password.equals("Java")) {
			response.setResponseCode(1).setResponseMessage(username + " successfully logged in");
		} else {
			// return unsuccessful response
			// the server can validate the input and if it is not correct it can use the 
			// StreamObserver onError method to indicate the client that the precondition is failed
			Status status = Status.FAILED_PRECONDITION.withDescription("Sorry login failed, not valid username or password.");
	        responseObserver.onError(status.asRuntimeException());
	        return;
		}
		
		// mark the next of requests
		responseObserver.onNext(response.build());
		// mark the end of requests
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
				// cancelling a running function
				responseObserver.onError(Status.CANCELLED.asRuntimeException());
				t.printStackTrace();	
			}

			@Override
			public void onCompleted() {
				// now build response
				System.out.println("\nThe user now has sent all messages.");
				UpdateResponse.Builder response = UpdateResponse.newBuilder();
				System.out.println("\nStreaming is now completed, thank you.");
				
				// mark the next of requests
				responseObserver.onNext(response.build());
				// mark the end of requests
				responseObserver.onCompleted();
			}};
	}
	
	
	// logout
	@Override
	public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) {
		// find out what was sent by the user
		String username = request.getUsername();
		// we do not want to accept requests with a missing user name, so we throw exception
		if (username.isBlank()) {
		    throw new IllegalArgumentException("Missing username");
		}
		
		// now build response
		LogoutResponse.Builder response = LogoutResponse.newBuilder();
		System.out.println("\nLogged out user is " + username);

		// return success response
		if (username.equals("Daniel")) {
			response.setResponseCode(1).setResponseMessage(username + " successfully logged out");
		} else {
			// return unsuccessful response
			// the server can validate the input and if it is not correct it can use the 
			// StreamObserver onError method to indicate the client that the precondition is failed
			Status status = Status.FAILED_PRECONDITION.withDescription("Sorry login failed, not valid username.");
	        responseObserver.onError(status.asRuntimeException());
	        return;
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();    
	}
}
