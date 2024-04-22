public class Delimiters {
    
    private String openDel;
    private String closeDel;

    public Delimiters(String open, String close){
        openDel = open;
        closeDel = close;
    }

    public ArrayList<String> getDelimitersList (String[] tokens){
        ArrayList<String> delimiters = new ArrayList<String>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals(openDel) || tokens[i].equals(closeDel)){
                delimiters.add(tokens[i]);
            }
        }
        return delimiters;

    }

    public boolean isBalanced(ArrayList<String> delimiters){
        int openDelimiter = 0;
        int closedDelimiter = 0;
        boolean balanced = true;
        for(int i = 0; i < delimiters.length; i++){
            if(delimiters.get[i].equals(openDel)){
                openDelimiter++;
            }
            else if(delimiters.get[i].equals(closeDel)){
                closedDelimiter++;
            }
            if(closedDelimiter > openDelimiter){
                balanced = false;
            }
        }
        if(closedDelimiter != openDelimiter){
            balanced = false;
        }
        return balanced;
    }
}
