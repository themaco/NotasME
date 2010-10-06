
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Notas extends MIDlet implements CommandListener {

    // elementos de la GUI
    private Display display;

    private List lstMenu;           // menu principal
    private Command cmdSalir;
    private Command cmdSeleccionar;

    private Form frmIngresoNotas;   // formulario de ingreso de notas
    private StringItem porcentajeTotal;
    private TextField txtNota;
    private TextField txtPorcentaje;
    private TextField txtNumEval;
    private ChoiceGroup  radTipoEval;
    private Command cmdCancelar;
    private Command cmdGuardar;

    private Alert altDialogo;       // 'dialogo' de confirmacion
    private Command cmdSi;
    private Command cmdNo;

    private TextBox tbxNotas;       // listado de notas ingresadas
    private Command cmdAceptar;

    private Alert altNotaCiclo;     // alerta de nota parcial

    // atributos del midlet
    private int porcentajeAcumulado = 0;
//    private float notaParcial = 0;
    private String materia;

    public Displayable mostrarMenu(){
        lstMenu = new List(materia, List.IMPLICIT); // implicit permite seleccionar solo un item a la vez
        // agregar elementos del menu
        lstMenu.append("Ingresar notas", null);
        lstMenu.append("Ver notas guardadas", null);
        lstMenu.append("Ver nota de ciclo", null);
        lstMenu.append("Borrar notas", null);
        cmdSeleccionar = new Command("Seleccionar", Command.ITEM, 0);
        cmdSalir = new Command("Salir",Command.EXIT,0); // mayor prioridad para que se mueste en toda la app
        lstMenu.addCommand(cmdSalir);
        lstMenu.setSelectCommand(cmdSeleccionar); // si no se establece se cuenta con un commando por defecto
        lstMenu.setCommandListener(this);
        return lstMenu;
    }

    public Displayable mostrarIngresoNotas(){
        frmIngresoNotas = new Form("Ingreso de notas");
        porcentajeTotal = new StringItem(null, "Porcentaje ingresado: "+ porcentajeAcumulado +"%", Item.PLAIN);
        radTipoEval = new ChoiceGroup("Tipo de evaluacion", ChoiceGroup.EXCLUSIVE, new String[] {"Laboratorio","Parcial","Tarea"}, null);
        // el tipo de TextFiel restringe el tipo de datos a introduccir en el campo
        txtNumEval = new TextField("Numero de evaluacion:", "", 1, TextField.NUMERIC);
        txtPorcentaje = new TextField("Porcentaje", "", 2, TextField.NUMERIC);
        txtNota = new TextField("Nota", "", 6, TextField.DECIMAL);
        // agregar campos al formulario
        frmIngresoNotas.append(porcentajeTotal);
        frmIngresoNotas.append(radTipoEval);
        frmIngresoNotas.append(txtNumEval);
        frmIngresoNotas.append(txtPorcentaje);
        frmIngresoNotas.append(txtNota);
        cmdGuardar = new Command("Guardar", Command.OK, 0);
        frmIngresoNotas.addCommand(cmdGuardar);
        cmdCancelar = new Command("Cancelar", Command.CANCEL, 0);
        frmIngresoNotas.addCommand(cmdCancelar);
        frmIngresoNotas.setCommandListener(this);
        return frmIngresoNotas;
    }

    public Alert mostrarDialogo(){
        altDialogo = new Alert("Ingreso de notas","Desea seguir agregando notas?",null,AlertType.CONFIRMATION);
        // cada fabricante implementa de diferente manera los distintos tipos de alerta
        altDialogo.setTimeout(Alert.FOREVER); // muestra la alerta hasta que el usuario presiona una tecla
        cmdSi = new Command("Si", Command.ITEM, 0); // tambien se puede personalizar los comandos de una alerta
        cmdNo = new Command("No", Command.ITEM, 0);
        altDialogo.addCommand(cmdSi);
        altDialogo.addCommand(cmdNo);
        altDialogo.setCommandListener(this);
        return altDialogo;
    }

    public Displayable mostrarNotas(){
        String [][] notas = RegistroNotas.obtenerNotas();
        tbxNotas = new TextBox(materia + " - notas","",255, TextField.UNEDITABLE); // que no se puede modificar
        // a diferencia del TextField, TextBox implementa la interfaz Displayable
        if(notas != null){
            for(int i=0; i<notas[0].length; i++){
                tbxNotas.setString(tbxNotas.getString() + notas[0][i] + " - " + notas[1][i] + " - " + notas[2][i] + "\n");
            }
        } else{
            tbxNotas.setString("No ha introducido notas aun");
        }
        cmdAceptar = new Command("Aceptar",Command.ITEM, 0);
        tbxNotas.addCommand(cmdAceptar);
        tbxNotas.setCommandListener(this);
        return tbxNotas;

    }

    private Alert mostrarNotaParcial(){
        altNotaCiclo = new Alert(materia + " - nota de ciclo", "Su nota de ciclo es: " + String.valueOf(RegistroNotas.obtenerNotaParcial()),null,AlertType.INFO);
        altNotaCiclo.setTimeout(Alert.FOREVER); // muestra la alerta hasta que el usuario presiona una tecla
        return altNotaCiclo;
    }

    public Notas(){
        // obtener los valores de los atributos
        porcentajeAcumulado = RegistroNotas.obtenerPorcentajeAcumulado();
        float temp = RegistroNotas.obtenerNotaParcial();
//        notaParcial = (float)porcentajeAcumulado / 100f * temp;
        // obtener una configuracion de Manifiesto
        materia = this.getAppProperty("materia");
        // obtener el objeto display del midlet
        display = Display.getDisplay(this);
    }

    public void startApp() {
        // mostrar el menu principal 
        display.setCurrent(mostrarMenu());
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c.equals(cmdSalir)) {
            destroyApp(false);//si se tubiese que hacer alguna operacion antes de cerrar
            notifyDestroyed();
        }
        else{
            if(c.equals(cmdSeleccionar)){
                // ver opcion del menu selecionada
                switch(lstMenu.getSelectedIndex())
                {
                    case 0: //ingreso de notas
                        display.setCurrent(mostrarIngresoNotas());
                        break;
                    case 1: //ver notas
                        display.setCurrent(mostrarNotas());
                        break;
                    case 2: //calcular nota de ciclo
                        display.setCurrent(mostrarNotaParcial(), d);
                        break;
                    case 3: //borrar notas
                        if(RegistroNotas.borrarNotas()){
                            Alert aviso = new Alert(null, "Sus notas fueron borradas",null,AlertType.INFO);
                            aviso.setTimeout(Alert.FOREVER);
                            display.setCurrent(aviso,d);
                        }
                        break;
                }
            }
            if(c.equals(cmdGuardar)){
                /** TODO: - validar que el porcentaje ingresado no exceda 100
                 *        - validar que la nota ingresada se encuentre entre 0.0f y 10.0f
                 *        - capturar la posible NumberFormatException
                 */
                int porcentaje = Integer.parseInt(txtPorcentaje.getString());
//                float nota = Float.parseFloat(txtNota.getString());
                porcentajeAcumulado += porcentaje;  //acumular el porcentaje introducido
//                nota = (float)porcentaje / 100f * nota; //calcular nota de la evaluacion ingresada
//                notaParcial += nota; //acumular la nota parcial
                // guardar el registro(evaluacion, porcentaje y nota)
                RegistroNotas.guardarNota(radTipoEval.getString(radTipoEval.getSelectedIndex()) + txtNumEval.getString(),
                        txtPorcentaje.getString(),
                        txtNota.getString());
                if(porcentajeAcumulado < 100)
                    display.setCurrent(mostrarDialogo(), d);
                else
                    display.setCurrent(mostrarNotaParcial(), mostrarMenu());
            }
            if(c.equals(cmdAceptar)){
                // regresar al menu de la aplicacion
                display.setCurrent(mostrarMenu());
            }
            if(c.equals(cmdCancelar)){
                // regresar al menu de la aplicacion
                display.setCurrent(mostrarMenu());
            }
            if(c.equals(cmdSi)){
                //volver a mostra el formulario de ingreso de notas
                display.setCurrent(mostrarIngresoNotas());
            }
            if(c.equals(cmdNo)){
                // mostrar la nota parcial  y regresarlo al menu
                display.setCurrent(mostrarNotaParcial(),mostrarMenu());
            }
        }
    }    
}