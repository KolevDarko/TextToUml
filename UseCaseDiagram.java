import java.util.ArrayList;

/**
 * Created by darko on 29.6.14.
 */
public class UseCaseDiagram {
    public ArrayList<Case> cases;

    public UseCaseDiagram() {
        cases = new ArrayList<Case>();
    }

    @Override
    public String toString(){
        StringBuffer result = new StringBuffer();
        result.append("@startuml \n");
        for(Case temp: cases){
            result.append(temp.toString());
        }
        result.append("@enduml \n");
        return result.toString();
    }

}
