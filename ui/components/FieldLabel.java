package components;

import javax.swing.*;

public class FieldLabel extends JPanel {
    private String label;
    private String value;
    private JTextField textField;

    public FieldLabel(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
