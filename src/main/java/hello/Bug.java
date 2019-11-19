package hello;

public class Bug {

    private long id;
    private BugStatus status;
    private String title;
    private String created;

    // getters
    public long getId() { return id; }
    public BugStatus getStatus() { return status; }
    public String getTitle() { return title; }
    public String getCreated() { return created; }

    // setters
    public void setId(long id) { this.id = id; }
    public void setStatus(BugStatus status) { this.status = status; }
    public void setTitle(String title) { this.title = title; }
    public void setCreated(String created) { this.created = created; }

    // old constructor
    //    public Bug (int id, BugStatus status, String title, String created){
//        this.id = id;
//        this.status = status;
//        this.title = title;
//        this.created = created;
//    };

    // TODO: equals check

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Bug [id=" + id + ", status=" + status + ", title=" + title + ", created=" + created + "]";
    }
}
