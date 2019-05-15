package util;

import model.DiffJobData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DiffJobDataLoader {
  private static final String SEPARATOR = ",";
  private DiffJobDataLoader(){
  }

  public static List<DiffJobData> loadCSV(String csvFile) throws IOException{
    List<DiffJobData> jobList = new LinkedList<>();

    BufferedReader br = new BufferedReader(new FileReader(csvFile));
    String line = br.readLine(); // Skip header row
    while ((line = br.readLine()) != null) {
      String[] data = line.split(SEPARATOR);
      DiffJobData jobData = new DiffJobData(Integer.parseInt(data[0]));
      jobData.setRoot(data[1]);
      jobData.setVulHash(data[2]);
      jobData.setUnvulHash(data[3]);

      String[] fileList = data[4].split("#");
      for(String file : fileList){
        jobData.addFileList(file);
      }

      jobData.setShownFunction(data[5]);

      jobData.getDiffJobOptions().setExportPath("D:\\cfg");
      jobData.getDiffJobOptions().setShownInterface("none");
      jobList.add(jobData);
    }
    br.close();

    return jobList;
  }
}
