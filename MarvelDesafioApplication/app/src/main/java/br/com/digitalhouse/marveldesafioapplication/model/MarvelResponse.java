
package br.com.digitalhouse.marveldesafioapplication.model;

import com.google.gson.annotations.Expose;


public class MarvelResponse {

    @Expose
    private int code;
    @Expose
    private String status;
    @Expose
    private String copyright;
    @Expose
    private String attributionText;
    @Expose
    private String attributionHTML;
    @Expose
    private Data data;
    @Expose
    private String etag;


    public MarvelResponse() {
    }


    public MarvelResponse(int code, String status, String copyright, String attributionText, String attributionHTML, Data data, String etag) {
        super();
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.attributionText = attributionText;
        this.attributionHTML = attributionHTML;
        this.data = data;
        this.etag = etag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

}
