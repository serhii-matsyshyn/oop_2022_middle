package ucu.oop_2022_middle.handlers.PDLHandlers;

import ucu.oop_2022_middle.readers.PDLReader;

public class NamePDLHandler extends  PDLHandler{
    @Override
    public String handle(String domain) {
        super.handle(domain);
        String name = (String) PDLReader.getJSON().get("name");
        if (name == null) {
//            setNext();
            return null;
        }
        else {
            return name;
        }
    }
}
