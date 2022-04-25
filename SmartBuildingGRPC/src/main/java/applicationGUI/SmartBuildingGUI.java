package applicationGUI;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import lightingControl.IntensityRequest;
import lightingControl.IntensityResponse;
import lightingControl.IntensityResponseOrBuilder;
import lightingControl.lightingControlGrpc;
import accessControl.AuthorizationRequest;
import accessControl.AuthorizationResponse;
import accessControl.accessControlGrpc;
import airConditionControl.UpdateRequest;
import airConditionControl.UpdateResponse;
import airConditionControl.airConditionControlGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


public class SmartBuildingGUI implements ActionListener{


	private JTextField entry1, reply1;
	private JTextField entry2, reply2;
	private JTextField entry3, reply3;


	private JPanel getLightingControlJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter value")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry1 = new JTextField("",10);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(15, 0)));

		JButton button = new JButton("Adjust light intensity");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply1 = new JTextField("", 30);
		reply1 .setEditable(false);
		panel.add(reply1 );

		panel.setLayout(boxlayout);

		return panel;
	}

	private JPanel getAccessControlJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter name")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry2 = new JTextField("",10);
		panel.add(entry2);
		panel.add(Box.createRigidArea(new Dimension(15, 0)));

		JButton button = new JButton("Invoke access level");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply2 = new JTextField("", 30);
		reply2 .setEditable(false);
		panel.add(reply2 );

		panel.setLayout(boxlayout);

		return panel;
	}

	private JPanel getAirConditionControlJPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter code")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		entry3 = new JTextField("",10);
		panel.add(entry3);
		panel.add(Box.createRigidArea(new Dimension(15, 0)));

		JButton button = new JButton("Adjust the air condition");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		reply3 = new JTextField("", 30);
		reply3 .setEditable(false);
		panel.add(reply3 );

		panel.setLayout(boxlayout);

		return panel;
	}

	public static void main(String[] args) {

		SmartBuildingGUI gui = new SmartBuildingGUI();
		gui.build();
	}

	private void build() { 

		JFrame frame = new JFrame("Service Controller for Smart Building");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add( getLightingControlJPanel() );
		panel.add( getAccessControlJPanel() );
		panel.add( getAirConditionControlJPanel() );

		// Set size for the frame
		frame.setSize(500, 500);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();  

		if (label.equals("lightingControl")) {
			System.out.println("lightingControl to be invoked ...");

		
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			//lightingControlGrpc.lightingControlBlockingStub blockingStub = lightingControlGrpc.newBlockingStub(channel);
			lightingControlGrpc.lightingControlStub asyncStub = lightingControlGrpc.newStub(channel);
			
			
			// client streaming code
			// for incoming message implement a StreamObserver then pass the StreamObserver to the gRPC library
			StreamObserver<IntensityResponse> responseObserver = new StreamObserver<IntensityResponse>() {

				@Override
				public void onNext(IntensityResponse response) {
					reply1.setText( response.getResponseMessage() + response.getResponseCode());
					System.out.println("\nFinally " + response.getResponseMessage());
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {				
				}
			};

				// gRPC library returns a StreamObserver to requestObserver, use for sending outgoing messages
		 		StreamObserver<IntensityRequest> requestObserver = asyncStub.setIntensity(responseObserver);
				
				  requestObserver.onNext(IntensityRequest.newBuilder().setRequestCode(((IntensityResponseOrBuilder) entry1).getResponseCode()).build());
				  requestObserver.onNext(IntensityRequest.newBuilder().setRequestCode(((IntensityResponseOrBuilder) entry1).getResponseCode()).build());
				  requestObserver.onNext(IntensityRequest.newBuilder().setRequestCode(((IntensityResponseOrBuilder) entry1).getResponseCode()).build());
				  requestObserver.onNext(IntensityRequest.newBuilder().setRequestCode(((IntensityResponseOrBuilder) entry1).getResponseCode()).build());
				 
		 		
				  // mark the end of requests
				  requestObserver.onCompleted();		 			

					
		}else if (label.equals("accessControl")) {
			System.out.println("accessControl to be invoked ...");

		
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			//accessControlGrpc.accessControlBlockingStub blockingStub = accessControlGrpc.newBlockingStub(channel);
			accessControlGrpc.accessControlStub asyncStub = accessControlGrpc.newStub(channel);

			
			AuthorizationRequest authorizationRequest = AuthorizationRequest.newBuilder().setName(entry2.getName()).build(); 
			// client streaming code
			// for incoming message implement a StreamObserver then pass the StreamObserver to the gRPC library
			StreamObserver<AuthorizationResponse> responseObserver = new StreamObserver<AuthorizationResponse>() {

				@Override
				public void onNext(AuthorizationResponse response) {
					reply2.setName( String.valueOf( response.getResponseCode()));		
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					IntensityResponse.Builder response = IntensityResponse.newBuilder();
					response.setResponseMessage("Streaming is now completed, thank you.");
				}};

				asyncStub.authorization(authorizationRequest, responseObserver);
	
			
		}else if (label.equals("airConditionControl")) {
			System.out.println("airConditionControl to be invoked ...");

		
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
			//airConditionControlGrpc.airConditionControlBlockingStub blockingStub = airConditionControlGrpc.newBlockingStub(channel);
			airConditionControlGrpc.airConditionControlStub asyncStub = airConditionControlGrpc.newStub(channel);

			
			// client streaming code
			// for incoming message implement a StreamObserver then pass the StreamObserver to the gRPC library
			StreamObserver<UpdateResponse> responseObserver = new StreamObserver<UpdateResponse>() {

				@Override
				public void onNext(UpdateResponse response) {
					reply3.setText( String.valueOf( response.getResponseCode()));
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {	
					System.out.println("Streaming is now completed, thank you.");
				}
			};
			
				// gRPC library returns a StreamObserver to requestObserver, use for sending outgoing messages
				StreamObserver<UpdateRequest> requestObserver = asyncStub.update(responseObserver);
				
				
				  requestObserver.onNext(UpdateRequest.newBuilder().setRequestCode(((IntensityResponseOrBuilder) entry3).getResponseCode()).build());
				  requestObserver.onNext(UpdateRequest.newBuilder().setRequestCode(((IntensityResponseOrBuilder) entry3).getResponseCode()).build());
				  requestObserver.onNext(UpdateRequest.newBuilder().setRequestCode(((IntensityResponseOrBuilder) entry3).getResponseCode()).build());
				  requestObserver.onNext(UpdateRequest.newBuilder().setRequestCode(((IntensityResponseOrBuilder) entry3).getResponseCode()).build());
				 	
				  // mark the end of requests
				  requestObserver.onCompleted();
		 			
				  System.out.println("\nThe user now has sent all messages.");

		}else{
			
		}

	}

}
