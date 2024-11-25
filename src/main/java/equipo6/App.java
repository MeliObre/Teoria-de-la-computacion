package equipo6;
import java_cup.runtime.Symbol;
import jflex.ErrorEnt;
import jflex.ErrorReal;
import jflex.ErrorString;
import jflex.Lexico;
import jcup.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import static equipo6.TokenConstants.*;

public class App extends Component {
    private JButton buttonLoad;
    private JButton buttonValidateLex;
    private JButton buttonValidateSint;
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
        frame.setTitle("Compilador");
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
        buttonValidateLex = new JButton("Analisis Léxico");
        buttonValidateSint = new JButton("Analisis Sintáctico");
        buttonTable = new JButton("Tabla de Simbolos");
        // Reubicar los botones en la parte inferior derecha
        buttonLoad.setBounds(290, 360, 150, 30);
        buttonValidateLex.setBounds(450, 360, 150, 30);
        buttonValidateSint.setBounds(610, 360, 150, 30);
        buttonTable.setBounds(770, 360, 150, 30);

        // Agregar ActionListeners a los botones
        buttonLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {cargarArchivo();}
        });

        buttonValidateLex.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarArchivo();
            }
        });

        buttonValidateSint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarSint();
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
        frame.add(buttonValidateLex);
        frame.add(buttonValidateSint);
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
    private void validarSint() {
        crearArchivo();
        Lexico lexer = null;
        try {
            String filePath = "src\\main\\java\\equipo6\\archivoActual.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            lexer = new Lexico(reader);
            parser sintactico = new parser(lexer);
            sintactico.parse();
            ArrayList<String> reglas = (ArrayList<String>) sintactico.getList();
            for (int i = 0; i < reglas.size(); i++) {
                String regla = reglas.get(i);
                textAreaResult.append(regla + "\n"); //Salto de linea al final
            }
            sintactico.emptyList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
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
        Lexico lexer = null;
        try {
            String filePath = "src\\main\\java\\equipo6\\archivoActual.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            lexer = new jflex.Lexico(reader);
            Symbol token = null;
            textAreaResult.setText("");
            try {
                token = lexer.next_token();
            } catch (ErrorEnt | ErrorReal | ErrorString | Error e) {
                textAreaResult.append(e.getMessage() + "\n");
                token = new Symbol(TokenConstants.ERROR.ordinal(), "");
            }
            Token tokenActual = new Token(sym.terminalNames[token.sym],String.valueOf(token.value));
            File file = new File("ts.txt");
            FileWriter writer = new FileWriter(file);
            ArrayList<String> lista = new ArrayList<>();
            ArrayList<String> listaId = new ArrayList<>();
            writer.write("NOMBRE TOKEN TIPO VALOR LONGITUD\n");
            while (token.sym != TokenConstants.EOP.ordinal()) {
                tokenActual = new Token(sym.terminalNames[token.sym],String.valueOf(token.value));
                try {
                    if ((token.sym != TokenConstants.ERROR.ordinal())){
                        textAreaResult.append(tokenActual.toString() + "\n"); //solo imprime el id en caso que este repetido
                        if (token.sym == sym.ID && !isRepetido(listaId,tokenActual.getLexeme())){
                            writer.write(tokenActual.getLexeme() + " " + tokenActual.getType() + " -  - - " + "\n");
                            lista.add(tokenActual.getLexeme());
                            lista.add(tokenActual.getType());
                            lista.add("-");
                            lista.add("-");
                            lista.add("-");
                            listaId.add(tokenActual.getLexeme());
                        }
                        if(token.sym ==  sym.CTE_REA || token.sym == sym.CTE_ENT || token.sym == sym.CTE_BIN){
                            writer.write("_" + tokenActual.getLexeme() + " " + tokenActual.getType() + " - " + tokenActual.getLexeme() +  " - " + "\n");
                            lista.add("_" + tokenActual.getLexeme());
                            lista.add(tokenActual.getType());
                            lista.add("-");
                            lista.add(tokenActual.getLexeme());
                            lista.add("-");
                        }
                        if (token.sym == sym.CTE_STR){
                            writer.write("_" + tokenActual.getLexeme().replaceAll("\"", "") + " " +
                                    tokenActual.getType() + " - " + tokenActual.getLexeme().replaceAll("\"", "") +  " " + (tokenActual.getLexeme().length()-2) + "\n");
                            lista.add("_" + tokenActual.getLexeme().replaceAll("\"", ""));
                            lista.add(tokenActual.getType());
                            lista.add("-");
                            lista.add(tokenActual.getLexeme().replaceAll("\"", ""));
                            int lenght = (tokenActual.getLexeme().length()-2);
                            lista.add(Integer.toString(lenght));
                        }
                    }
                    token = lexer.next_token();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ErrorEnt | ErrorReal | ErrorString | Error e) {
                    textAreaResult.append(e.getMessage() + "\n");
                    token = new Symbol(TokenConstants.ERROR.ordinal(), "");
                }
            }
            lexer = new Lexico(reader);
            parser sintactico = new parser(lexer);
            //sintactico.debug_parse();
            reader.close();
            writer.close();
            listaTabla.setLista(lista);
            buttonTable.setEnabled(true);
        } catch (IOException e) {e.printStackTrace();} catch (Exception e) {
            throw new RuntimeException(e);
        }
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



































