package gevorgyan.vahan.com.news.main.domain.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Source implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
