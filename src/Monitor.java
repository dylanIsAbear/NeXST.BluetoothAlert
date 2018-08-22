import net.dysbear.bluetooth.getDev;

import java.util.Map;

public class Monitor extends Thread{
    private boolean bottom;
    private Map<Integer, String> displayedDevice;
    private Map<Integer, String> updatedDevice;
    MainWindow mainWindow;

    private void listenChange() {
        while(true) {
            //updatedDevice = getDev.get();
            bottom = mainWindow.getSelected();
            if(displayedDevice.size() != updatedDevice.size()) {
                for(Integer it : displayedDevice.keySet()) {
                    if(updatedDevice.containsKey(it)) {
                        updatedDevice.remove(it);
                    }
                    else {
                        if(bottom) {
                            Alert newAlert = new Alert(displayedDevice.get(it));
                            newAlert.start();
                        }
                        displayedDevice.remove(it);
                    }
                }
                //Add new devices.
                for(Integer it : updatedDevice.keySet()) {
                    displayedDevice.put(it, updatedDevice.get(it));
                }
                mainWindow.setDisplay(displayedDevice);

            }
            try {
                sleep(500);
            } catch (InterruptedException ie) {}
        }
    }

    public Monitor() {
        bottom = true;
    }

    public void run() {
        mainWindow = new MainWindow();
        //listenChange();
    }
}
