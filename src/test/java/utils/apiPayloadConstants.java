package utils;

public class apiPayloadConstants {

   public static String createEmployeePayload(){
       String createEmployeePayload="{\n" +
               "  \"emp_firstname\": \"Viktor\",\n" +
               "  \"emp_lastname\": \"Kliukach\",\n" +
               "  \"emp_middle_name\": \"Stepanovich\",\n" +
               "  \"emp_gender\": \"M\",\n" +
               "  \"emp_birthday\": \"1963-12-17\",\n" +
               "  \"emp_status\": \"Employee\",\n" +
               "  \"emp_job_title\": \"Developer\"\n" +
               "}";

       return createEmployeePayload;
   }
}
