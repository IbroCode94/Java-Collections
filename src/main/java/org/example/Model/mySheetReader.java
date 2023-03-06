package org.example.Model;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class mySheetReader {

    Mall mall;

    public mySheetReader(Mall mall) {
        this.mall= mall;
    }
    public void productList(String fileName){

        try {
            FileInputStream fileIs = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(fileIs);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowLength = sheet.getLastRowNum();
            for(int r = 1; r <= rowLength; r++){
                Row row = sheet.getRow(r);
                var productCell = row.getCell(0).getStringCellValue();
                var categoryCell = row.getCell(1).getStringCellValue();
                var priceCell = row.getCell(2).getNumericCellValue();
                var quantityCell = (int) row.getCell(3).getNumericCellValue();
                Products product = new Products(productCell, categoryCell,priceCell, quantityCell);
                mall.getProductsList().add(product);
            }


        }catch (IOException e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }
}

