package ucu.oop_2022_middle.handlers;

import ucu.oop_2022_middle.readers.PDLReader;

public class EmployeePDLHandler extends PDLHandler{
    @Override
    public String handle(String domain) {
        super.handle(domain);
        String size = Integer.toString((Integer) PDLReader.getJSON().get("employee_count"));
        if (size == null) {
//            setNext();
            return null;
        }
        else {
            return size;
        }
    }
}
