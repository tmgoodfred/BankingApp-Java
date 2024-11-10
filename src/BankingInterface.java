import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingInterface extends JFrame {
    private JTextField Deposit_Txt;
    private JButton Deposit_Btn;
    private JPanel Deposit_Panel;
    private JTextField CurrentBalance_Txt;
    private JTextField Withdrawl_Txt;
    private JButton Withdrawl_Btn;
    private JButton Transaction_Btn;
    Account userAccount = new Account("1234", 500);

    public BankingInterface () {
        CurrentBalance_Txt.setText(String.valueOf(userAccount.getBalance()));
        setContentPane(Deposit_Panel);
        setTitle("Bank of Tyler");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,370);
        setLocationRelativeTo(null);
        setVisible(true);

        Deposit_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = userAccount.deposit(Double.parseDouble(Deposit_Txt.getText()));
                CurrentBalance_Txt.setText(String.valueOf(userAccount.getBalance()));   //update balance shown
                Deposit_Txt.setText("");    //reset box
                if(result)
                {
                    JOptionPane.showMessageDialog(null, "Deposit Successfully Made", "Announcement: " + "Deposit", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Deposit Failed", "Announcement: " + "Deposit", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        Withdrawl_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = userAccount.withdraw(Double.parseDouble(Withdrawl_Txt.getText()));
                CurrentBalance_Txt.setText(String.valueOf(userAccount.getBalance()));   //update balance shown
                Withdrawl_Txt.setText("");    //reset box
                if(result)
                {
                    JOptionPane.showMessageDialog(null, "Withdrawl Successfully Made", "Announcement: " + "Withdrawl", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Withdrawl Failed", "Announcement: " + "Withdrawl", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        Transaction_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransactionHistoryMenu(userAccount).setVisible(true);
            }
        });
    }
}
