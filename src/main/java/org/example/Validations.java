package org.example;

public class Validations {
    public static boolean validateName (String name){
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        name = name.trim();
        name = name.replaceAll("\\s+", " "); //remove extra spaces in the middle
        String pattern = "^[A-Za-z]+\\s[a-zA-Z]+$";   //pattern bt check en kolo letters only b3dha fy space wahda bs b3dha letters only again (first and last name)
        if(name.length()<3) { //if too short b return false
            return false;
        }
        return name.matches(pattern);
    }

    public static boolean validateEmail(String email){
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        email = email.trim();
        String pattern = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$"; //pattern bt check en kolo characters aw dot aw dash w keda abl w b3d el @ w ends with . ay haga b2a min 2
        return email.matches(pattern);
    }

    public static boolean validateGpa(String gpa) {
        if (gpa == null || gpa.trim().isEmpty()) {
            return false;
        }
        gpa = gpa.trim();
        try {
            double num = Double.parseDouble(gpa);
            return num >= 0.00 && num <= 4.00;
        } catch (NumberFormatException e) { //lw elparse failed (msh numbers y3ny)
            return false;
        }
    }

    public static boolean validateGpa(double gpa) { //overload 3l4an lw b3t double msh string
        return gpa >= 0.00 && gpa <= 4.00;
    }

    public static boolean validateAge(String age) {
        if (age == null || age.trim().isEmpty()) {
            return false;
        }
        age = age.trim();
        try {
            int num = Integer.parseInt(age); //must be int
            return num >= 5 && num <= 30;
        } catch (NumberFormatException e) { //lw elparse failed
            return false;
        }
    }

    public static boolean validateAge(int age) { //overload 3l4an lw b3t int msh string
        return age >= 5 && age <= 30;
    }

    public static boolean validateGender(String gender) { //fy halet en add student el gender msh combo/radio box
        if (gender == null || gender.trim().isEmpty()) {
            return false;
        }
        gender = gender.trim().toLowerCase();
        return gender.equals("male") || gender.equals("female");
    }

    public static boolean validateDepartment(String department) {
        return department != null && !department.trim().isEmpty();
    }

    public static boolean validateID(int id) {
        return id <= 999999 && id > 99;
    }

    public static boolean validateID(String id) { //overload
        if (id == null || id.trim().isEmpty()) {
            return false;
        }
        id = id.trim();
        try{
            int num = Integer.parseInt(id);
            return num <= 999999 && num > 99;
        } catch (NumberFormatException e) { //parse failed
            return false;
        }
    }

}