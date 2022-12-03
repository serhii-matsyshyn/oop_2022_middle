package ucu.oop_2022_middle.handlers.PDLHandlers;

import ucu.oop_2022_middle.readers.PDLReader;

public class EmployeePDLHandler extends PDLHandler{
    @Override
    public String handle(String domain) {
        super.handle(domain);
        Integer size = (Integer) PDLReader.getJSON().get("employee_count");
        if (size == null) {
            setNext(new CheckEmployeeSizePDLHandler());
            return nextHandler.handle(domain);
        }
        else {
            return size.toString();
        }
    }
}
