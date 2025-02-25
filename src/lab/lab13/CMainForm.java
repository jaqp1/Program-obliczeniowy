package lab.lab13;

import javax.swing.*;
import java.awt.*;

import observer.CConsoleObserver;
import observer.CFileObserver;
import observer.CJListObserver;
import observer.IObserver;
import solver.*;

public class CMainForm extends JFrame{
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuOptions;
    private JMenuItem itemExit;
    private JMenuItem itemSolve;
    private JMenuItem itemAbout;
    private JRadioButton rbFirst;
    private JRadioButton rbSecond;
    private JRadioButton rbFourth;
    private JTextField tkTextField;
    private JTextField alphaTextField;
    private JTextField omegaTextField;
    private JCheckBox cbPanel;
    private JCheckBox cbConsole;
    private JCheckBox cbFile;
    private JList list1;

    private DefaultListModel<Object> model;

    public CMainForm(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        model = new DefaultListModel<>();
        list1.setModel(model);

        itemExit.addActionListener(actionEvent -> CMainForm.this.dispose());
        itemAbout.addActionListener(actionEvent -> JOptionPane.showMessageDialog(
                CMainForm.this, "Programowanie obiektowe \nLaboratorium 13", "O programie", JOptionPane.INFORMATION_MESSAGE
        ));
        itemSolve.addActionListener(actionEvent -> solveActionPerformed());
    }

    private void solveActionPerformed() {
        CSolverCreator sc = new CSolverCreator();
        ESolverType st = ESolverType.FIRST_ORDER;

        if (rbSecond.isSelected()) {
            st = ESolverType.SECOND_ORDER;
        } else if (rbFourth.isSelected()) {
            st = ESolverType.FOURTH_ORDER;
        }

        CStepData init = null;

        try {
            init = new CStepData(
                    Double.parseDouble(tkTextField.getText().trim()),
                    Double.parseDouble(alphaTextField.getText().trim()),
                    Double.parseDouble(omegaTextField.getText().trim())
            );

            CSolver solverObj = sc.getSolver(st, init);

            if (solverObj != null) {
                solverObj.solve();
            } else {
                JOptionPane.showMessageDialog(null, "Nie udało się utworzyć solvera!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Niepoprawne dane wejściowe! Wprowadź liczby.", "Błąd", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Wystąpił nieoczekiwany błąd! Sprawdź konfigurację programu.", "Błąd", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nieznany błąd: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        CSolver solverObj = sc.getSolver(st, init);
        if(cbPanel.isSelected())
            solverObj.addObserver (new CJListObserver(model));
        if(cbConsole.isSelected())
            solverObj.addObserver (new CConsoleObserver());
        if(cbFile.isSelected())
            solverObj.addObserver (new CFileObserver());
        solverObj.solve();

    }




}
