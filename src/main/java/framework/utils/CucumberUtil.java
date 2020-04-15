package framework.utils;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;


public class CucumberUtil {
  private static List<DataCollection> dataCollection = new ArrayList<>();

  public static void ConvertDataTableToList(DataTable table) {
    dataCollection.clear();

    List<List<String>> data = table.asLists();

    int rowNumber = 0;

    for (List<String> col : data) {
      for (int colIndex = 0; colIndex < col.size(); colIndex++) {
        dataCollection.add(rowNumber, new DataCollection(data.get(0).get(colIndex), col.get(colIndex), rowNumber));
      }

      rowNumber++;
    }

  }

  public static String GetCellValueWithRowIndex(String columnName, int rowNumber) {
    final String[] columnValue = {null};
    dataCollection.forEach(x -> {
      if (x.ColumnName.equals(columnName) && x.RowNumber == rowNumber) {
        columnValue[0] = x.ColumnValue;
      }
    });
    return columnValue[0];
  }

  private static class DataCollection {
    private String ColumnName;
    private String ColumnValue;
    private int RowNumber;

    DataCollection(String columnName, String columnValue, int rowNumber) {
      ColumnName = columnName;
      ColumnValue = columnValue;
      RowNumber = rowNumber;
    }
  }
}



