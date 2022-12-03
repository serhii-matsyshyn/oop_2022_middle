package ucu.oop_2022_middle.handlers;

import ucu.oop_2022_middle.readers.PDLReader;

public abstract class PDLHandler implements Handler {
    Handler nextHandler;
//    private static final JSONObject PDLJSON;
//    public PDLHandler(String domain){
//        if (PDLJSON == null) {
//            PDLJSON = PDLReader.getJSONOf(domain);
//        }
//    }
    @Override
    public String handle(String domain) {

        if (PDLReader.getJSON() == null) {
            PDLReader.setJSON(domain);
        }
        return  null;
    }

    @Override
    public void setNext(Handler h) {
        //nextHandler.

    }
}
