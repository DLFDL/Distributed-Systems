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

		//service information	
		int port = 50052;
		String service_type = "_accessControl._tcp.local";
		String service_name = "gRPC accessControlServer";
		ServiceRegistration serviceregistration = new ServiceRegistration();
		serviceregistration.run(port, service_type, service_name);

		try {
			Server server = ServerBuilder.forPort(port)
					.addService(accesscontrolserver)
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
		System.out.println("\nLogged in user is: " + username + ", and password is " + password);

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

	
	// authorisation
	// method for client streaming
	// as we are the server we are going to get a stream of massages coming in from the client
	// for those incoming massages we need to implement a StreamObserver
	// and then we pass it back to the GRPC library
	@Override
	public void authorization(AuthorizationRequest request, StreamObserver<AuthorizationResponse> responseObserver) {
		// find out what was sent by the user
		String name = request.getName();
		
		// now build response
		AuthorizationResponse.Builder response = AuthorizationResponse.newBuilder();

		// return success response
		if (name.equals("Daniel")) {
			response.setResponseCode(1).setMessage(name + " authorization successfully completed on level 1 security");
		} else {
			// return unsuccessful response
			response.setResponseCode(99).setMessage(name + " sorry authorization failed");
		}
			responseObserver.onNext(response.build());
			// return success response
		if (name.equals("Daniel")) {
			response.setResponseCode(2).setMessage(name + " authorization successfully completed on level 2 security");
		} else {
			// return unsuccessful response
			response.setResponseCode(99).setMessage(name + " sorry authorization failed");
		}
			responseObserver.onNext(response.build());
			// return success response
		if (name.equals("Daniel")) {
			response.setResponseCode(3).setMessage(name + " authorization successfully completed on level 3 security");
		} else {
			// return unsuccessful response
			response.setResponseCode(99).setMessage(name + " sorry authorization failed");
		}
			responseObserver.onNext(response.build());
			// return success response
		if (name.equals("Daniel")) {
			response.setResponseCode(4).setMessage(name + " authorization successfully completed on level 4 security");
		} else {
			// return unsuccessful response
			response.setResponseCode(99).setMessage(name + " sorry authorization failed");
		}
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();	
			
			System.out.println("\nThe user has sent the message.");
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
