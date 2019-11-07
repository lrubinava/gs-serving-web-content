package hello;



public class Bug {

    public int id;
    public BugStatus status;
    public String title;
    public String created;

    public Bug (int id, BugStatus status, String title, String created){
        this.id = id;
        this.status = status;
        this.title = title;
        this.created = created;
    };
}
