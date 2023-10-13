package week9.day4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author LuoXuanwei
 * @date 2023/10/11 20:55
 */
public class MainClass extends JFrame {
    private JButton button;
    private JDesktopPane desktopPane;
    private SubWindow window = null;

    public MainClass() {
        super("主窗口");
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        button = new JButton("点击创建一个内部窗口");
        button.addActionListener(new BtListener());
        container.add(button, BorderLayout.SOUTH);
        desktopPane = new JDesktopPane();
        container.add(desktopPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(200, 200);
        this.show();
    }

    class BtListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (window != null) {
                desktopPane.remove(window);
            }
            window = SubWindow.getWindow();
            desktopPane.add(window);
        }
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
