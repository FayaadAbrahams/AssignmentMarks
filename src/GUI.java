import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private JTextField markTextField1, markTextField2, markTextField3, markTextField4;
    private DefaultTableModel tableModel;
    private JPanel panel;
    private LinkedList linky = new LinkedList();
    private int count = 1;

    public GUI() {
        initializeFrame();
        initializeComponents();
        frame.setVisible(true);
    }

    private void initializeFrame() {
        frame = new JFrame("Mark Calculation Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    private void initializeComponents() {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        markTextField1 = new JTextField(10);
        markTextField2 = new JTextField(10);
        markTextField3 = new JTextField(10);
        markTextField4 = new JTextField(10);

        JLabel label1 = new JLabel("Term One's Mark (%): ");
        JLabel label2 = new JLabel("Term Two's Mark (%): ");
        JLabel label3 = new JLabel("Term Three's Mark (%): ");
        JLabel label4 = new JLabel("Term Four's Mark (%): ");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label1, gbc);

        gbc.gridx = 1;
        panel.add(markTextField1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(label2, gbc);

        gbc.gridx = 1;
        panel.add(markTextField2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(label3, gbc);

        gbc.gridx = 1;
        panel.add(markTextField3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(label4, gbc);

        gbc.gridx = 1;
        panel.add(markTextField4, gbc);

        JButton button = new JButton("Calculate Marks");
        button.setBackground(new Color(10, 168, 71));
        button.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(button, gbc);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text1 = markTextField1.getText();
                String text2 = markTextField2.getText();
                String text3 = markTextField3.getText();
                String text4 = markTextField4.getText();

                // Validate inputs
                if (!isValidInput(text1) || !isValidInput(text2) || !isValidInput(text3) || !isValidInput(text4)) {
                    JOptionPane.showMessageDialog(frame, "Input Error!\nPlease enter numeric values for marks.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                linky = new LinkedList();
                // Add to the Linked List
                linky.add(Double.parseDouble(text1));
                linky.add(Double.parseDouble(text2));
                linky.add(Double.parseDouble(text3));
                linky.add(Double.parseDouble(text4));

                // Traverse through items in the LinkedList
                LinkedList.Node current = linky.getHead();
                while (current != null) {
                    tableModel.addRow(new Object[] { "Term " + count, current.getData() + "%" });
                    count++;
                    current = current.getNext();
                }

                // Remove all components from the panel
                panel.removeAll();

                // Add the table to the panel
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 2;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1;
                gbc.weighty = 1;
                panel.add(new JScrollPane(new JTable(tableModel)), gbc);

                // Add Averages for the year under the table
                JLabel averageLabel = new JLabel("Average for the year: " + linky.calculateAverage() + "%");

                gbc.gridy = 1;
                panel.add(averageLabel, gbc);

                // Update the Panel
                panel.revalidate();
                panel.repaint();
            }
        });

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Term");
        tableModel.addColumn("Mark (%)");

        frame.getContentPane().add(panel);
    }

    private boolean isValidInput(String input) {
        // Check if it's not any letters and can be converted to a Double
        return input != null && !input.isEmpty() && input.matches("\\d*\\.?\\d+") && Double.parseDouble(input) <= 100;
    }
}
