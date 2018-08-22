import javax.swing.*;

public class Alert extends Thread {
    private String name;

    private void show() {
        JOptionPane alert = new JOptionPane();
        String alertMessage = "You are losing your " + name + "!!!";
        JOptionPane.showMessageDialog(alert,  alertMessage, "Warning!",JOptionPane.WARNING_MESSAGE);
    }

    public Alert(String deviceName) {
        name = deviceName;
    }

    public void run() {
        show();
    }
}
