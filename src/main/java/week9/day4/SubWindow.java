package week9.day4;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * @author LuoXuanwei
 * @date 2023/10/11 20:51
 */
public class SubWindow extends JInternalFrame {
    private static SubWindow window;

    private SubWindow() {
        super("子窗口", true, true, true, false);
        this.setLocation(25, 25);
        this.setSize(100, 100);
        this.addInternalFrameListener(new MyIFListener());
        this.setVisible(true);
    }

    public static SubWindow getWindow() {
        if (window == null) {
            synchronized (SubWindow.class) {
                if (window == null) {
                    window = new SubWindow();
                }
            }
        }
        return window;
    }

    class MyIFListener extends InternalFrameAdapter {
        @Override
        public void internalFrameClosing(InternalFrameEvent event) {
            if (window != null) {
                window = null;
            }
        }
    }
}
