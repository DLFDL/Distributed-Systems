package lightingControl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import lightingControl.lightingControlGrpc.lightingControlImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class lightingControlServer extends lightingControlImplBase {

	// extend abstract base class for implementation
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		lightingControlServer lightingcontrolserver = new lightingControlServer();

		// service information
		int port = 50051;
		String service_type = "_lightingControl._tcp.local.";
		String service_name = "gRPC lightingControlServer";
		ServiceRegistration serviceregistration = new ServiceRegistration();
		serviceregistration.run(port, service_type, service_name);

		try {
			Server server = ServerBuilder.forPort(port)
					.addService(lightingcontrolserver)
					.intercept(new ExceptionHandler())
					.build()
					.start();

			System.out.println("\ngRPC lightingControl server started successfully");
			
			// register some actions which are to be performed on termination when the program meets some unexpected situation
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
		            System.err.println("Shutting down gRPC lightingControl server");
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
		System.out.println("\nLogged in user is: " + username + ", and password is " + password);

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

	
	// setIntensity
	// method for client streaming
	// as we are the server we are going to get a stream of massages coming in from the client
	// for those incoming massages we need to implement a StreamObserver
	// and then we pass it back to the GRPC library
	@Override
	public StreamObserver<IntensityRequest> setIntensity(StreamObserver<IntensityResponse> responseObserver) {
		return new StreamObserver<IntensityRequest>() {

			@Override
			public void onNext(IntensityRequest request) {
				System.out.println( "Light intensity successfully adjusted to " + request.getRequestCode() + " Lux");
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
				IntensityResponse.Builder response = IntensityResponse.newBuilder();
				response.setResponseMessage("streaming is now completed, thank you.");

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
