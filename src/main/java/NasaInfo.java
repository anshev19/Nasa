import com.fasterxml.jackson.annotation.JsonProperty;

public class NasaInfo {
    @JsonProperty("media_type")
    private String mediaType;
    @JsonProperty("service_version")
    private String serviceVersion;
    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String title;
    private String url;

    public NasaInfo() {
    }

    public NasaInfo(String copyright, String date, String explanation, String hdurl, String mediaType, String serviceVersion, String title, String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
