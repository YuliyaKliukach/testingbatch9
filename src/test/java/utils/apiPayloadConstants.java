package utils;


import org.json.JSONObject;

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

   public static String createEmployeeBody(){

       JSONObject obj = new JSONObject();
       obj.put("emp_firstname", "Viktor");
       obj.put("emp_lastname", "Kliukach");
       obj.put("emp_middle_name", "Stepanovich");
       obj.put("emp_gender", "M");
       obj.put("emp_birthday", "1963-12-17");
       obj.put("emp_status", "Employee");
       obj.put("emp_job_title", "Developer");

       return obj.toString();
   }

   public static String createEmployeeBodyDynamic(String firstName, String lastName, String middleName, String gender, String empBD,
                                                  String empStatus, String empJobTitle){
       JSONObject obj = new JSONObject();
       obj.put("emp_firstname", firstName);
       obj.put("emp_lastname", lastName);
       obj.put("emp_middle_name", middleName);
       obj.put("emp_gender", gender);
       obj.put("emp_birthday", empBD);
       obj.put("emp_status", empStatus);
       obj.put("emp_job_title", empJobTitle);

       return obj.toString();
   }
}
