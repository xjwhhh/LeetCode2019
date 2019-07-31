import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path.length()==0){
            return null;
        }
        Stack<String> stack=new Stack<>();
        String[] pathArray=path.split("/");
        for(int i=0;i<pathArray.length;i++){
            if(pathArray[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(pathArray[i].equals(".")||pathArray[i].equals("")){
                continue;
            }else{
                stack.push(pathArray[i]);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        String result="";
        while(!stack.isEmpty()){
            result=("/"+stack.pop())+result;
        }

        return result;
    }
}
