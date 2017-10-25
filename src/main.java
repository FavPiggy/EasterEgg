import javax.swing.*;

public class main {

    public static void main(String[] happiness){
        for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Motif".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (final ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (final InstantiationException e) {
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    e.printStackTrace();
                } catch (final UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

        PiggyGUI gui = new PiggyGUI();
        gui.start();
    }
}
