package ucu.oop_2022_middle.handlers.PDLHandlers;

import ucu.oop_2022_middle.readers.PDLReader;

public class CheckEmployeeSizePDLHandler extends  PDLHandler{
    @Override
    public String handle(String domain) {
        super.handle(domain);
        String size = (String) PDLReader.getJSON().get("size");
        if (size == null) {
//            setNext();
            return null;
        }
        else {
            return size;
        }
    }
}
