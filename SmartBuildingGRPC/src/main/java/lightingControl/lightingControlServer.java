package lightingControl;

import java.io.IOException;

import lightingControl.lightingControlGrpc.lightingControlImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class lightingControlServer extends lightingControlImplBase {

	// extend abstract base class for implementation
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		lightingControlServer lightingcontrolserver = new lightingControlServer();

		int port = 50051;

		try {
			Server server = ServerBuilder.forPort(port).addService(lightingcontrolserver).build().start();

			System.out.println("Server started with port: " + server.getPort());
			server.awaitTermination();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	
	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
		// find out what was sent by the user
		String username = request.getUsername();
		String password = request.getPassword();

		// now build response
		LoginResponse.Builder response = LoginResponse.newBuilder();
		System.out.println("username = " + username + ", password = " + password);

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

	
	// method for client streaming
	// as we are the server we are going to get a stream of massages coming in from the client
	// for those incoming massages we need to implement a StreamObserver
	// and then we pass it back to the GRPC library
	@Override
	public StreamObserver<IntensityRequest> setIntensity(StreamObserver<IntensityResponse> responseObserver) {
		return new StreamObserver<IntensityRequest>() {

			@Override
			public void onNext(IntensityRequest response) {
				System.out.println( "Light intensity successfully adjusted to " + response.getRequestCode() + " Lux");
			}

			@Override
			public void onError(Throwable t) {
			}

			@Override
			public void onCompleted() {
				// now build response
				IntensityResponse.Builder responseBuilder = IntensityResponse.newBuilder();				
				responseBuilder.setResponseMessage("Message from server, streaming now completed");
				  
				responseObserver.onNext(responseBuilder.build()); 
				responseObserver.onCompleted(); 
			}};	
	}


	@Override
	public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) {
		// find out what was sent by the user
		String username = request.getUsername();

		// now build response
		LogoutResponse.Builder response = LogoutResponse.newBuilder();
		System.out.println("Logging out username = " + username);

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
