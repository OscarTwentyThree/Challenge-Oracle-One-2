import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class App extends JFrame implements ActionListener {

    private JComboBox monedaDe;
    private JComboBox monedaPara;

    private JButton convertir;
    private JButton limpiar;
    private JButton salir;

    private JLabel lblDe;
    private JLabel lblPara;

    private TextField txtDe;
    private TextField txtResultado;

    private double dolar = 0.0019;
    private double euro = 0.0017;
    private double libra = 0.0015;
    private double yen = 0.24;
    private double won = 2.40;

    App() {
        setBounds(300, 60, 790, 700);
        getContentPane().setBackground(Color.lightGray);
        setTitle("Conversor de Monedas");
        initComponents();
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initComponents() {
        initLabels();
        initComboBox();
        initTextFields();
        initButtons();

    }

    private void initButtons() {
        convertir = new JButton("Convertir");
        convertir.setBounds(100, 450, 200, 40);
        convertir.setFont(new Font("Apple Casual", Font.BOLD, 15));
        convertir.addActionListener(this);
        add(convertir);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(450, 450, 200, 40);
        limpiar.setFont(new Font("Apple Casual", Font.BOLD, 15));
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                limpiarOpciones(evt);
            }
        });
        add(limpiar);

        salir = new JButton("Salir");
        salir.setBounds(320, 550, 100, 40);
        salir.setBackground(Color.red);
        salir.setForeground(Color.white);
        salir.setFont(new Font("Apple Casual", Font.BOLD, 15));
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                salir(evt);
            }
        });
        add(salir);
    }

    private void initTextFields() {

        txtDe = new TextField();
        txtDe.setBounds(410, 165, 250, 40);
        txtDe.setFont(new Font("Apple Casual", Font.BOLD, 20));
        txtDe.setForeground(Color.BLACK);
        add(txtDe);

        txtResultado = new TextField(" ");
        txtResultado.setBounds(410, 310, 250, 40);
        txtResultado.setFont(new Font("Apple Casual", Font.BOLD, 20));
        txtResultado.setForeground(Color.BLACK);
        add(txtResultado);
    }

    public void initLabels() {

        lblDe = new JLabel("De");
        lblDe.setBounds(10, 160, 50, 50);
        lblDe.setFont(new Font("Apple Casual", Font.BOLD, 20));
        lblDe.setForeground(Color.black);
        add(lblDe);

        lblPara = new JLabel("Para");
        lblPara.setBounds(10, 310, 50, 50);
        lblPara.setFont(new Font("Apple Casuali", Font.BOLD, 20));
        lblPara.setForeground(Color.black);
        add(lblPara);

    }

    public void initComboBox() {

        monedaDe = new JComboBox<String>(new String[] { "Seleccione la divisa", "Colon Costarricense", "Dolar", "Euro",
                "Libra Esterlina", "Yen Japonés", "Won Surcoreano" });
        monedaDe.setBounds(100, 165, 260, 40);
        monedaDe.setFont(new Font("Apple Casual", Font.BOLD, 20));
        add(monedaDe);

        monedaPara = new JComboBox<String>(new String[] { "Seleccione la divisa", "Colon Costarricense", "Dolar",
                "Euro", "Libra Esterlina", "Yen Japonés", "Won Surcoreano" });
        monedaPara.setBounds(100, 310, 260, 40);
        monedaPara.setFont(new Font("Apple Casual", Font.BOLD, 20));
        add(monedaPara);

    }

    private void limpiarOpciones(java.awt.event.ActionEvent evt) {
        monedaDe.setSelectedIndex(0);
        monedaPara.setSelectedIndex(0);
        txtDe.setText(null);
        txtResultado.setText(null);
    }

    private void salir(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertir) {
            if (monedaDe.getSelectedIndex() == 0 || monedaPara.getSelectedIndex() == 0 || txtDe.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);

            } else {

                double montoAConvertir = Double.parseDouble(txtDe.getText());
                double montoEquivalenteEnColones = 0.0;

                switch (monedaDe.getSelectedItem().toString()) {
                    case "Colon Costarricense":
                        montoEquivalenteEnColones = montoAConvertir;
                        break;
                    case "Dolar":
                        montoEquivalenteEnColones = montoAConvertir / dolar;
                        break;
                    case "Euro":
                        montoEquivalenteEnColones = montoAConvertir / euro;
                        break;
                    case "Libra Esterlina":
                        montoEquivalenteEnColones = montoAConvertir / libra;
                        break;
                    case "Yen Japonés":
                        montoEquivalenteEnColones = montoAConvertir / yen;
                        break;
                    case "Won Surcoreano":
                        montoEquivalenteEnColones = montoAConvertir / won;
                        break;
                    default:
                        montoEquivalenteEnColones = 0.0;
                }

                double montoConvertido = 0.0;
                switch (monedaPara.getSelectedItem().toString()) {
                    case "Colon Costarricense":
                        montoConvertido = montoEquivalenteEnColones;
                        break;
                    case "Dolar":
                        montoConvertido = montoEquivalenteEnColones * dolar;
                        break;
                    case "Euro":
                        montoConvertido = montoEquivalenteEnColones * euro;
                        break;
                    case "Libra Esterlina":
                        montoConvertido = montoEquivalenteEnColones * libra;
                        break;
                    case "Yen Japonés":
                        montoConvertido = montoEquivalenteEnColones * yen;
                        break;
                    case "Won Surcoreano":
                        montoConvertido = montoEquivalenteEnColones * won;
                        break;
                    default:
                        montoConvertido = montoEquivalenteEnColones = 0.0;
                }
                String montoFinal = String.format("%.2f", montoConvertido);
                txtResultado.setText(montoFinal);
            }
        }

    }

    public static void main(String[] args) {
        new App();
    }
}
