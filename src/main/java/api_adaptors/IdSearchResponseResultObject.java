package api_adaptors;

public class IdSearchResponseResultObject {
    private String id;
    private String name;
    private String imgUrl;
    private String imgType;

    public IdSearchResponseResultObject(String id, String name, String imgUrl, String imgType) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.imgType = imgType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getImgType() {
        return imgType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }
}
