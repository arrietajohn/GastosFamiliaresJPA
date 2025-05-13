package FamilyExpenses;

import FamilyExpenses.Presenters.Gui.MainWindow;



/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Execution test ok..");
        var mainWindow = new MainWindow();
        mainWindow.setExtendedState(MainWindow.MAXIMIZED_BOTH);
        mainWindow.setVisible(true);
    }
}
