/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.expenseapp;

/**
 *
 * @author DELL
 */


import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ExpenseApp extends JFrame {

    private JTextField groceryField, petrolField, homeField;
    private JTextField educationField, medicalField, entertainmentField;
    private JTextField incomeField;
    private JTextArea  resultArea;

    private static final Color CLR_BG       = new Color(15,  17,  26);
    private static final Color CLR_PANEL    = new Color(24,  27,  42);
    private static final Color CLR_CARD     = new Color(32,  36,  56);
    private static final Color CLR_BORDER   = new Color(55,  60,  90);
    private static final Color CLR_ACCENT   = new Color(99, 179, 237);
    private static final Color CLR_GREEN    = new Color(72, 199, 142);
    private static final Color CLR_RED      = new Color(252, 95,  95);
    private static final Color CLR_YELLOW   = new Color(251, 211, 141);
    private static final Color CLR_TEXT     = new Color(220, 225, 245);
    private static final Color CLR_SUBTEXT  = new Color(140, 148, 180);
    private static final Color CLR_TERMINAL = new Color(10,  12,  20);

    public ExpenseApp() {
        setTitle(" Expense Tracker System");
        setSize(1050, 680);
        setMinimumSize(new Dimension(900, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(CLR_BG);

        JPanel root = new JPanel(new BorderLayout(0, 0));
        root.setBackground(CLR_BG);
        root.add(buildHeader(),      BorderLayout.NORTH);
        root.add(buildCenterPanel(), BorderLayout.CENTER);
        root.add(buildButtonBar(),   BorderLayout.SOUTH);
        add(root);
    }

    private JPanel buildHeader() {
        JPanel header = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0, new Color(20, 25, 50), getWidth(), getHeight(), new Color(10, 15, 35));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.setColor(CLR_ACCENT);
                g2.setStroke(new BasicStroke(2f));
                g2.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
            }
        };
        header.setPreferredSize(new Dimension(0, 90));
        header.setLayout(new GridLayout(2, 1));

        JLabel title = new JLabel("  Expense Tracker System", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel("Track · Manage · Analyse  —  Group #14  |  Java OOP Project", JLabel.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(CLR_SUBTEXT);

        header.add(title);
        header.add(subtitle);
        return header;
    }

    private JPanel buildCenterPanel() {
        JPanel center = new JPanel(new GridLayout(1, 2, 12, 0));
        center.setBackground(CLR_BG);
        center.setBorder(BorderFactory.createEmptyBorder(14, 14, 8, 14));
        center.add(buildFormPanel());
        center.add(buildDashboard());
        return center;
    }

    private JPanel buildFormPanel() {
        JPanel outer = new JPanel(new BorderLayout());
        outer.setBackground(CLR_PANEL);
        outer.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(CLR_BORDER, 1),
                BorderFactory.createEmptyBorder(18, 18, 18, 18)));

        JLabel heading = new JLabel("  Enter Monthly Expenses");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 15));
        heading.setForeground(CLR_ACCENT);
        heading.setBorder(BorderFactory.createEmptyBorder(0, 0, 14, 0));
        outer.add(heading, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(7, 2, 10, 10));
        grid.setBackground(CLR_PANEL);

        incomeField        = createField("100000");
        groceryField       = createField("");
        petrolField        = createField("");
        homeField          = createField("");
        educationField     = createField("");
        medicalField       = createField("");
        entertainmentField = createField("");

        addRow(grid, " Monthly Income (Rs.):", incomeField,        CLR_YELLOW);
        addRow(grid, " Grocery:",              groceryField,       CLR_TEXT);
        addRow(grid, " Petrol:",               petrolField,        CLR_TEXT);
        addRow(grid, " Home:",                 homeField,          CLR_TEXT);
        addRow(grid, " Education:",            educationField,     CLR_TEXT);
        addRow(grid, " Medical:",              medicalField,       CLR_TEXT);
        addRow(grid, " Entertainment:",        entertainmentField, CLR_TEXT);

        outer.add(grid, BorderLayout.CENTER);
        return outer;
    }

    private JTextField createField(String text) {
        JTextField tf = new JTextField(text);
        tf.setBackground(CLR_CARD);
        tf.setForeground(CLR_TEXT);
        tf.setCaretColor(CLR_ACCENT);
        tf.setFont(new Font("Consolas", Font.PLAIN, 13));
        tf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(CLR_BORDER, 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)));
        return tf;
    }

    private void addRow(JPanel grid, String labelText, JTextField field, Color color) {
        JLabel lbl = new JLabel(labelText);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lbl.setForeground(color);
        grid.add(lbl);
        grid.add(field);
    }

    private JScrollPane buildDashboard() {
        resultArea = new JTextArea();
        resultArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        resultArea.setBackground(CLR_TERMINAL);
        resultArea.setForeground(CLR_GREEN);
        resultArea.setCaretColor(CLR_GREEN);
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createEmptyBorder(12, 14, 12, 14));
        resultArea.setText("  Results will appear here after calculation...");

        JScrollPane sp = new JScrollPane(resultArea);
        sp.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(CLR_ACCENT, 1),
                BorderFactory.createTitledBorder(
                        BorderFactory.createEmptyBorder(),
                        "   Expense Dashboard",
                        TitledBorder.LEFT, TitledBorder.TOP,
                        new Font("Segoe UI", Font.BOLD, 14),
                        CLR_ACCENT)));
        sp.getViewport().setBackground(CLR_TERMINAL);
        return sp;
    }

    private JPanel buildButtonBar() {
        JPanel bar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bar.setBackground(CLR_BG);
        bar.setBorder(BorderFactory.createEmptyBorder(4, 0, 10, 0));

        JButton calcBtn  = makeButton("  Calculate  ", CLR_GREEN);
        JButton clearBtn = makeButton("  Clear  ",     CLR_RED);

        calcBtn.addActionListener(e  -> calculateExpenses());
        clearBtn.addActionListener(e -> clearFields());

        bar.add(calcBtn);
        bar.add(clearBtn);
        return bar;
    }

    private JButton makeButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setBackground(bg);
        btn.setForeground(CLR_BG);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 24, 10, 24));
        btn.setOpaque(true);
        btn.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { btn.setBackground(bg.brighter()); }
            @Override public void mouseExited (MouseEvent e) { btn.setBackground(bg); }
        });
        return btn;
    }

    private void calculateExpenses() {
        try {
            double income        = parseField(incomeField,        "Monthly Income");
            double grocery       = parseField(groceryField,       "Grocery");
            double petrol        = parseField(petrolField,        "Petrol");
            double home          = parseField(homeField,          "Home");
            double education     = parseField(educationField,     "Education");
            double medical       = parseField(medicalField,       "Medical");
            double entertainment = parseField(entertainmentField, "Entertainment");

            Expense e1 = new GroceryExpense(grocery);
            Expense e2 = new PetrolExpense(petrol);
            Expense e3 = new HomeExpense(home);
            Expense e4 = new EducationExpense(education);
            Expense e5 = new MedicalExpense(medical);
            Expense e6 = new EntertainmentExpense(entertainment);

            StringBuilder report = new StringBuilder();
            report.append("╔══════════════════════════════════════╗\n");
            report.append("║         EXPENSE REPORT             ║\n");
            report.append("╚══════════════════════════════════════╝\n\n");

            e1.showExpense(report);
            e2.showExpense(report);
            e3.showExpense(report);
            e4.showExpense(report);
            e5.showExpense(report);
            e6.showExpense(report);

            double total     = e1.getAmount() + e2.getAmount() + e3.getAmount()
                             + e4.getAmount() + e5.getAmount() + e6.getAmount();
            double remaining = income - total;

            report.append("\n──────────────────────────────────────\n");
            report.append(String.format(" Monthly Income      : Rs. %,.2f\n", income));
            report.append(String.format("Total Expenses      : Rs. %,.2f\n", total));
            report.append("──────────────────────────────────────\n");

            if (remaining > 0) {
                report.append(String.format(" Savings             : Rs. %,.2f  ✅\n", remaining));
                report.append(String.format("Saving Rate         : %.1f%%\n", (remaining / income) * 100));
            } else if (remaining < 0) {
                report.append(String.format("  Overspending        : Rs. %,.2f  ❌\n", Math.abs(remaining)));
                report.append(String.format(" Over Budget By      : %.1f%%\n", (Math.abs(remaining) / income) * 100));
            } else {
                report.append("✔️  Perfectly Balanced Budget!\n");
            }

            report.append("══════════════════════════════════════\n");

            resultArea.setForeground(remaining >= 0 ? CLR_GREEN : CLR_RED);
            resultArea.setText(report.toString());

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double parseField(JTextField field, String name) {
        String text = field.getText().trim();
        if (text.isEmpty()) throw new IllegalArgumentException("Please enter a value for: " + name);
        try {
            double val = Double.parseDouble(text);
            if (val < 0) throw new IllegalArgumentException(name + " cannot be negative.");
            return val;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("\"" + text + "\" is not a valid number for: " + name);
        }
    }

    private void clearFields() {
        groceryField.setText("");
        petrolField.setText("");
        homeField.setText("");
        educationField.setText("");
        medicalField.setText("");
        entertainmentField.setText("");
        incomeField.setText("100000");
        resultArea.setForeground(CLR_GREEN);
        resultArea.setText("  Results will appear here after calculation...");
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> new ExpenseApp().setVisible(true));
    }
}
