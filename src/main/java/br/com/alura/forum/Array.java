package br.com.alura.forum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Array {

	private static final String nomeArquivo = "/forum/src/main/resources/usuarios.xlsx";

	public static void main(String[] args) throws IOException {

		Map<String, Set<String>> mapUser = new HashMap<>();
		Usuarios usuario = new Usuarios();
		Set<String> listaUsuarios = null;
		String user;
		String ambiente;
         

         try {
                FileInputStream arquivo = new FileInputStream(new File(nomeArquivo));

                HSSFWorkbook workbook = new HSSFWorkbook(arquivo);

                HSSFSheet sheetUsuarios = workbook.getSheetAt(0);

                Iterator<Row> rowIterator = sheetUsuarios.iterator();
                
                Cell cell;

                while (rowIterator.hasNext()) {
                       Row row = rowIterator.next();
                       Iterator<Cell> cellIterator = row.cellIterator();
                       
                       for(int i=1; i<sheetUsuarios.getPhysicalNumberOfRows() ;i++) {
                    	   
                    	   user = row.getCell(0).toString();
                           ambiente = row.getCell(2).toString();
                       
                           if(listaUsuarios == null) {
                        	   listaUsuarios = new HashSet<String>();
                            }
                           
                           listaUsuarios.add(user);
                           mapUser.put(ambiente, listaUsuarios);
                       
                       }
                       
                       System.out.println(mapUser);
                }
         } catch (FileNotFoundException e) {
             e.printStackTrace();
             System.out.println("Arquivo Excel não encontrado!");
         }
	}
}













