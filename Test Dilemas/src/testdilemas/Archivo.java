package testdilemas;

import Pantallas.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Archivo {
    
    public static void CrearArchivo(){
        
        long segundos = (((Dilema1.endPrueba-Dilema1.startPrueba)/1000)%60);
        long minutos = ((((Dilema1.endPrueba-Dilema1.startPrueba)/1000) - segundos)/60);
        String [] titulos={"Usuario","Dilema","Decisión","Tiempo en ms","Fecha/Hora","Tiempo promedio de respuesta","Tiempo total de prueba en min"};
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        int minuto = cal.get(Calendar.MINUTE);
        int segundo = cal.get(Calendar.SECOND);
        File guardar = new File(Registro.Usuario + (" " + year + "-" + (month + 1) + "-" + day) + ".xlsx");
        String hoja = "Hoja1";
        Workbook libro = new XSSFWorkbook();
        Sheet hoja1 = libro.createSheet("hoja");
        String Usuario = Registro.Usuario;
        Elementos elemento = new Elementos();
        long[] Tiempo;
        Tiempo = new long [elemento.EncuentraUltimo()];
        for(int i=0;i<VariablesGlobales.indice;i++){
            Tiempo[i] = Dilema1.finTime[i]-Dilema1.inicioTime[i];
        }
        int i = 0, j = 0;
        int x = 0, y = 0;               
        for (i = 0; i < elemento.EncuentraUltimo(); i++) {
            Row row=hoja1.createRow(i);//se crea las filas
            for (j = 0; j <= 6; j++) {
                if (i == 0) {//para la cabecera
                    Cell cell = row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
                    cell.setCellValue(titulos[j]);//se añade el contenido
                    }else{//para el contenido
                        Cell cell = row.createCell(j);//se crea las celdas para la contenido, junto con la posición
                        if (j == 0) {
                            cell.setCellValue(Usuario); //se añade el contenido
                        }else{
                            if (j == 1) {
                                cell.setCellValue(i);
                            }else{
                                if (j == 2) {
                                    cell.setCellValue(Dilema1.Opciones[x]);
                                    x++;
                                }else{
                                    if (j == 3) {
                                        cell.setCellValue(Tiempo[y]);
                                        y++;
                                    }else{
                                        if (j == 4) {
                                            cell.setCellValue(year + "/" + (month + 1) + "/" + day + " " + hora + ":" + minuto + ":" + segundo);
                                        }else{
                                            if (j == 5 && i == 1) {
                                                for(int z = 0;z<VariablesGlobales.indice;z++){
                                                    cell.setCellValue(Tiempo[z]);
                                                }
                                            }else{
                                                if (j == 6 && i == 1) {
                                                    cell.setCellValue(minutos + ":" + segundos);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        hoja1.autoSizeColumn(0);
        hoja1.autoSizeColumn(1);
        hoja1.autoSizeColumn(2);
        hoja1.autoSizeColumn(3);
        hoja1.autoSizeColumn(4);
        hoja1.autoSizeColumn(5);
        hoja1.autoSizeColumn(6);
        try{
            FileOutputStream fileout= new FileOutputStream(guardar);
            libro.write(fileout);
            fileout.close();
        }catch(FileNotFoundException ex){
            Logger.getLogger(Dilema1.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Dilema1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
