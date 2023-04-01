import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseAndSort {

    public static String[] parseAndSortUseString(String str){
        String[] result = useStringOut(sortUserList(parseUserString(str)));
        return result;
    }

    private static String isMorF (String str){
        if (str.equals(CONST.FEMALE)) return str;
        if (str.equals(CONST.MALE)) return str;
            else return "e";
    }

    private static String isBirthDate (String str){
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(CONST.DATEFORMAT);
            dateFormatter.parse(str);
            return str;
        } catch (Exception e) {
            return "e";
        }
    }

    private static String isNumber(String str){
        try {
            int num = Integer.parseInt(str);
            if (num < 0) num = -num;
            return str;
        } catch (Exception e) {
            return "e";
        }
    }

    private static List<String> parseUserString(String str){
        List<String> list = new ArrayList<String>(Arrays.asList(str.split(" ")));
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals("")) 
                list.remove(i);
        }
        return list;
    }

    private static int isAllData(List<String> list){
        // пользователь должен ввести 6 параметров (
        // ФИО - 3, адрес - 1, пол - 1, телефон - 1 3+1+1+1=6)
        if (list.size() < CONST.NUMPARAM) return 2;
        if (list.size() > CONST.NUMPARAM) return 3;
            else return 1;
    }


    private static List<String> sortUserList(List<String> list){
        List<String> sortedList = new ArrayList<String>();
        if (isAllData(list) == 1) // Если isAllData вернула 1, то пользователь ввел сколько нужно значений
        {
            //заполняем сортированный список
            for (int i = 0; i < list.size(); i++){
                sortedList.add(null);
            }
            int j = 0; // счетчик заполненности ФИО
            // проверяем
            for (int i = 0; i < list.size(); i++) {
                String string = list.get(i);       
                if (isMorF(string).equals("e")){
                    if (isNumber(string).equals("e")){
                        if (isBirthDate(string).equals("e")){
                            if ((i<3) | (j<3)){// первые три парметра - ФИО
                                sortedList.set(j, string);
                                j++;
                            }
                        }
                        else sortedList.set(3, string); //дата рождения 4й параметр
                    }
                    else sortedList.set(4, string); //номер телефона 5 параметр
                }
                else sortedList.set(5, string);//пол 6й параметр
            }
            return sortedList;
        }
        else {
            sortedList.add(0, "numError");
            return sortedList;
        }
    }

    private static String[] getErrorInUseString (int i) {
        String[] str = {"-1",""};
        if (i == 0 | i == 1 | i == 2){
            str[1] = CONST.NAMEERROR;
        }
        if (i == 3){
            str[1] = CONST.BIRTHERROR;
        }
        if (i == 4){
            str[1] = CONST.TELERROR;
        }
        if (i == 5){
            str[1] = CONST.GENDERERROR;
        }
        return str;
    }
    
    private static String[] useStringOut (List<String> list) {
        String[] str = {"1","",""};
        if (list.get(0).equals("numError")){
            str[0] = "-1";
            str[1] = CONST.NUMDATEERROR;
            return str;
        }
        for (int i = 0; i < list.size(); i++) {
            String tempStr = list.get(i);
                if (tempStr == null){
                    str = getErrorInUseString(i);
                    return str;
                }
                else str[1] = str[1] + "<"+tempStr+">";
        }
        str[2] = list.get(0);
        return str;
    }
}

