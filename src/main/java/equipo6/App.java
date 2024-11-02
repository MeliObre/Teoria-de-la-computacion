package equipo6;
import jflex.ErrorEnt;
import jflex.ErrorReal;
import jflex.ErrorString;
import jflex.Lexico;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import static equipo6.TokenConstants.*;

public class App extends Component {
    private JButton buttonLoad;
    private JButton buttonValidate;
    private JButton buttonTable;
    private JTextArea textAreaInput;
    private JTextArea textAreaResult;
    public JFrame frame;
    private TablaSimbolos listaTabla = new TablaSimbolos();

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
        buttonTable = new JButton("Tabla de simbolos");
        // Reubicar los botones en la parte inferior derecha
        buttonLoad.setBounds(450, 360, 150, 30);
        buttonValidate.setBounds(610, 360, 150, 30);
        buttonTable.setBounds(770, 360, 150, 30);

        // Agregar ActionListeners a los botones
        buttonLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {cargarArchivo();}
        });

        buttonValidate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarArchivo();
            }
        });

        buttonTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarTabla();
                buttonTable.setEnabled(false);
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
        frame.add(buttonTable);
        buttonTable.setEnabled(false);
        frame.setSize(1050, 450);  // Agrandé la ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana
    }

    private void crearArchivo() {
        File file = new File("src\\main\\java\\equipo6\\archivoActual.txt");

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
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validarArchivo() {
        crearArchivo();
        try {
            String filePath = "src\\main\\java\\equipo6\\archivoActual.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            Lexico lexer = new jflex.Lexico(reader);
            Token token = null;
            textAreaResult.setText("");

            try {
                token = lexer.yylex();
            } catch (ErrorEnt | ErrorReal | ErrorString | Error e) {
                textAreaResult.append(e.getMessage() + "\n");
                token = new Token(TokenConstants.ERROR, "");
            }

            File file = new File("ts.txt");
            FileWriter writer = new FileWriter(file);
            ArrayList<String> lista = new ArrayList<>();
            ArrayList<String> listaId = new ArrayList<>();
            writer.write("NOMBRE TOKEN TIPO VALOR LONGITUD\n");
            while (token.getType() != TokenConstants.EOF) {
                try {
                    if ((token.getType() != TokenConstants.ERROR)){
                        textAreaResult.append(token.toString() + "\n"); //solo imprime el id en caso que este repetido
                        if (token.getType() == ID && !isRepetido(listaId,token.getLexeme())){
                            writer.write(token.getLexeme() + " " + token.getType() + " -  - - " + "\n");
                            lista.add(token.getLexeme());
                            lista.add(token.getType().toString());
                            lista.add("-");
                            lista.add("-");
                            lista.add("-");
                            listaId.add(token.getLexeme());
                        }
                        if(token.getType() == CTE_REA || token.getType() == CTE_ENT || token.getType() == CTE_BIN){
                            writer.write("_" + token.getLexeme() + " " + token.getType() + " - " + token.getLexeme() +  " - " + "\n");
                            lista.add("_" + token.getLexeme());
                            lista.add(token.getType().toString());
                            lista.add("-");
                            lista.add(token.getLexeme());
                            lista.add("-");
                        }
                        if (token.getType() == CTE_STR){
                            writer.write("_" + token.getLexeme().replaceAll("\"", "") + " " +
                                    token.getType() + " - " + token.getLexeme().replaceAll("\"", "") +  " " + (token.getLexeme().length()-2) + "\n");
                            lista.add("_" + token.getLexeme().replaceAll("\"", ""));
                            lista.add(token.getType().toString());
                            lista.add("-");
                            lista.add(token.getLexeme().replaceAll("\"", ""));
                            int lenght = (token.getLexeme().length()-2);
                            lista.add(Integer.toString(lenght));
                        }
                    }
                    token = lexer.yylex();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ErrorEnt | ErrorReal | ErrorString | Error e) {
                    textAreaResult.append(e.getMessage() + "\n");
                    token = new Token(TokenConstants.ERROR, "");
                }
            }
            reader.close();
            writer.close();
            listaTabla.setLista(lista);
            buttonTable.setEnabled(true);
        } catch (IOException e) {e.printStackTrace();}
    }

    private boolean isRepetido(ArrayList<String> listaId, String lexema){
        for (String id : listaId) {
            if (id.equals(lexema)){
                return true;
            }
        }
        return false;
    }

    private void mostrarTabla(){
        JFrame frameTabla = new JFrame();
        frameTabla.setTitle("Tabla de Simbolos");
        //se suma una fila para los encabezados
        JTable tabla = new JTable(new DefaultTableModel(listaTabla.getNombreColumnas() , listaTabla.getFilaTamanio() + 1));
        JScrollPane scrollTabla = new JScrollPane(tabla);
        frameTabla.setSize(1100,500);
        tabla.setSize(1100,500);
        frameTabla.add(scrollTabla);
        frameTabla.setVisible(true);
        tabla.setVisible(true);
        frameTabla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //agrego valores a la tabla grafica
        for (int i = 0; i < listaTabla.getFilaTamanio(); i++) {
            for (int j = 0; j < listaTabla.getColumnaTamanio(); j++) {
                tabla.setValueAt(listaTabla.getValueAt(i,j), i, j);
            }
        }
    }
    public static void main(String[] args) {
        //App dialog;

        try {
            new App();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}



































