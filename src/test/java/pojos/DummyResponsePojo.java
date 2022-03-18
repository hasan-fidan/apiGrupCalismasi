package pojos;

import java.util.List;

public class DummyResponsePojo {



   private String status;
   private List<DummyPojo01> data;
   private String message;



    public String getStatus() {
        return status;
    }

    public List<DummyPojo01> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "DummyResponsePojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
