package equipo6;
import jflex.ErrorEnt;
import jflex.ErrorReal;
import jflex.Lexico;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class App extends Component {
    private JButton buttonLoad;
    private JButton buttonValidate;
    private JTextArea textAreaInput;
    private JTextArea textAreaResult;
    public JFrame frame;

    public App() throws FileNotFoundException {
        frame = new JFrame();
        frame.setSize(1100, 500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setTitle("Compilador Lexico");
        //frame.setModal(true);
        frame.setLayout(null); // Usar layout nulo

        // Inicializar JTextAreas
        textAreaInput = new JTextArea();
        textAreaResult = new JTextArea();
        textAreaResult.setEditable(false); // No editable para el área de resultados

        // Configurar JScrollPane para cada JTextArea
        JScrollPane scrollInput = new JScrollPane(textAreaInput);
        JScrollPane scrollResult = new JScrollPane(textAreaResult);

        // Configurar el tamaño de los JScrollPane y JTextArea
        scrollInput.setBounds(10, 40, 500, 300);  // Agrandé el área de entrada
        scrollResult.setBounds(520, 40, 500, 300); // Agrandé el área de resultados

        // Añadir títulos
        JLabel labelInput = new JLabel("Entrada");
        JLabel labelResult = new JLabel("Resultado");
        labelInput.setBounds(10, 10, 100, 25);
        labelResult.setBounds(520, 10, 100, 25);

        // Inicializar botones
        buttonLoad = new JButton("Cargar Archivo");
        buttonValidate = new JButton("Analisis léxico");
        // Reubicar los botones en la parte inferior derecha
        buttonLoad.setBounds(610, 360, 150, 30);
        buttonValidate.setBounds(770, 360, 150, 30);

        // Agregar ActionListeners a los botones
        buttonLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {cargarArchivo();}
        });

        buttonValidate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarArchivo();
            }
        });

        // Manejar el cierre de la ventana
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // Asignar acción de Escape para validar archivo
        frame.getRootPane().registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarArchivo();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        // Agregar componentes a la ventana
        frame.add(scrollInput);
        frame.add(scrollResult);
        frame.add(labelInput);
        frame.add(labelResult);
        frame.add(buttonLoad);
        frame.add(buttonValidate);

        frame.setSize(1050, 450);  // Agrandé la ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana
    }

    private void crearArchivo() {
        File file = new File("src\\main\\java\\ejemploFlex\\prueba.txt");

        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file);
            writer.write(textAreaInput.getText());
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void cargarArchivo(){
        try{
            JFileChooser selectorArchivo = new JFileChooser();
            selectorArchivo.showOpenDialog(this);
            File file = selectorArchivo.getSelectedFile(); /* abre el archivo seleccionado*/
            if(file!=null){ /*recorre el archivo */
                if (file.getName().endsWith(".txt")){
                    FileReader reader = new FileReader(file);
                    BufferedReader bf=new BufferedReader(reader);
                    textAreaInput.setText("");
                    String cadena = bf.readLine();
                    while(cadena != null){
                        textAreaInput.setText(textAreaInput.getText() + cadena + "\n");
                        cadena = bf.readLine();
                    }
                    bf.close();
                    reader.close();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Solo puede seleccionar achivos de texto",
                            "ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,e+"" +
                            "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void validarArchivo() {
        crearArchivo();
        try {
            String filePath = "src\\main\\java\\ejemploFlex\\prueba.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            Lexico lexer = new jflex.Lexico(reader);
            Token token = null;
            textAreaResult.setText("");
            try {
                token = lexer.yylex();
            } catch (ErrorEnt e) {
                textAreaResult.append("error rango entero\n");//provisional
                token = new Token(TokenConstants.ERROR, "");
            } catch (ErrorReal e) {
                textAreaResult.append("error rango real\n");//provisional
                token = new Token(TokenConstants.ERROR, "");
            }

            File file = new File("src\\main\\java\\ejemploFlex\\ts.txt");
            FileWriter writer = new FileWriter(file);
            textAreaResult.append("NOMBRE        "+"TOKEN        "+"TIPO        "+"VALOR        "+"LONG        \n");
            writer.write("NOMBRE        "+"TOKEN        "+"TIPO        "+"VALOR        "+"LONG        \n");
                while (token.getType() != TokenConstants.EOF) {
                    try {
                        if (token.getType() != TokenConstants.ERROR) {
                            writer.write(token.toString() + "\n");
                            textAreaResult.append(token.toString() + "\n");
                        }
                        token = lexer.yylex();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ErrorEnt e) {
                        textAreaResult.append("error rango entero\n");//provisional
                        token = new Token(TokenConstants.ERROR, "");
                    } catch (ErrorReal e) {
                        textAreaResult.append("error rango real\n");//provisional
                        token = new Token(TokenConstants.ERROR, "");
                    }
                }
            reader.close();
            writer.close();
        } catch (IOException e) {e.printStackTrace();}
    }



    // Métodos crearArchivo y validarArchivo (sin cambios)...

    public static void main(String[] args) {
        //App dialog;

        try {
            new App();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}



































