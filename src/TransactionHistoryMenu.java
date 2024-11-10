import javax.swing.*;
import java.util.stream.Collectors;

public class TransactionHistoryMenu extends JFrame{
    private JTextArea TransHistory_Txt;
    private JPanel TransHistoryPane;

    public TransactionHistoryMenu(Account account) {
        String listString = account.getTransactionHistory().stream().map(Object::toString)
                .collect(Collectors.joining(", "));
        TransHistory_Txt.setText(listString);
        setContentPane(TransHistoryPane);
        setTitle("Bank of Tyler");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
