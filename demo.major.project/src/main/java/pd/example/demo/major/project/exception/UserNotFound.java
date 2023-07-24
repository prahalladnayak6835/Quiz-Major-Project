package pd.example.demo.major.project.exception;

public class UserNotFound extends RuntimeException{
    private String msg;
    public UserNotFound(){};
    public UserNotFound(String msg){
        super();
        this.msg=msg;
        System.out.println(msg);
    }

}
