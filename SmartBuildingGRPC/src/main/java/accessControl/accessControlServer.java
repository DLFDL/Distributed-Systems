package accessControl;

import java.io.IOException;
import accessControl.accessControlGrpc.accessControlImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class accessControlServer extends accessControlImplBase{

	// extend abstract base class for implementation
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Starting gRPC Server");
		accessControlServer accesscontrolserver = new accessControlServer();

		int port = 50051;

		try {
			Server server = ServerBuilder.forPort(port)
					.addService(accesscontrolserver)
					.build()
					.start();

			System.out.println("Server started with port:" + server.getPort());
		    server.awaitTermination();

		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(InterruptedException e) {
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
		if(username.equals("Daniel") && password.equals("Java")) {
			response.setResponseCode(1).setResponseMessage(username + " successfully logged in");
		}
		else {
			// return unsuccessful response
			response.setResponseCode(99).setResponseMessage(username + " sorry login failed");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	
	// method for client streaming
	// for those massages we need to implement a StreamObserver
	@Override
	public void authorization(AuthorizationRequest request, StreamObserver<AuthorizationResponse> responseObserver) {
		// find out what was sent by the user
		String name = request.getName();
		
		// now build response
		AuthorizationResponse.Builder response = AuthorizationResponse.newBuilder();
		System.out.println("name = " + name);

		// return success response
		if(name.equals("Daniel")) {
			response.setResponseCode(1).setMessage(name + " authorization successfully completed on level 1");
		}
		else {
			// return unsuccessful response
			response.setResponseCode(99).setMessage(name + " sorry authorization failed");
		}
			responseObserver.onNext(response.build());
			// return success response
		if(name.equals("Daniel")) {
			response.setResponseCode(2).setMessage(name + " authorization successfully completed on level 2");
		}
		else {
			// return unsuccessful response
			response.setResponseCode(99).setMessage(name + " sorry authorization failed");
		}
			responseObserver.onNext(response.build());
			// return success response
		if(name.equals("Daniel")) {
			response.setResponseCode(3).setMessage(name + " authorization successfully completed on level 3");
		}
		else {
			// return unsuccessful response
			response.setResponseCode(99).setMessage(name + " sorry authorization failed");
		}
			responseObserver.onNext(response.build());
			// return success response
		if(name.equals("Daniel")) {
			response.setResponseCode(4).setMessage(name + " authorization successfully completed on level 4");
		}
		else {
			// return unsuccessful response
			response.setResponseCode(99).setMessage(name + " sorry authorization failed");
		}
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();	
	}
	

	@Override
	public void logout(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) {
		// find out what was sent by the user
		String username = request.getUsername();

		// now build response
		LogoutResponse.Builder response = LogoutResponse.newBuilder();
		System.out.println("Logging out username = " + username);

		// return success response
		if(username.equals("Daniel")) {
			response.setResponseCode(1).setResponseMessage(username + " successfully logged out");
		}
		else {
			// return unsuccessful response
			response.setResponseCode(99).setResponseMessage(username + " sorry logout failed, user not found");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
}
