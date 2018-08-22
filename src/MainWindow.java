import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;


public class MainWindow extends JFrame {
    private JLabel appName = new JLabel();
    private JLabel versionInfo = new JLabel();
    private JToggleButton alertSwitch;
    private JList<String> list;

    //Create a menu bar.
    private String[][] menuNameMnemonics = { { "File", "f" }, { "Edit", "e" }, { "Help", "h" } };
    private JMenuBar menuBar;

    private void createJMenu() {
        menuBar = new JMenuBar();
        for (String[] menuNameMnemonic : menuNameMnemonics) {
            menuBar.add(createMenu(menuNameMnemonic[0], menuNameMnemonic[1]));
        }
        JMenu fileMenu = getMenu("File");
        fileMenu.add(createMenuNamedNew());
        fileMenu.add(createMenuItem("Save As", "s", new ImageIcon("resources\\icon\\Save.png"), KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK)));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem("Refresh", "f", new ImageIcon("resources\\icon\\Refresh.png"), KeyStroke.getKeyStroke("F5")));
        JMenu menuNamedConvert = createMenuNamedConvert();
        fileMenu.add(menuNamedConvert);//添加New菜单
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem("Print", "p", new ImageIcon("resources\\icon\\Print.png"), KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK)));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem("Properties", "r", null, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.ALT_MASK)));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem("Exit", "x", null, null));
    }

    private JMenu createMenuNamedNew() {
        JMenu menu = createMenu("New", "n");
        menu.add(createMenuItem("JavaProject", null, new ImageIcon("resources\\icon\\JavaProject.gif"), null));
        menu.add(createMenuItem("Project", null, new ImageIcon("resources\\icon\\Project.gif"), null));
        menu.add(createMenuItem("Package", null, new ImageIcon("resources\\icon\\Package.gif"), null));
        menu.add(createMenuItem("Class", null, new ImageIcon("resources\\icon\\Class.gif"), null));
        menu.add(createMenuItem("Interface", null, new ImageIcon("resources\\icon\\Interface.gif"), null));
        menu.add(createMenuItem("Enum", null, new ImageIcon("resources\\icon\\Enum.gif"), null));
        menu.add(createMenuItem("Annotation", null, new ImageIcon("resources\\icon\\Annotation.gif"), null));
        menu.add(createMenuItem("SourceFolder", null, new ImageIcon("resources\\icon\\SourceFolder.gif"), null));
        menu.add(createMenuItem("JavaWorkingSet", null, new ImageIcon("resources\\icon\\JavaWorkingSet.gif"), null));
        menu.add(createMenuItem("Folder", null, new ImageIcon("resources\\icon\\Folder.gif"), null));
        menu.add(createMenuItem("File", null, new ImageIcon("resources\\icon\\File.gif"), null));
        menu.add(createMenuItem("UntitledTextFile", null, new ImageIcon("resources\\icon\\UntitledTextFile.gif"), null));
        menu.add(createMenuItem("JunitTestCase", null, new ImageIcon("resources\\icon\\JunitTestCase.gif"), null));
        menu.add(createMenuItem("Task", null, new ImageIcon("resources\\icon\\Task.gif"), null));
        menu.add(createMenuItem("Example", null, new ImageIcon("resources\\icon\\Example.gif"), null));
        menu.add(createMenuItem("Other", null, new ImageIcon("resources\\icon\\Other.gif"), null));
        return menu;
    }

    private JMenu createMenuNamedConvert() {
        JMenu menu = createMenu("Convert Line Delimiters to", "v");
        menu.add(createMenuItem("Windows (CRLF, \\r\\n, 0D0A, xx)[default]", "w", null, null));
        menu.add(createMenuItem("Unix (LF, \\n, 0A, xx)", "n", null, null));
        return menu;
    }

    private JMenu getMenu(String menuName) {
        JMenu menu = null;
        for (int i = 0; i < menuBar.getMenuCount(); i++) {
            menu = menuBar.getMenu(i);
            if (menu.getText().equals(menuName))
                return menu;
        }
        return null;
    }

    private JMenu createMenu(String name, String mnemonic) {
        JMenu menu = new JMenu(name);
        if (mnemonic != null)
            menu.setMnemonic(mnemonic.toCharArray()[0]);
        return menu;
    }

    private JMenuItem createMenuItem(String name, String mnemonic, Icon icon, KeyStroke keyStroke) {
        JMenuItem menuItem = new JMenuItem(name, icon);
        if (mnemonic != null)
            menuItem.setMnemonic(mnemonic.toCharArray()[0]);
        if (keyStroke != null)
            menuItem.setAccelerator(keyStroke);
        return menuItem;
    }

    //Constructor.
    public MainWindow() {
        //Create text boxes.
        appName.setText("Tooth Protector");
        appName.setFont(new Font("", Font.BOLD, 22));
        appName.setHorizontalAlignment(JLabel.CENTER);
        appName.setHorizontalTextPosition(JLabel.CENTER);
        appName.setVerticalTextPosition(JLabel.CENTER);
        appName.setSize(180, 50);
        appName.setLocation(40, 155);
        this.add(appName);

        versionInfo.setText("Version: 0.1.0");
        versionInfo.setFont(new Font("", Font.BOLD, 14));
        versionInfo.setHorizontalAlignment(JLabel.CENTER);
        versionInfo.setHorizontalTextPosition(JLabel.CENTER);
        versionInfo.setVerticalTextPosition(JLabel.CENTER);
        versionInfo.setLocation(40,205);
        versionInfo.setSize(180,20);
        this.add(versionInfo);

        //Create the switch.
        alertSwitch = new JToggleButton("Alert On", true);
        alertSwitch.setLocation(70,235);
        alertSwitch.setSize(120,30);
        alertSwitch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!alertSwitch.isSelected()) {
                    alertSwitch.setText("Alert Off");
                    alertSwitch.setSelected(false);
                }
                else{
                    alertSwitch.setText("Alert On");
                    alertSwitch.setSelected(true);
                }
            }
        });
        this.add(alertSwitch);

        //Add menu bar.
        this.createJMenu();
        this.setJMenuBar(menuBar);

        //Add new list.
        String[] str = {"Nothing has been found."};
        list = new JList(str);
        list.setSize(100,300);
        list.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JScrollPane container = new JScrollPane(list);
        container.setLocation(250,25);
        container.setSize(500,400);
        this.add(container);

        //Window settings.
        this.setTitle("Tooth Protector");
        this.setSize(800, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(200, 200);

        //Show.
        this.setVisible(true);
    }

    public void setDisplay(Map<Integer, String> newValue) {
        if(newValue.size() == 0) {
            list.setListData(new String[] {"Nothing has been found."});
            return;
        }
        String[] updatedData = new String[newValue.size()];
        int i = 0;
        for(Integer it : newValue.keySet()) {
            updatedData[i] = newValue.get(it);
            i++;
        }
        list.setListData(updatedData);
    }

    public boolean getSelected() {
        return alertSwitch.isSelected();
    }
}