package net.dysbear.bluetooth;
import javax.bluetooth.*;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;
import javax.obex.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Initialization {
/*// Initialize the local device.
private static LocalDevice local = null;
// Initialize the stream.
private StreamConnection streamConnection = null;
// Initialize the byte accepted stream
private byte[] acceptedByteArray = new byte[1024];
// Initialize the input stream.
private DataInputStream inputStream;
// Notification
private StreamConnectionNotifier notifier;
// Initialize the ThreadPool.
private final static ExecutorService service = Executors.newCachedThreadPool();
// Remote Device
private static Set<RemoteDevice> discoveryDevice = new HashSet<RemoteDevice>();

public Initialization() {
	//Setup the server to listen for connection.
	try {
		
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
}
public static void findDevices() throws IOException, InterruptedException{
	
	final Object inquiryCompletedEvent = new Object();
	discoveryDevice.clear();
	
	DiscoveryListener listener = new DiscoveryListener() {
		public void inquiryCompleted(int discType) {
			System.out.println("#" + " Search done !" );
			synchronized(inquiryCompletedEvent) {
				inquiryCompletedEvent.notifyAll();
			}
		}

		@Override
		public void deviceDiscovered(RemoteDevice arg0, DeviceClass arg1) {
			// TODO Auto-generated method stub
			discoveryDevice.add(arg0);
			try {
				
				System.out.println("#Device founded ! " + arg0.getFriendlyName(false));
			    
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		

		@Override
		public void serviceSearchCompleted(int arg0, int arg1) {
			// TODO Auto-generated method stub
			System.out.println("#" + "serviceSearchCompleted");
		}

		@Override
		public void servicesDiscovered(int arg0, ServiceRecord[] arg1) {
			// TODO Auto-generated method stub
			System.out.println("# service discovered. ");			
		}
	};
	
	synchronized(inquiryCompletedEvent) {
		
		local = LocalDevice.getLocalDevice();
		
		System.out.println("The name for local Bluetooth is : " + local.getFriendlyName());
		
		boolean started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
		
		if(started) {
			System.out.println("#" + "Searching...");
			inquiryCompletedEvent.wait();
			LocalDevice.getLocalDevice().getDiscoveryAgent().cancelInquiry(listener);
			System.out.println("the total number of devices : " + discoveryDevice.size());
		}
	}
	
	
}
*/
	/*First the application retrieves a reference to the Bluetooth Manager from the LocalDevice. Client applications ret
	rieve a reference to the DiscoveryAgent, which provides all the discovery-related services. Server applications make the 
	device discoverable. In the following code snippet, the ini
	tialization method btInit() performs both client and server initialization*/
private LocalDevice localDevice; // Local Bluetooth Manager
private DiscoveryAgent discoveryAgent; // discovery agent
private static final String myBtServiceName = "dylan"; // service's name
private static final String myServiceUUID = "2d26618601fb47c28d9f10b8ec891363";
private UUID uuid = new UUID(myServiceUUID,false); // initialize UUID


public void btInit() throws BluetoothStateException, IOException{
	localDevice = null;
	discoveryAgent = null;
	// free the localdevice to get the bluetooth manager
	localDevice = LocalDevice.getLocalDevice();
	// Server setup to discoverable
	localDevice.setDiscoverable(DiscoveryAgent.GIAC);
	//Agent is retrived by Client
	discoveryAgent = localDevice.getDiscoveryAgent();
	
	
	String connURL = "btspp://localhost:"+uuid.toString()+";"+"name="+myBtServiceName;
	// Create a connection (notifier)
	StreamConnectionNotifier scn = (StreamConnectionNotifier)Connector.open(connURL);
	
	// Accept a new client connection
	
}
/*create a Bluetooth connection using the GCF connection factory javax.microed
 * ition.io.Connector, passing to its open() method a connection URL argument de
 * scribing the connection endpoint to create.
 */

public static void main(String args[]) {
	
	try {
		
		//findDevices();
		
	} catch (IOException | InterruptedException e) {
		e.printStackTrace();
	}
}
	
}
