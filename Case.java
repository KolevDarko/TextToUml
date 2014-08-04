/**
 * Created by darko on 28.6.14.
 */
public class Case {
    private Actor left,right;
    private Action action;


    public Case(Actor left, Action action) {
        this.left = left;
        this.right = null;
        this.action = action;
    }

    public Case(Actor left, Actor right, Action action) {
        this.left = left;
        this.right = right;
        this.action = action;
    }

    @Override
    public String toString(){
        String rightString = (this.right != null)? this.right.toString() : "";
        StringBuffer output =new StringBuffer();

                output.append(left.toString() + rightString + action.toString());
                output.append(left.alias + "->" + action.alias  + action.label1 + "\n");
                if(rightString != "") {

                    output.append(action.alias + "->" + right.alias + action.label2 + "\n");
                }
            return output.toString();
    }


}
