
import javax.microedition.rms.*;

public class RegistroNotas {

    private static RecordStore rsNotas;
    private static RecordEnumeration reNotas;
    private static String RECORD_NOTAS = "notas";

    public static void guardarNota(String evaluacion, String porcentaje, String nota) {
        try {
            //obtener el Registro de notas, si este no existe crearlo
            rsNotas = RecordStore.openRecordStore(RECORD_NOTAS, true);
            rsNotas.addRecord(evaluacion.getBytes(), 0, evaluacion.getBytes().length);
            rsNotas.addRecord(porcentaje.getBytes(), 0, porcentaje.getBytes().length);
            rsNotas.addRecord(nota.getBytes(), 0, nota.getBytes().length);
            rsNotas.closeRecordStore();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    public static String[][] obtenerNotas(){
        String[][] notas = null;
        int i=0;
        try {
            rsNotas = RecordStore.openRecordStore(RECORD_NOTAS, false);
            // obtener una enumeracion de registros, notese que la implementacion
            // de esta interfaz retorna el ultimo registro y se recorre hacia atras.
            // Esto puede variar segun el fabricante del movil y la configuracion usada
            // Si se implementa un RecordComparator se puede establecer un orden predefinido
            // e implementar un RecordFilter permite seleccionar los registros que cumplan
            // una condicion especifica
            reNotas = rsNotas.enumerateRecords(null, null, true);
            notas = new String[3][rsNotas.getNumRecords()/3]; //dimensionar la matriz
            while(reNotas.hasNextElement()){
                notas[0][i] = new String(reNotas.nextRecord()); // evaluacion
                notas[1][i] = new String(reNotas.nextRecord()); // porcentaje
                notas[2][i] = new String(reNotas.nextRecord()); // nota
                i++;
            }
            reNotas.destroy();
            rsNotas.closeRecordStore();
        } catch (RecordStoreException ex) {
//            ex.printStackTrace();
            System.err.println("No hay datos");
        } finally {
            return notas;
        }
    }

    public static int obtenerPorcentajeAcumulado(){
        int porcentajeAcumulado = 0;
        String temp;
        try {
            rsNotas = RecordStore.openRecordStore(RECORD_NOTAS, false);
            reNotas = rsNotas.enumerateRecords(null, null, true);
            while (reNotas.hasNextElement()) {
                reNotas.nextRecord(); // mover hasta el registro de porcentaje
                temp = new String(reNotas.nextRecord()); // guardar porcentaje
                porcentajeAcumulado += Integer.parseInt(temp);
                reNotas.nextRecord(); // mover hasta el siguente registro
            }
            reNotas.destroy();
            rsNotas.closeRecordStore();
        } catch (RecordStoreException ex) {
//            ex.printStackTrace();
            System.err.println("No hay datos");
        } finally{
            return porcentajeAcumulado;
        }
    }
    
    public static float obtenerNotaParcial(){
        float notaParcial = 0.0f;
        int porcentaje = 0, i;
        String temp;
        try {
            rsNotas = RecordStore.openRecordStore(RECORD_NOTAS, false);
            // otro metodo para recorrer un RecordStore
            for (i = 1; i<=rsNotas.getNumRecords(); i++){
                // mover hasta el registro de porcentaje
                temp = new String(rsNotas.getRecord(++i));
                porcentaje = Integer.parseInt(temp);
                temp = new String(rsNotas.getRecord(++i));
                // acumular la nota parcial
                notaParcial += ((float)porcentaje/100f * Float.parseFloat(temp));
            }
//            while (reNotas.hasNextElement()) {
//                temp = new String(reNotas.nextRecord()); // mover hasta el registro de porcentaje
//                porcentaje = Integer.parseInt(temp);
//                temp = new String(reNotas.nextRecord()); // mover hasta el registro de nota
//                notaParcial += ((float)porcentaje/100f * Float.parseFloat(temp)); // acumular la nota a la nota parcial
//            }
//            reNotas.destroy();
            rsNotas.closeRecordStore();
        } catch (RecordStoreException ex) {
//            ex.printStackTrace();
            System.err.println("No hay datos");
        } finally{
            return notaParcial;
        }
    }

    public static boolean borrarNotas(){
        try {
            RecordStore.deleteRecordStore(RECORD_NOTAS);
            return true;
        } catch (RecordStoreException ex) {
//            ex.printStackTrace();
            return false;
        } 
    }
}
